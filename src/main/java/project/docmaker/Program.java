package project.docmaker;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import project.docmaker.utility.mlogger.MLogger;

import java.io.IOException;


public class Program extends Application
{

	public static void main (final String[] args) throws IOException
	{
		MLogger.logLn((STR."\{Application.class.getSimpleName()} launched!"));
		Application.launch(args);
	}


	@Override
	public void start (final Stage stage) throws IOException
	{
		final FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("Wireframing.fxml"));
		final Scene scene = new Scene(fxmlLoader.load());
		stage.setScene(scene);
		stage.setResizable(false);
		stage.sizeToScene();
		stage.initStyle(StageStyle.UNDECORATED);
		stage.show();
	}

}