package project.docmaker;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MasterForm
{

	@FXML
	private Label welcomeText;



	@FXML
	protected void onHelloButtonClick ()
	{
		this.welcomeText.setText("Welcome to JavaFX Application!");
	}

}