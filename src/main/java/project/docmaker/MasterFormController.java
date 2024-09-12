package project.docmaker;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import project.docmaker.model.generation.GenerationExecutor;
import project.docmaker.model.generation.GenerationJob;
import project.docmaker.model.generation.GenerationJobFactory;
import project.docmaker.model.generation.GenerationPattern;
import project.docmaker.utility.ILogger;
import project.docmaker.utility.Logger;
import project.docmaker.utility.NoLogger;

import java.io.File;
import java.io.IOException;


/**
 * The {@code MasterFormController} class mainly provides event handlers for events that occur on the MasterForm-GUI.
 *
 * @author Lasse-Leander Hillen
 * @see Stage
 * @see ComboBox
 * @see EventHandler
 * @since 12.09.2024
 */
@NoLogger
public class MasterFormController
{
	@FXML
	private ListView<?> finishedFoldersLV;

	@FXML
	private ListView<?> foundFilesLV;

	@FXML
	private ComboBox<String> sourceFolderCB;

	@FXML
	private ComboBox<String> targetFolderCB;



	/**
	 * Event which occurs when the User presses the "Generate new"-Button at the bottom of the GUI.
	 *
	 * @param ignored Event-Arguments that are passed with the event. They can be used to find out who sent the event, etc.
	 */
	@FXML
	void onGenerateNew (final ActionEvent ignored)
	{
		try
		{
			final GenerationPattern pattern = new GenerationPattern(this.sourceFolderCB.getValue(), this.targetFolderCB.getValue());
			final GenerationJob generationJob = GenerationJobFactory.createJob(pattern);
			Platform.runLater(new GenerationExecutor(generationJob));
		}
		catch (final Exception e)
		{
			new Logger(MasterFormController.class.getSimpleName()).log(ILogger.Level.WARNING, e.getMessage());
			final Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Warning-Alert");
			alert.setHeaderText("Exception occurred while trying to generate Markdown.");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}

	}



	/**
	 * Event which occurs when the User presses the "Open Source Folder"-Button at the bottom of the GUI.
	 *
	 * @param ignored Event-Arguments that are passed with the event. They can be used to find out who sent the event, etc.
	 */
	@FXML
	void onOpenSourceFolder (final ActionEvent ignored)
	{
		try
		{
			Runtime.getRuntime().exec("explorer.exe /select," + this.sourceFolderCB.getValue());
		}
		catch (final IOException e)
		{
			new Logger(MasterFormController.class.getSimpleName()).log(ILogger.Level.WARNING, e.getMessage());
			final Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("SourceFolder-Alert");
			alert.setHeaderText("Exception occurred while trying to open SourceFolder.");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}



	/**
	 * Event which occurs when the User presses the "Open Target Folder"-Button at the bottom of the GUI.
	 *
	 * @param ignored Event-Arguments that are passed with the event. They can be used to find out who sent the event, etc.
	 */
	@FXML
	void onOpenTargetFolder (final ActionEvent ignored)
	{
		try
		{
			Runtime.getRuntime().exec("explorer.exe /select," + this.sourceFolderCB.getValue());
		}
		catch (final IOException e)
		{
			new Logger(MasterFormController.class.getSimpleName()).log(ILogger.Level.WARNING, e.getMessage());
			final Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("TargetFolder-Alert");
			alert.setHeaderText("Exception occurred while trying to open TargetFolder.");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}



	/**
	 * Event which occurs when the User presses the Folder-Picker-Button at the combobox of the GUI.
	 *
	 * @param ignored Event-Arguments that are passed with the event. They can be used to find out who sent the event, etc.
	 */
	@FXML
	void onPickSourceFolder (final ActionEvent ignored)
	{
		final DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setTitle("Choose a source folder...");
		directoryChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
		final File chosenFile = directoryChooser.showDialog(Program.stage);
		if (chosenFile != null)
		{
			this.sourceFolderCB.setValue(chosenFile.getAbsolutePath());
		}
	}



	/**
	 * Event which occurs when the User presses the Folder-Picker-Button at the combobox of the GUI.
	 *
	 * @param ignored Event-Arguments that are passed with the event. They can be used to find out who sent the event, etc.
	 */
	@FXML
	void onPickTargetFolder (final ActionEvent ignored)
	{
		final DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setTitle("Choose a target folder...");
		directoryChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
		final File chosenFile = directoryChooser.showDialog(Program.stage);
		if (chosenFile != null)
		{
			this.targetFolderCB.setValue(chosenFile.getAbsolutePath());
		}
	}



	/**
	 * Event which occurs when the User presses the "Reset all"-Button at the bottom of the GUI.
	 *
	 * @param ignored Event-Arguments that are passed with the event. They can be used to find out who sent the event, etc.
	 */
	@FXML
	void onResetAll (final ActionEvent ignored)
	{
		this.sourceFolderCB.setValue("");
		this.targetFolderCB.setValue("");
		this.finishedFoldersLV.getItems().clear();
		this.foundFilesLV.getItems().clear();
	}



	/**
	 * Event which occurs when the User presses the text within the SourceFolderCB changes.
	 *
	 * @param ignored Event-Arguments that are passed with the event. They can be used to find out who sent the event, etc.
	 */
	@FXML
	void onSourceFolderCB_TextChanged (final ActionEvent ignored)
	{
		if (!this.sourceFolderCB.getValue().isBlank())
		{
			this.sourceFolderCB.getItems().add(this.sourceFolderCB.getValue());
		}
	}



	/**
	 * Event which occurs when the User presses the text within the TargetFolderCB changes.
	 *
	 * @param ignored Event-Arguments that are passed with the event. They can be used to find out who sent the event, etc.
	 */
	@FXML
	void onTargetFolderCB_TextChanged (final ActionEvent ignored)
	{
		if (!this.targetFolderCB.getValue().isBlank())
		{
			this.targetFolderCB.getItems().add(this.targetFolderCB.getValue());
		}
	}



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
}