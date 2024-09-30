package project.docmaker;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import project.docmaker.control.RegexController;
import project.docmaker.utility.mlogger.MLogger;
import project.docmaker.utility.mlogger.MLoggerMode;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;


public class Program extends Application
{

	public static void main (final String[] args) throws IOException
	{
		MLogger.logSeparator();
		MLogger.logLn(MLoggerMode.INFORMATION, "Application started");
		MLogger.logLnf(MLoggerMode.INFORMATION,  Arrays.deepToString(args));
		Application.launch(args);
	}



	@Override
	public void start (final Stage stage) throws IOException
	{
		try
		{
			final FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("Wireframing.fxml"));
			Program.initStage(stage, fxmlLoader);
			MLogger.logLnf(MLoggerMode.INFORMATION, "Showing on master stage: {0}", fxmlLoader.getController().getClass().getSimpleName());
			MLogger.logSeparator();
			RegexController.getSectionsFromFile(new File("src/main/resources/project/docmaker/Test-Model/Model/Actualization/ActualizationJobFactory.cs"));
		}
		catch (final Exception exception)
		{
			MLogger.logEx(exception);
			System.exit(1);
		}

	}



	private static void initStage (final Stage stage, final FXMLLoader fxmlLoader) throws IOException
	{
		stage.setScene(new Scene(fxmlLoader.load()));
		stage.setResizable(false);
		stage.sizeToScene();
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.show();
	}

}