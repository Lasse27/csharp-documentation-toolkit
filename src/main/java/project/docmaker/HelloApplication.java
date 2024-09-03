package project.docmaker;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.docmaker.control.MarkdownController;
import project.docmaker.control.SectionFactory;
import project.docmaker.model.CodeSnippet;
import project.docmaker.model.DocumentationTagList;
import project.docmaker.model.FileContent;
import project.docmaker.model.section.Body;
import project.docmaker.model.section.Footer;
import project.docmaker.model.section.Header;
import project.docmaker.model.section.implementation.ClassSection;
import project.docmaker.model.section.implementation.Description;
import project.docmaker.utility.logging.ILogger;
import project.docmaker.utility.logging.Logger;

import java.io.File;
import java.io.IOException;


public class HelloApplication extends Application
{
	private static final ILogger LOGGER = new Logger(HelloApplication.class.getSimpleName());



	public static void main (final String[] args)
	{
		LOGGER.log(ILogger.Level.NORMAL, "Reading the test file:");
		final FileContent fileContent = new FileContent(new File("src/main/resources/project/docmaker/testdocumentation.cs"));
		LOGGER.log(ILogger.Level.DEBUG, fileContent.getAsString());

		LOGGER.log(ILogger.Level.NORMAL, "Creating the classSection instance:");
		final ClassSection classSection = SectionFactory.CreateClassSection(fileContent);
		LOGGER.log(ILogger.Level.DEBUG, classSection.toString());

		System.out.println(MarkdownController.generateSection(classSection));
	}



	@Override
	public void start (final Stage stage) throws IOException
	{
		final FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
		final Scene scene = new Scene(fxmlLoader.load(), 320, 240);
		stage.setTitle("Hello!");
		stage.setScene(scene);
		stage.show();
	}

}