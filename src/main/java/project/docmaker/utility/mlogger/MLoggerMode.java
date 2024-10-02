package project.docmaker.utility.mlogger;


import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import project.docmaker.utility.stringutils.StringController;

import java.text.MessageFormat;


public enum MLoggerMode
{
	/**
	 * The lowest {@code MLoggerMode} level.
	 * <br>
	 * The debug {@code MLoggerMode} level is used to display the finest information in cyan formatting.
	 */
	DEBUG("DEBUG", ConsoleColor.CYAN, true),


	/**
	 * The default {@code MLoggerMode} level.
	 * <br>
	 * The normal {@code MLoggerMode} level is used to display general information in green formatting.
	 */
	INFORMATION("INFORMATION", ConsoleColor.GREEN, true),


	/**
	 * The JVM-Argument-Parser {@code MLoggerMode} level.
	 * <br>
	 * The {@code MLoggerMode} level used to display general information about the jvm-argument-parsing.
	 */
	JVM("JVM-ARGUMENT-PARSER", ConsoleColor.MAGENTA, true),


	/**
	 * A higher {@code MLoggerMode} level than normal, but not the highest.
	 * <br>
	 * The warning {@code MLoggerMode} level is used to display warnings and important information in yellow formatting.
	 */
	WARNING("WARNING", ConsoleColor.YELLOW, true),


	/**
	 * The highest {@code MLoggerMode} level.
	 * <br>
	 * The error {@code MLoggerMode} level is used to display only error messages in red formatting.
	 */
	ERROR("ERROR", ConsoleColor.RED, true),


	/**
	 * The verbose {@code MLoggerMode} level.
	 * <br>
	 * The verbose {@code MLoggerMode} level is used to display information without any formatting.
	 */
	VERBOSE("", ConsoleColor.NORM, false);


	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link MLoggerMode#toString()} method gets called
	 */
	private static final String TEXT_FORMAT = "{0} @ {1} ({2}) [name={3}, consoleColor={4}, enableTimestamps={5}]";


	private static final int PREFIX_LEN = 5;


	private final ConsoleColor consoleColor;


	private final boolean enableTimestamps;


	private String name;



	MLoggerMode (final @NotNull String name, final ConsoleColor consoleColor, final boolean enableTimestamps)
	{
		this.name = name.length() > PREFIX_LEN ? name.substring(0, PREFIX_LEN) : StringController.paddedRightString(name, PREFIX_LEN);
		this.consoleColor = consoleColor;
		this.enableTimestamps = enableTimestamps;
	}



	/**
	 * Returns the display name of the {@link MLoggerMode}.
	 *
	 * @return A String that represents the display name of the {@link MLoggerMode}.
	 */
	@Contract (pure = true)
	public String getName ()
	{
		return this.name;
	}



	@Contract (mutates = "this")
	private void setName (final String name)
	{
		this.name = name;
	}



	/**
	 * Returns the displayed {@link ConsoleColor} of the {@link MLoggerMode}.
	 *
	 * @return A {@link ConsoleColor} that represents the displayed color of the console for the {@link MLoggerMode}.
	 */
	@Contract (pure = true)
	public ConsoleColor getConsoleColor ()
	{
		return this.consoleColor;
	}



	/**
	 * Returns a boolean that shows if the {@link MLoggerMode} logs timestamps.
	 *
	 * @return A boolean that shows if the {@link MLoggerMode} logs timestamps.
	 */
	@Contract (pure = true)
	public boolean hasEnabledTimestamps ()
	{
		return this.enableTimestamps;
	}



	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state.
	 *
	 * @return A formatted {@link String} which represents the object in its current state.
	 */
	@Override
	public @NotNull String toString ()
	{
		return MessageFormat.format(TEXT_FORMAT, this.getClass()
			                                         .getSimpleName(), Integer.toHexString(this.hashCode()), this.name(), this.name, this.consoleColor,
			this.enableTimestamps);
	}
}
