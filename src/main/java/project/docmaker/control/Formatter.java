package project.docmaker.control;

import project.docmaker.utility.logging.ILogger;
import project.docmaker.utility.logging.Logger;

import static project.docmaker.utility.constant.MiscConstants.EMPTY_STRING;
import static project.docmaker.utility.constant.MiscConstants.TRIPLE_SLASH;

public class Formatter
{
	private static final ILogger LOGGER = new Logger(Formatter.class.getSimpleName());



	private Formatter ()
	{
	}



	public static String removeUnwantedWhiteSpaces (final String content)
	{
		return content.trim().replaceAll(" +", " ");
	}



	public static String stripString (final String content)
	{
		final String stripped = content.strip();
		LOGGER.log(ILogger.Level.DEBUG, "Stripped string: " + stripped);
		return stripped;
	}



	public static String removeDocMarks (final String content)
	{
		String modified = content.replaceAll(TRIPLE_SLASH, EMPTY_STRING);
		LOGGER.log(ILogger.Level.DEBUG, "Removed Documentation-Marks: " + modified);
		modified = stripString(modified);
		return modified;
	}



	public static String removeSpecialCharacters (final String content)
	{
		String cleansedSequence = content;
		cleansedSequence = cleansedSequence.replaceAll("\n", "");
		cleansedSequence = cleansedSequence.replaceAll("\t", "");
		cleansedSequence = cleansedSequence.replaceAll("\r", "");
		cleansedSequence = Formatter.removeUnwantedWhiteSpaces(cleansedSequence);
		return cleansedSequence;
	}
}
