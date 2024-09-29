package project.docmaker;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import project.docmaker.utility.mlogger.MLogger;
import project.docmaker.utility.mlogger.MLoggerMode;

import java.net.URL;
import java.util.ResourceBundle;


public class MasterFormPresenter implements Initializable
{
	private double screenX = 0;

	private double screenY = 0;

	@FXML
	private Button aboutMenuButton;

	@FXML
	private Button closeMenuButton;

	@FXML
	private Button htmlGenerationMenuButton;

	@FXML
	private Button markdownGenerationMenuButton;

	@FXML
	private Button minimizeMenuButton;

	@FXML
	private Button settingsMenuButton;


	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state.
	 *
	 * @return A formatted {@link String} which represents the object in its current state.
	 */
	@Override
	public String toString ()
	{
		return super.toString();
	}


	/**
	 * Called to initialize a controller after its root element has been completely processed.
	 *
	 * @param location  The location used to resolve relative paths for the root object, or {@code null} if the location isn't known.
	 * @param resources The resources used to localize the root object, or {@code null} if the root object wasn't localized.
	 */
	@Override
	public void initialize (final URL location, final ResourceBundle resources)
	{
		MLogger.logLn(MLoggerMode.INFORMATION, "Initializing MasterFormPresenter");
	}


	@FXML
	private void onMenuBarDragged (final MouseEvent mouseEvent)
	{
		final Window window = ((Node) mouseEvent.getSource()).getParent().getScene().getWindow();
		window.setY(mouseEvent.getScreenY() - this.screenY);
		window.setX(mouseEvent.getScreenX() - this.screenX);
	}


	@FXML
	void onMinimizeMenuButtonClicked (final ActionEvent event)
	{
		final Stage stage = (Stage) ((Node) event.getSource()).getParent().getScene().getWindow();
		stage.setIconified(true);
	}


	@FXML
	void onCloseMenuButtonClicked (final ActionEvent event)
	{
		final Stage stage = (Stage) ((Node) event.getSource()).getParent().getScene().getWindow();
		stage.close();
	}


	@FXML
	void onMenuBarPressed (final MouseEvent mouseEvent)
	{
		this.screenX = mouseEvent.getSceneX();
		this.screenY = mouseEvent.getSceneY();
	}
}