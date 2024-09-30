package project.docmaker;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import project.docmaker.control.GenerationRunnable;
import project.docmaker.model.generation.GenerationJobFactory;
import project.docmaker.model.generation.GenerationPattern;
import project.docmaker.utility.mlogger.MLogger;
import project.docmaker.utility.mlogger.MLoggerMode;

import java.util.Arrays;


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
	 * Starts the JavaFX framework by invoking the launch method from the {@link Application} class. It isn't required to explicitly declare the main method, as the runtime
	 * environment will automatically invoke it anyway in a JavaFX project. Declaring it explicitly doesn't hurt though.
	 *
	 * @param args Contains the JVM arguments which have been passed into the program at the start.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen
	 */
	public static void main (final String[] args)
	{
		MLogger.logLn("Application started");
		MLogger.logLnf("Starting arguments: {0}", Arrays.deepToString(args));
		Platform.runLater(new GenerationRunnable(GenerationJobFactory.createJob(new GenerationPattern(
				"src/main/resources/project/docmaker/Test-Model/Model/Actualization",
				"src/main/resources/project/docmaker/Test-Model/Model/Actualization"))));
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
			final FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("MasterForm.fxml"));
			stage.setScene(new Scene(fxmlLoader.load()));
			stage.setResizable(false);
			stage.sizeToScene();
			stage.initStyle(StageStyle.UNDECORATED);
			stage.show();
			MLogger.logLnf(MLoggerMode.INFORMATION, "Showing on master stage: {0}", fxmlLoader.getController().getClass().getSimpleName());
		}
		catch (final Exception exception)
		{
			MLogger.logEx(exception);
			System.exit(1);
		}
	}
}