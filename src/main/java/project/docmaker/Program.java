package project.docmaker;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.docmaker.control.FileAnalyzer;
import project.docmaker.model.structure.section.implementation.ClassSection;
import project.docmaker.utility.logging.ILogger;
import project.docmaker.utility.logging.Logger;

import java.io.File;
import java.io.IOException;


public class Program extends Application
{
	private static final ILogger LOGGER = new Logger(Program.class.getSimpleName());



	public static void main (final String[] args) throws IOException
	{
		LOGGER.log(ILogger.Level.NORMAL, "Read the test file: \"src/main/resources/project/docmaker/testdocumentation.cs\"");
		final File file = new File("src/main/resources/project/docmaker/testdocumentation.cs");
		final ClassSection classDocumentation = FileAnalyzer.getDocumentation(file);
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