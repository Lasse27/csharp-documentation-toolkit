package project.docmaker;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import org.jetbrains.annotations.NotNull;
import project.docmaker.control.GenerationRunnable;
import project.docmaker.model.generation.GenerationJob;
import project.docmaker.utility.argparser.ArgumentParser;
import project.docmaker.utility.argparser.JVMArgument;
import project.docmaker.utility.mlogger.LoggingMessages;
import project.docmaker.utility.mlogger.MLogger;
import project.docmaker.utility.serialize.Configuration;
import project.docmaker.utility.serialize.JsonFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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


	private static final File CONFIGURATION_FILE = new File("C:\\Users\\lh\\Desktop\\app_config.json");


	public static final Configuration CONFIGURATION = Program.loadProgramConfiguration();

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



	private static Configuration loadProgramConfiguration ()
	{
		try
		{
			if (!Files.exists(Path.of("app_config.json")))
			{
				Configuration.toJsonFile(new Configuration(), new File("app_config.json"));
			}
			return Configuration.fromJsonFile(new File("app_config.json"));
		}
		catch (final IOException e)
		{
			MLogger.logLn("Exception occurred while reading Configuration \u2192 Exiting program.");
			System.exit(1);
			return null;
		}
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
			MLogger.logLnf(INFORMATION, LoggingMessages.APPLICATION_LAUNCHED_MSG);
		}
		Application.launch(args);
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
			stage.setOnCloseRequest(windowEvent -> handleCloseRequest(stage, windowEvent));
			stage.show();
			MLogger.logLnf(INFORMATION, LoggingMessages.SCENE_CHANGED_PTN, fxmlLoader.getLocation());
		}
		catch (final Exception exception)
		{
			MLogger.logEx(exception);
			System.exit(1);
		}
	}



	private static void handleCloseRequest (final Stage stage, final @NotNull WindowEvent windowEvent)
	{
		try
		{
			Configuration.toJsonFile(Program.CONFIGURATION, new File("src/main/resources/project/docmaker/app_config.json"));
		}
		catch (final IOException e)
		{
			MLogger.logEx(e);
		}
	}
}