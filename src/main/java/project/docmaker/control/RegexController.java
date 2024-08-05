package project.docmaker.control;


import project.docmaker.model.Regex;
import project.docmaker.utility.logging.ILogger;
import project.docmaker.utility.logging.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static project.docmaker.utility.constant.MiscConstants.EMPTY_STRING;


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



	public static String matchFirst (final Regex regex, final String content)
	{
		final String editedContent = FormatController.removeLineBreaks(content);
		final Pattern pattern = regex.getPattern();
		final Matcher matcher = pattern.matcher(editedContent);

		String result = EMPTY_STRING;
		if (matcher.find())
		{
			LOGGER.log(ILogger.Level.DEBUG, "Match: " + matcher.group());
			result = matcher.group();
		}
		return result;
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



	public static String matchSummary (final String content)
	{
		final String editedContent = FormatController.removeLineBreaks(content);
		final Pattern summaryPattern = Pattern.compile("/// <summary>([\\s\\S]*?)</summary>");
		final Matcher summaryMatcher = summaryPattern.matcher(editedContent);
		String result = EMPTY_STRING;
		if (summaryMatcher.find())
		{
			result = summaryMatcher.group(1);
		}
		return result;
	}



	public static String[][] matchParams (final String content)
	{
		final String editedContent = FormatController.removeLineBreaks(content);
		final Pattern paramPattern = Pattern.compile("/// <param name=\"([^\"]+)\">([\\s\\S]*?)</param>");
		final Matcher paramMatcher = paramPattern.matcher(editedContent);
		final Collection<String[]> results = new ArrayList<>();
		while (paramMatcher.find())
		{
			results.add(new String[]{FormatController.removeDocumentationMarks(paramMatcher.group(1)),
					FormatController.removeDocumentationMarks(paramMatcher.group(2))});
		}
		return results.toArray(String[][]::new);
	}



	public static String[] matchReturns (final String content)
	{
		final String editedContent = FormatController.removeLineBreaks(content);
		final Pattern returnsPattern = Pattern.compile("(?<=/// <returns>)([\\s\\S]*?)(?=</returns>)");
		final Matcher returnsMatcher = returnsPattern.matcher(editedContent);
		final Collection<String> results = new ArrayList<>();
		while (returnsMatcher.find())
		{
			results.add(FormatController.removeDocumentationMarks(returnsMatcher.group()));
		}
		return results.toArray(String[]::new);
	}

}
