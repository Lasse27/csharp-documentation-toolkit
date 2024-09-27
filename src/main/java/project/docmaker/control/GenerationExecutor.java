package project.docmaker.control;


import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import project.docmaker.model.generation.GenerationJob;
import project.docmaker.model.structure.Section;
import project.docmaker.model.tag.Parameter;
import project.docmaker.utility.mlogger.MLogger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static project.docmaker.utility.mlogger.MLoggerMode.ERROR;
import static project.docmaker.utility.mlogger.MLoggerMode.INFORMATION;


public final class GenerationExecutor implements Runnable
{

	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Parameter#toString()} method gets called
	 */
	public static final String TEXT_DISPLAY_PATTERN = GenerationExecutor.class.getSimpleName() + "[job={0}]";

	/**
	 * The {@link GenerationJob} that contains the necessary information for the execution of the {@link GenerationExecutor}.
	 */
	private final GenerationJob job;


	/**
	 * Initializes a new instance of {@link GenerationExecutor} and sets all necessary attributes.
	 *
	 * @param job The {@link GenerationJob} that contains the necessary information for the execution of the {@link GenerationExecutor}.
	 */
	public GenerationExecutor (final GenerationJob job)
	{
		this.job = job;
	}


	/**
	 * {@inheritDoc} Executes the {@link GenerationJob} that contains the necessary information for the generation. Displays an alert on the
	 * screen if
	 * the generation has failed.
	 */
	@Override
	public void run ()
	{
		try
		{
			// Collect the files from the directory that need documentation to be generated.
			final File[] sourceFiles = this.collectSourceFiles();

			// Creating all the Markdown files in the target directory
			this.CreateMarkdownFiles(sourceFiles);
		}
		catch (final IOException ex)
		{
			MLogger.logLn(ERROR, "Error occurred");
			new Alert(Alert.AlertType.ERROR, ex.getLocalizedMessage(), ButtonType.OK).showAndWait();
		}
	}


	/**
	 * Gets all source code files from the source directory.
	 *
	 * @return An array of {@link File} objects representing the files in the source directory.
	 *
	 * @throws FileNotFoundException Throws an exception if the folder of the job is empty or no file ends with .cs
	 */
	private File[] collectSourceFiles () throws FileNotFoundException
	{
		final String[] sourceFileStrings = this.job.sourceFile().list((_, fileName) -> fileName.endsWith(".cs"));
		if (sourceFileStrings == null || sourceFileStrings.length == 0)
		{
			throw new FileNotFoundException("The source directory was empty or no .cs file could be found."); // TODO: Own type
		}
		return Arrays.stream(sourceFileStrings).map(file -> new File(this.job.sourceFile(), file)).toArray(File[]::new);
	}


	/**
	 * Creates the Markdown files for all passed source code files.
	 *
	 * @param files An array of {@link File} objects representing the files in the source directory.
	 *
	 * @throws IOException Throws an exception if one of the files couldn't be read.
	 */
	private void CreateMarkdownFiles (final File[] files) throws IOException
	{
		for (final File file : files)
		{
			// Collecting the sections from the source code of the file
			final Collection<Section> sections = new ArrayList<>();
			for (final CharSequence doc : RegexController.findDocumentations(Files.readString(file.toPath())))
			{
				sections.add(RegexController.getSectionFromString((String) doc));
			}

			// Creating the target Markdown file
			final String targetFileName = file.getName().replaceFirst("[.][^.]+$", ".md");
			MarkdownController.createMarkdownFile(new File(this.job.targetFile(), targetFileName), sections);
			MLogger.logLn(INFORMATION, STR."\{targetFileName} created...");
		}
	}


	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state.
	 *
	 * @return A formatted {@link String} which represents the object in its current state.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TEXT_DISPLAY_PATTERN, this.job);
	}
}
