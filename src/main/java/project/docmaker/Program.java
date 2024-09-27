package project.docmaker;


import javafx.application.Application;
import javafx.css.Match;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.intellij.lang.annotations.Language;
import org.intellij.lang.annotations.RegExp;

import java.io.IOException;


public class Program extends Application
{

	public static void main (final String[] args) throws IOException
	{
		@Language("RegExp")
		String method_pattern = "\\b(public|private|internal|protected)\\s*\\b(static|virtual|abstract)?\\s*[a-zA-Z]*(?<method>\\s[a-zA-Z]+\\s*)" + @
		"\"(([a-zA-Z\[\]\<\>]*\s*[a-zA-Z]*\s*)[,]?\s*)+\)";
		while ((line = file.ReadLine()) != null)
		{
			Regex expression = new Regex(method_pattern);
			Match match = expression.Match(line);
			if (match.Success)
			{
				string result = match.Groups["method"].Value;
				MessageBox.Show(result);
			}
		}


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