package project.docmaker;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.docmaker.control.RegexController;
import project.docmaker.model.section.Section;
import project.docmaker.utility.logging.ILogger;
import project.docmaker.utility.logging.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;


public class Program extends Application
{
	private static final ILogger LOGGER = new Logger(Program.class.getSimpleName());



	public static void main (final String[] args) throws IOException
	{
		LOGGER.log(ILogger.Level.NORMAL, "Read the test file: \"src/main/resources/project/docmaker/testdocumentation.cs\"");
		final File file = new File("src/main/resources/project/docmaker/testdocumentation.cs");
		final Collection<CharSequence> docs = RegexController.findAllDocumentations(Files.readString(file.toPath()));
		for (final CharSequence doc : docs)
		{
			final Section section = RegexController.getSectionFromCharSequence((String) doc);
			section.toStringCollection().forEach(info -> LOGGER.log(ILogger.Level.NORMAL, info));
		}
	}



	@Override
	public void start (final Stage stage) throws IOException
	{
		final FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("hello-view.fxml"));
		final Scene scene = new Scene(fxmlLoader.load(), 320, 240);
		stage.setTitle("Hello!");
		stage.setScene(scene);
		stage.show();
	}

}