package project.docmaker.utility.mlogger;


import org.jetbrains.annotations.NonNls;


/**
 * The interface {@code LoggingConstants} contains mainly logger messages for the output in the console.
 *
 * @author Lasse-Leander Hillen
 * @since 07.09.2024
 */
@ConstantInterface
public interface LoggingMessages
{
	/**
	 * Logging message for a creation of an instance.
	 */
	@NonNls String APPLICATION_LAUNCHED_MSG = "Launching the main application.";

	/**
	 * Logging message for the change of the scene in the main stage.
	 */
	@NonNls String SCENE_CHANGED_PTN = "Changed the scene on the main stage to: {0}.";

	/**
	 * Logging message for the change of the logging depth.
	 */
	@NonNls String LOGGING_DEPTH_CHANGED_PTN = "Logging depth set to {0}.";
}
