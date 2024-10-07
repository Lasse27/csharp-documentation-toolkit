package project.docmaker;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.jetbrains.annotations.NotNull;
import project.docmaker.control.GenerationRunnable;
import project.docmaker.fxml.JobTreeItemFactory;
import project.docmaker.model.generation.GenerationJob;
import project.docmaker.model.generation.GenerationJobFactory;
import project.docmaker.model.generation.GenerationPattern;
import project.docmaker.utility.mlogger.MLogger;
import project.docmaker.utility.mlogger.MLoggerMode;
import project.docmaker.utility.serialize.Configuration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Objects;
import java.util.ResourceBundle;


public class MasterFormPresenter implements Initializable
{

	private static double screenX = 0;


	private static double screenY = 0;


	@FXML
	private URL url; // Value injected by constructor


	@FXML
	private TreeView<String> finishedJobsTreeView; // Value injected by FXMLLoader


	@FXML
	private TreeView<String> sourceFilesTreeView; // Value injected by FXMLLoader


	@FXML
	private TextField sourceFolderTextBox; // Value injected by FXMLLoader


	@FXML
	private TextField targetFolderTextBox; // Value injected by FXMLLoader


	@FXML
	private TreeView<String> targetFolderTreeView; // Value injected by FXMLLoader



	/**
	 * Called to initialize a controller after its root element has been completely processed.
	 *
	 * @param location  The location used to resolve relative paths for the root object, or {@code null} if the location isn't known.
	 * @param resources The resources used to localize the root object, or {@code null} if the root object wasn't localized.
	 */
	@Override
	public void initialize (final URL location, final ResourceBundle resources)
	{
		this.url = location;
		this.configureTextBoxes();
		this.configureTreeViews();

		MLogger.logLnf("Initialized: {0}", this.toString());
	}



	/**
	 * Called to configure and initialize the tree-views on the scene.
	 */
	private void configureTreeViews ()
	{
		final TreeItem<String> root = new TreeItem<>("Abgeschlossene Jobs");
		root.setExpanded(true);
		for (final GenerationJob generationJob : Program.CONFIGURATION.getFinishedJobs())
		{
			final TreeItem<String> treeItem = JobTreeItemFactory.createItem(generationJob);
			treeItem.setExpanded(false);
			root.getChildren().add(treeItem);
		}
		this.finishedJobsTreeView.setRoot(root);
	}



	/**
	 * Called to configure and initialize the text-boxes on the scene.
	 */
	private void configureTextBoxes ()
	{
		this.sourceFolderTextBox.textProperty().addListener((_, _, value) -> this.handleSourceFolderChanged(value));
		this.sourceFolderTextBox.setText(Program.CONFIGURATION.getLastSourceFolder());

		this.targetFolderTextBox.textProperty().addListener((_, _, value) -> this.handleTargetFolderChanged(value));
		this.targetFolderTextBox.setText(Program.CONFIGURATION.getLastTargetFolder());
	}



	/**
	 * Handles the event, when the text on the source folder textbox changes.
	 *
	 * @param value The new value of the source folder textbox.
	 */
	private void handleSourceFolderChanged (final String value)
	{
		Program.CONFIGURATION.setLastSourceFolder(value);
		final TreeItem<String> root = new TreeItem<>(this.sourceFolderTextBox.getText());
		root.setExpanded(true);
		for (final File file : Objects.requireNonNull(new File(this.sourceFolderTextBox.getText()).listFiles()))
		{
			if (file.isFile() && file.getName().endsWith(".cs"))
			{
				root.getChildren().add(new TreeItem<>(file.getName()));
			}
		}
		this.sourceFilesTreeView.setRoot(root);
	}



