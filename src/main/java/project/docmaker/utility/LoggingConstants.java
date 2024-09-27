package project.docmaker.utility;


import org.jetbrains.annotations.NonNls;


/**
 * The interface {@code LoggingConstants} contains mainly mlogger messages for the output in the console.
 *
 * @author Lasse-Leander Hillen
 * @since 07.09.2024
 */
@ConstantInterface
public interface LoggingConstants
{
	/**
	 * Logging message for a creation of an instance.
	 */
	@NonNls
	String INSTANCE_CREATED_PTN = "Created instance: {0}";
}
