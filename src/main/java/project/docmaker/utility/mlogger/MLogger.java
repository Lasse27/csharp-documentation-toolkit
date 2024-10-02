package project.docmaker.utility.mlogger;


import org.jetbrains.annotations.NotNull;

import java.text.MessageFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


/**
 * The {@code Logger} class provides a logging utility with different modes of log messages, which are all formatted in their respective way. The provided levels are
 * {@link MLoggerMode#DEBUG}, {@link MLoggerMode#INFORMATION}, {@link MLoggerMode#WARNING} and {@link MLoggerMode#ERROR} and represent the different types of logging
 * messages.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen
 * @version 2.0.0
 * @see MLoggerMode
 * @since 27.09.2024
 */
public final class MLogger
{
	/**
	 * {@link String} constant representing an empty string.
	 */
	@NotNull
	private static final String EMPTY_STR = "";


	/**
	 * {@link String} constant representing the format for each logging section.
	 */
	@NotNull
	private static final String LOG_SECTION_FORMAT = "{0}[{1}]{2} ";


	/**
	 * {@link String} constant representing the format of the displayed timestamp.
	 */
	@NotNull
	private static final String TIME = "dd.MM.yyyy HH:mm:ss:SSS";


	/**
	 * {@link DateTimeFormatter} constant representing the DateTimeFormatter used to format the timestamp.
	 */
	@NotNull
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(TIME, Locale.GERMANY).withZone(ZoneId.systemDefault());



	/**
	 * Private constructor to prohibit instantiation of the class, since it's supposed to be a static class.
	 */
	private MLogger () {}



	/**
	 * Logs a message in the specified {@link MLoggerMode}.
	 * <br>
	 * The message only actually gets logged into the console if the log depth of the program is deeper or at least at the same depth as the desired log level.
	 *
	 * @param mLoggerMode The desired {@link MLoggerMode}.
	 * @param message     The message that's about to get logged.
	 */
	public static void logLn (final @NotNull MLoggerMode mLoggerMode, final String message)
	{
		final StringBuilder loggingBuilder = new StringBuilder();
		if (mLoggerMode.hasEnabledTimestamps())
		{
			loggingBuilder.append(MessageFormat.format(LOG_SECTION_FORMAT, EMPTY_STR, FORMATTER.format(Instant.now()), EMPTY_STR));
		}
		if (!mLoggerMode.getName().equals(EMPTY_STR))
		{
			loggingBuilder.append(MessageFormat.format(LOG_SECTION_FORMAT, mLoggerMode.getConsoleColor().toString(), mLoggerMode.getName(), ConsoleColor.NORM));
		}
		System.out.println(loggingBuilder.append(message));
	}



	/**
	 * Logs a message in the {@link MLoggerMode#INFORMATION} mode.
	 * <br>
	 * The message only actually gets logged into the console if the log depth of the program is deeper or at least at the same depth as the desired log level.
	 *
	 * @param message The message that's about to get logged.
	 */
	public static void logLn (final String message)
	{
		logLn(MLoggerMode.INFORMATION, message);
	}



	/**
	 * Logs a message in the specified {@link MLoggerMode}.
	 * <br>
	 * The message only actually gets logged into the console if the log depth of the program is deeper or at least at the same depth as the desired log level.
	 *
	 * @param mLoggerMode The desired {@link MLoggerMode}.
	 * @param message     The formatted message that's about to get logged.
	 * @param formats     The formats that'll be put into the message.
	 */
	public static void logLnf (final MLoggerMode mLoggerMode, final String message, final Object... formats)
	{
		logLn(mLoggerMode, MessageFormat.format(message, formats));
	}



	/**
	 * Logs a message in the specified {@link MLoggerMode}.
	 * <br>
	 * The message only actually gets logged into the console if the log depth of the program is deeper or at least at the same depth as the desired log level.
	 *
	 * @param mLoggerMode   The desired {@link MLoggerMode}.
	 * @param messageFormat The {@link MessageFormat} that's about to get logged.
	 * @param formats       The formats that'll be put into the message.
	 */
	public static void logLnf (final MLoggerMode mLoggerMode, final @NotNull MessageFormat messageFormat, final Object... formats)
	{
		logLn(mLoggerMode, messageFormat.format(formats));
	}



	/**
	 * Logs a message in the {@link MLoggerMode#INFORMATION} mode.
	 * <br>
	 * The message only actually gets logged into the console if the log depth of the program is deeper or at least at the same depth as the desired log level.
	 *
	 * @param message The formatted message that's about to get logged.
	 * @param formats The formats that'll be put into the message.
	 */
	public static void logLnf (final String message, final Object... formats)
	{
		logLnf(MLoggerMode.INFORMATION, message, formats);
	}



	public static void logEx (final @NotNull Exception exception)
	{
		MLogger.logLnf(MLoggerMode.ERROR, MessageFormat.format("{0}: {1}", exception.getClass().getSimpleName(), exception.getLocalizedMessage()));
		if (exception.getCause() != null)
		{
			final Throwable inner = exception.getCause();
			MLogger.logLnf(MLoggerMode.ERROR, MessageFormat.format("{0}: {1}", inner.getClass().getSimpleName(), inner.getLocalizedMessage()));
		}
		logStackTrace(exception.getStackTrace());
	}



	private static void logStackTrace (final StackTraceElement @NotNull [] stackTraceElements)
	{
		MLogger.logLnf(MLoggerMode.ERROR, "Printing exception stacktrace:");
		String module = EMPTY_STR;
		for (final StackTraceElement element : stackTraceElements)
		{
			if (!element.getModuleName().equals(module))
			{
				module = element.getModuleName();
				MLogger.logLnf(MLoggerMode.ERROR, "[Module: {0}]", module);
			}
			MLogger.logLnf(MLoggerMode.ERROR, "\t\t{0}", element.toString());
		}
	}



	public static void logMLoggable (final MLoggerMode mLoggerMode, final @NotNull MLoggable mLoggable)
	{
		for (final String stringPart : mLoggable.toStringCollection())
		{
			MLogger.logLn(mLoggerMode, stringPart);
		}
	}



	public static void logMLoggable (final MLoggable mLoggable)
	{
		MLogger.logMLoggable(MLoggerMode.INFORMATION, mLoggable);
	}
}
