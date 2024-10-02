package project.docmaker;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.jetbrains.annotations.NotNull;
import project.docmaker.model.generation.GenerationJob;
import project.docmaker.utility.mlogger.MLogger;
import project.docmaker.view.JobTreeItemFactory;

import java.io.File;
import java.net.URL;
import java.time.Instant;
import java.util.ResourceBundle;


public class MasterFormPresenter implements Initializable
{

	private double screenX = 0;


	private double screenY = 0;


	@FXML
	private TreeView<String> finishedJobsTreeView;


	@FXML
	private Button htmlGenerationMenuButton1;


	@FXML
	private Button markdownGenerationMenuButton1;


	@FXML
	private TreeView<?> queuedJobsTreeView;


	@FXML
	private Button settingsMenuButton1;


	@FXML
	private TreeView<?> sourceFilesTreeView;


	@FXML
	private TextField sourceFolderTextBox;


	@FXML
	private HBox targetFolderTextBox;


	@FXML
	private TreeView<?> targetFolderTreeView;



	/**
	 * Called to initialize a controller after its root element has been completely processed.
	 *
	 * @param location  The location used to resolve relative paths for the root object, or {@code null} if the location isn't known.
	 * @param resources The resources used to localize the root object, or {@code null} if the root object wasn't localized.
	 */
	@Override
	public void initialize (final URL location, final ResourceBundle resources)
	{
		MLogger.logLn("Initializing MasterFormPresenter");
		final TreeItem<String> root = new TreeItem<>("Abgeschlossene Jobs");
		root.setExpanded(true);
		root.getChildren().add(JobTreeItemFactory.createItem(new GenerationJob(Instant.now(),
			new File("src/main/resources/project/docmaker/Test-Model/Model/Actualization"),
			new File("src/main/resources/project/docmaker/Test-Model/Model/Actualization"))));
		this.finishedJobsTreeView.setRoot(root);
	}



	@FXML
	private void onMenuBarDragged (final @NotNull MouseEvent mouseEvent)
	{
		final Window window = ((Node) mouseEvent.getSource()).getParent().getScene().getWindow();
		window.setY(mouseEvent.getScreenY() - this.screenY);
		window.setX(mouseEvent.getScreenX() - this.screenX);
	}



	@FXML
	void onMinimizeMenuButtonClicked (final @NotNull ActionEvent actionEvent)
	{
		final Stage stage = (Stage) ((Node) actionEvent.getSource()).getParent().getScene().getWindow();
		stage.setIconified(true);
	}



	@FXML
	void onCloseMenuButtonClicked (final @NotNull ActionEvent actionEvent)
	{
		final Stage stage = (Stage) ((Node) actionEvent.getSource()).getParent().getScene().getWindow();
		stage.close();
	}



	@FXML
	void onMenuBarPressed (final @NotNull MouseEvent mouseEvent)
	{
		this.screenX = mouseEvent.getSceneX();
		this.screenY = mouseEvent.getSceneY();
	}
}