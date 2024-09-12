package project.docmaker.model.generation;

import javafx.scene.control.Alert;
import project.docmaker.MasterFormController;
import project.docmaker.control.MarkdownController;
import project.docmaker.control.RegexController;
import project.docmaker.model.structure.Section;
import project.docmaker.utility.ILogger;
import project.docmaker.utility.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class GenerationExecutor implements Runnable
{
	private final GenerationJob job;



	public GenerationExecutor (final GenerationJob job)
	{
		this.job = job;
	}



	/**
	 * Runs this operation.
	 */
	@Override
	public void run ()
	{
		// Getting all source code files from the source directory
		final String[] sourceFileStrings = this.job.sourcePath().toFile().list((_, name) -> name.endsWith(".cs"));
		if (sourceFileStrings == null || sourceFileStrings.length == 0)
		{
			new Logger(MasterFormController.class.getSimpleName()).log(ILogger.Level.WARNING, "The source directory was empty or no .cs file could" +
			                                                                                  " " +
			                                                                                  "be found.");
			final Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Empty-Dir-Alert");
			alert.setHeaderText("The source directory was empty or no .cs file could be found.");
			alert.showAndWait();
			return;
		}
		final File[] sourceFiles = Arrays.stream(sourceFileStrings).map(file -> new File(this.job.sourcePath().toFile(), file)).toArray(File[]::new);

		// Creating all the Markdown files in the target directory
		for (final File file : sourceFiles)
		{
			this.CreateMarkdownFile(file);
		}

		// Logging the finalization of the runnable
		new Logger(MasterFormController.class.getSimpleName()).log(ILogger.Level.NORMAL, "Creation of Markdown files finished");
		final Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Markdown-Files-Created");
		alert.setHeaderText("Creation of Markdown files finished");
		alert.showAndWait();
	}



	private void CreateMarkdownFile (final File file)
	{
		try
		{
			final Collection<Section> sections = new ArrayList<>();
			for (final CharSequence doc : RegexController.findAllDocumentations(Files.readString(file.toPath())))
			{
				sections.add(RegexController.getSectionFromCharSequence((String) doc));
			}
			MarkdownController.createMarkdownFile(
					new File(this.job.targetPath().toFile(), file.getName().replaceFirst("[.][^.]+$", ".md")), sections);
		}
		catch (final IOException e)
		{
			new Logger(MasterFormController.class.getSimpleName()).log(ILogger.Level.WARNING, e.getMessage());
			final Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Markdown-Alert");
			alert.setHeaderText("The Markdown file of " + file.getAbsolutePath() + " couldn't be created");
			alert.showAndWait();
		}
	}
}