	/**
	 * Handles the event, when the text on the target folder textbox changes.
	 *
	 * @param value The new value of the target folder textbox.
	 */
	private void handleTargetFolderChanged (final String value)
	{
		Program.CONFIGURATION.setlastTargetFolder(value);
		final TreeItem<String> root = new TreeItem<>(this.targetFolderTextBox.getText());
		root.setExpanded(true);
		for (final File file : Objects.requireNonNull(new File(this.targetFolderTextBox.getText()).listFiles()))
		{
			root.getChildren().add(new TreeItem<>(file.getName()));
		}
		this.targetFolderTreeView.setRoot(root);
	}



	@FXML
	private void onMenuBarDragged (final @NotNull MouseEvent mouseEvent)
	{
		final Window window = ((Node) mouseEvent.getSource()).getParent().getScene().getWindow();
		window.setY(mouseEvent.getScreenY() - screenY);
		window.setX(mouseEvent.getScreenX() - screenX);
	}



	@FXML
	private void onMinimizeMenuButtonClicked (final @NotNull ActionEvent actionEvent)
	{
		final Stage stage = (Stage) ((Node) actionEvent.getSource()).getParent().getScene().getWindow();
		stage.setIconified(true);
	}



	@FXML
	private void onCloseMenuButtonClicked (final @NotNull ActionEvent actionEvent)
	{
		final Stage stage = (Stage) ((Node) actionEvent.getSource()).getParent().getScene().getWindow();
		try
		{
			Configuration.toJsonFile(Program.CONFIGURATION, new File("src/main/resources/project/docmaker/app_config.json"));
		}
		catch (final IOException e)
		{
			MLogger.logEx(e);
		}
		stage.close();
	}



	@FXML
	private void onMenuBarPressed (final @NotNull MouseEvent mouseEvent)
	{
		screenX = mouseEvent.getSceneX();
		screenY = mouseEvent.getSceneY();
	}



	@FXML
	void onSourceFolderPickerClicked (final ActionEvent actionEvent)
	{
		final File file = new File(this.sourceFolderTextBox.getText());
		final DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setTitle("Open Resource File");
		if (file.exists())
		{
			directoryChooser.setInitialDirectory(file);
		}
		else
		{
			MLogger.logLn(MLoggerMode.WARNING, "Der angegebene Dateipfad existiert nicht. Open Standardverzeichnis");
		}
		final File temp = directoryChooser.showDialog(((Node) actionEvent.getSource()).getParent().getScene().getWindow());
		this.sourceFolderTextBox.setText(temp != null ? temp.getAbsolutePath() : file.getAbsolutePath());
	}



	@FXML
	void onTargetFolderPickerClicked (final ActionEvent actionEvent)
	{
		final File file = new File(this.targetFolderTextBox.getText());
		final DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setTitle("Open Resource File");
		if (file.exists())
		{
			directoryChooser.setInitialDirectory(file);
		}
		else
		{
			MLogger.logLn(MLoggerMode.WARNING, "Der angegebene Dateipfad existiert nicht. Open Standardverzeichnis");
		}
		final File temp = directoryChooser.showDialog(((Node) actionEvent.getSource()).getParent().getScene().getWindow());
		this.targetFolderTextBox.setText(temp != null ? temp.getAbsolutePath() : file.getAbsolutePath());
	}



	@FXML
	void onClearAllClicked (final ActionEvent ignored)
	{
		this.sourceFolderTextBox.setText("");
		this.targetFolderTextBox.setText("");
	}



	@FXML
	void onGenerateNewJobClicked (final ActionEvent ignored)
	{
		final GenerationJob generationJob = GenerationJobFactory.createJob(new GenerationPattern(this.sourceFolderTextBox.getText(), this.targetFolderTextBox.getText()));
		Platform.runLater(new GenerationRunnable(generationJob));
		Program.CONFIGURATION.addFinishedJob(generationJob);
		this.finishedJobsTreeView.getRoot().getChildren().add(JobTreeItemFactory.createItem(generationJob));
	}



	@Override
	public String toString ()
	{
		return MessageFormat.format("{0} @ {1} [FXML={2}]", this.getClass().getSimpleName(), Integer.toHexString(this.hashCode()), this.url);
	}
}