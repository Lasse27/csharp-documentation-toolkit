package project.docmaker;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.docmaker.model.ClassSection;
import project.docmaker.model.DocumentationTag;

import java.io.IOException;


public class HelloApplication extends Application
{

	public static void main (final String[] args)
	{
		final ClassSection classSection = new ClassSection("Klassenname", "Selbst geschriebenes Kommentar", new DocumentationTag());

		// launch();

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