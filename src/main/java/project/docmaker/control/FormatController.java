package project.docmaker.control;

import project.docmaker.utility.logging.ILogger;
import project.docmaker.utility.logging.Logger;

import static project.docmaker.utility.constant.MiscConstants.*;

public class FormatController
{
	private static final ILogger LOGGER = new Logger(FormatController.class.getSimpleName());



	private FormatController ()
	{
	}



	public static String stripString (final String content)
	{
		final String stripped = content.strip();
		LOGGER.log(ILogger.Level.DEBUG, "Stripped string: " + stripped);
		return stripped;
	}



	public static String removeDocumentationMarks (final String content)
	{
		String modified = content.replaceAll(SLASH, EMPTY_STRING);
		LOGGER.log(ILogger.Level.DEBUG, "Removed Documentation-Marks: " + modified);
		modified = stripString(modified);
		return modified;
	}



	public static String removeLineBreaks (final String content)
	{
		return content.replaceAll(CARRIAGE_RETURN, EMPTY_STRING).replaceAll(NEW_LINE, EMPTY_STRING.replaceAll(TAB, EMPTY_STRING));
	}
}
