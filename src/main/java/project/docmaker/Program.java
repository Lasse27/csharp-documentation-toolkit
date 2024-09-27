package project.docmaker;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import project.docmaker.control.MarkdownController;
import project.docmaker.control.RegexController;
import project.docmaker.model.structure.Section;
import project.docmaker.utility.mlogger.MLogger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;

import static project.docmaker.utility.mlogger.MLoggerMode.INFORMATION;


public class Program extends Application
{

	public static Stage stage = null;


	public static void main (final String[] args) throws IOException
	{
		MLogger.logLn(INFORMATION, "Read the test file: \"src/main/resources/project/docmaker/Test-Model/Model/Actualization/ActualizationJob.cs\"");
		final File file = new File("src/main/resources/project/docmaker/Test-Model/Model/Actualization/ActualizationJob.cs");
		final Collection<Section> sections = new ArrayList<>();
		for (final CharSequence doc : RegexController.findDocumentations(Files.readString(file.toPath())))
		{
			final Section section = RegexController.getSectionFromString((String) doc);
			section.toStringCollection().forEach(info -> MLogger.logLn(INFORMATION, info));
			sections.add(section);
		}
		MarkdownController.createMarkdownFile(new File("src/main/resources/project/docmaker/Test-Model/Model/Actualization/ActualizationJob.md"),
				sections);
		Application.launch(args);
	}


	@Override
	public void start (final Stage stage) throws IOException
	{
		final FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("Wireframing.fxml"));
		final Scene scene = new Scene(fxmlLoader.load());
		Program.stage = stage;
		Program.stage.setScene(scene);
		Program.stage.setResizable(false);
		Program.stage.sizeToScene();
		Program.stage.initStyle(StageStyle.UNDECORATED);
		Program.stage.show();
	}

}