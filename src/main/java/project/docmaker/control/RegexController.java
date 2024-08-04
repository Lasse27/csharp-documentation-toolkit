package project.docmaker.control;


import project.docmaker.model.Regex;
import project.docmaker.utility.constant.MiscConstants;
import project.docmaker.utility.logging.ILogger;
import project.docmaker.utility.logging.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 */
public final class RegexController
{
	/**
	 * A {@link Logger} object, which is being used to write formatted outputs into the console.
	 */
	private static final ILogger LOGGER = new Logger(RegexController.class.getSimpleName());



	/**
	 * Private constructor since controller class isn't supposed to be initialized ever.
	 */
	private RegexController ()
	{
	}



	public static String matchFirst (final Regex regex, final CharSequence content)
	{
		final Pattern pattern = regex.getPattern();
		final Matcher matcher = pattern.matcher(content);
		if (matcher.find())
		{
			LOGGER.log(ILogger.Level.DEBUG, (String) content.subSequence(matcher.start(), matcher.end()));
			return (String) content.subSequence(matcher.start(), matcher.end());
		}
		return MiscConstants.EMPTY_STRING;
	}



	public static String[] getAllMatches (final Regex regex, final CharSequence content)
	{
		final Pattern pattern = regex.getPattern();
		final Matcher matcher = pattern.matcher(content);
		final Collection<String> matches = new ArrayList<>();
		while (matcher.find())
		{
			LOGGER.log(ILogger.Level.DEBUG, (String) content.subSequence(matcher.start(), matcher.end()));
			matches.add((String) content.subSequence(matcher.start(), matcher.end()));
		}
		return matches.toArray(String[]::new);
	}

}
