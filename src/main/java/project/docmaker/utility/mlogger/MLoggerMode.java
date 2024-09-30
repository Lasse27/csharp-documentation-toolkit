package project.docmaker.utility.mlogger;


import org.jetbrains.annotations.NotNull;

import java.text.MessageFormat;


public record MLoggerMode(String name, ConsoleColor consoleColor, boolean enableTimestamps)
{
	/**
	 * The verbose {@code MLoggerMode} level.
	 * <br>
	 * The verbose {@code MLoggerMode} level is used to display information without any formatting.
	 */
	@NotNull
	public static final MLoggerMode VERBOSE = new MLoggerMode("", ConsoleColor.NORM, false);

	/**
	 * The lowest {@code MLoggerMode} level.
	 * <br>
	 * The debug {@code MLoggerMode} level is used to display the finest information in cyan formatting.
	 */
	@NotNull
	public static final MLoggerMode DEBUG = new MLoggerMode("DEBUGGING", ConsoleColor.CYAN, true);

	/**
	 * The default {@code MLoggerMode} level.
	 * <br>
	 * The normal {@code MLoggerMode} level is used to display general information in green formatting.
	 */
	@NotNull
	public static final MLoggerMode INFORMATION = new MLoggerMode("INFORMATION", ConsoleColor.GREEN, true);

	/**
	 * A higher {@code MLoggerMode} level than normal, but not the highest.
	 * <br>
	 * The warning {@code MLoggerMode} level is used to display warnings and important information in yellow formatting.
	 */
	@NotNull
	public static final MLoggerMode WARNING = new MLoggerMode("WARNING", ConsoleColor.YELLOW, true);

	/**
	 * The highest {@code MLoggerMode} level.
	 * <br>
	 * The error {@code MLoggerMode} level is used to display only error messages in red formatting.
	 */
	@NotNull
	public static final MLoggerMode ERROR = new MLoggerMode("ERROR", ConsoleColor.RED, true);

	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link MLoggerMode#toString()} method gets called
	 */
	@NotNull
	private static final String TO_STRING_PATTERN = "MLoggerMode'{'name=''{0}'', consoleColor={1}, enableTimestamps={2}'}'";


	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state.
	 *
	 * @return A formatted {@link String} which represents the object in its current state.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.name, this.consoleColor, this.enableTimestamps);
	}
}
