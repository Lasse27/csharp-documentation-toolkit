package project.doc_maker;


import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class HelloController
{

	@FXML
	private Label welcomeText;


	@FXML
	protected void onHelloButtonClick ()
	{
		this.welcomeText.setText("Welcome to JavaFX Application!");
	}

}