package project.docmaker.control;


import project.docmaker.model.Regex;
import project.docmaker.model.structure.Description;
import project.docmaker.model.structure.Header;
import project.docmaker.model.structure.Snippet;
import project.docmaker.utility.constant.LoggingConstants;
import project.docmaker.utility.constant.RegexConstants;
import project.docmaker.utility.logging.ILogger;
import project.docmaker.utility.logging.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static project.docmaker.utility.constant.MiscConstants.EMPTY_STRING;


public final class RegexController
{

	/** A {@link Logger} object, which is being used to write formatted outputs into the console. */
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



	public static Description getClassDescriptionFromArea (final String area)
	{
		final String editedContent = FormatController.removeLineBreaks(area);
		final Pattern summaryPattern = Pattern.compile("/// <summary>([\\s\\S]*?)</summary>");
		final Matcher summaryMatcher = summaryPattern.matcher(editedContent);
		String descriptionContent = EMPTY_STRING;
		if (summaryMatcher.find())
		{
			descriptionContent = summaryMatcher.group(1);
		}
		return new Description(descriptionContent);
	}



	public static String[][] matchParams (final String content)
	{
		final String editedContent = FormatController.removeLineBreaks(content);
		final Pattern paramPattern = Pattern.compile("/// <param name=\"([^\"]+)\">([\\s\\S]*?)</param>");
		final Matcher paramMatcher = paramPattern.matcher(editedContent);
		final Collection<String[]> results = new ArrayList<>();
		while (paramMatcher.find())
		{
			results.add(new String[]{FormatController.removeDocMarks(paramMatcher.group(1)),
					FormatController.removeDocMarks(paramMatcher.group(2))});
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
			results.add(FormatController.removeDocMarks(returnsMatcher.group()));
		}
		return results.toArray(String[]::new);
	}



	public static Header getClassHeaderFromArea (final CharSequence area)
	{
		final Pattern pattern = RegexConstants.CLASS_REGEX.getPattern();
		final Matcher matcher = pattern.matcher(area);
		if (!matcher.find())
		{
			return new Header(EMPTY_STRING, EMPTY_STRING, EMPTY_STRING);
		}

		String classModifier = matcher.group(1);
		if (matcher.group(2) != null)
		{
			classModifier += " " + matcher.group(2);
		}
		final String classType = matcher.group(3);
		final String className = matcher.group(4);

		final Header header = new Header(classModifier, classType, className);
		LOGGER.logf(ILogger.Level.DEBUG, LoggingConstants.INSTANCE_CREATED_PTN, header);
		return header;
	}



	public static boolean AreaContainsClassDoc (final CharSequence area)
	{
		final Pattern pattern = RegexConstants.PUBLIC_CLASS_REGEX.getPattern();
		final Matcher matcher = pattern.matcher(area);
		return matcher.find();
	}



	public static Snippet getClassCodeSnippet (final CharSequence area)
	{
		// Creating the pattern and matcher and checking if any match could be obtained
		final Pattern pattern = RegexConstants.CLASS_REGEX.getPattern();
		final Matcher matcher = pattern.matcher(area);
		if (!matcher.find())
		{
			return new Snippet(EMPTY_STRING);
		}

		// Creating the snippet instance and returning the result.
		final Snippet snippet = new Snippet(matcher.group());
		LOGGER.logf(ILogger.Level.DEBUG, LoggingConstants.INSTANCE_CREATED_PTN, snippet);
		return snippet;
	}
}
