package project.docmaker;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import project.docmaker.control.GenerationRunnable;
import project.docmaker.model.generation.GenerationJob;
import project.docmaker.utility.argparser.ArgumentParser;
import project.docmaker.utility.argparser.JVMArgument;
import project.docmaker.utility.mlogger.LoggingMessages;
import project.docmaker.utility.mlogger.MLogger;

import java.io.File;
import java.time.Instant;
import java.util.Map;

import static project.docmaker.utility.mlogger.MLoggerMode.*;


/**
 * The main class of the application. This class launches the GUI window the user will interact with to. The class which inherits from {@link Application} is responsible for
 * loading any {@code .fxml} files.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen
 * @version 1.0.0
 * @see Application
 * @since 24.04.2024
 */
public class Program extends Application
{

	/**
	 * The URL to the FXML-file of the Masterform.
	 */
	private static final String MASTERFORM_FXML_URL = "MasterForm.fxml";



	/**
	 * Starts the JavaFX framework by invoking the launch method from the {@link Application} class. It isn't required to explicitly declare the main method, as the runtime
	 * environment will automatically invoke it anyway in a JavaFX project. Declaring it explicitly doesn't hurt though.
	 *
	 * @param args Contains the JVM arguments which have been passed into the program at the start.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen
	 */
	public static void main (final String[] args)
	{
		handleJVMArguments(args);
	}



	private static void handleJVMArguments (final String[] args)
	{
		// Collecting the starting arguments from the String[].
		final Map<JVMArgument, String> startingArguments = ArgumentParser.parse(args);

		// Setting the logging level
		final String depth = startingArguments.getOrDefault(JVMArgument.LOG_DEPTH, INFORMATION.name());
		MLogger.setDepth(valueOf(depth));
		MLogger.logLnf(DEBUG, LoggingMessages.LOGGING_DEPTH_CHANGED_PTN, MLogger.getDepth().toString());

		// Enabling the UI
		if (startingArguments.getOrDefault(JVMArgument.ENABLE_GUI, String.valueOf(false)).equals(String.valueOf(true)))
		{
			MLogger.logLn(DEBUG, LoggingMessages.APPLICATION_LAUNCHED_MSG);

			Platform.runLater(new GenerationRunnable(new GenerationJob(Instant.now(),
				new File("src/main/resources/project/docmaker/Test-Model/Model/Actualization"),
				new File("src/main/resources/project/docmaker/Test-Model/Model/Actualization"))));

			Application.launch(args);
		}
	}



	/**
	 * Loads the {@code .fxml} files and starts the GUI powered by JavaFX. {@inheritDoc}
	 *
	 * @param stage The {@link Stage} which will be displayed in the GUI window which pops up.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen
	 */
	@Override
	public void start (final Stage stage)
	{
		try
		{
			final FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource(MASTERFORM_FXML_URL));
			stage.setScene(new Scene(fxmlLoader.load()));
			stage.setResizable(false);
			stage.sizeToScene();
			stage.initStyle(StageStyle.UNDECORATED);
			stage.show();
			MLogger.logLnf(INFORMATION, LoggingMessages.SCENE_CHANGED_PTN, fxmlLoader.getController().getClass().getSimpleName());
		}
		catch (final Exception exception)
		{
			MLogger.logEx(exception);
			System.exit(1);
		}
	}
}