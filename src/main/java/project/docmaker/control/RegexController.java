package project.docmaker.control;


import project.docmaker.model.structure.Body;
import project.docmaker.model.structure.CodeSnippet;
import project.docmaker.model.structure.Header;
import project.docmaker.model.structure.Section;
import project.docmaker.model.tag.Parameter;
import project.docmaker.model.tag.Return;
import project.docmaker.model.tag.Summary;
import project.docmaker.utility.ILogger;
import project.docmaker.utility.Logger;
import project.docmaker.utility.LoggingConstants;
import project.docmaker.utility.StringFormat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static project.docmaker.utility.RegexConstants.*;
import static project.docmaker.utility.StringFormat.FormatOption;


public final class RegexController
{

	/**
	 * A {@link Logger} object, which is being used to write formatted outputs into the console.
	 */
	private static final ILogger LOGGER = new Logger(RegexController.class.getSimpleName());


	/**
	 * The {@link StringFormat} object used to normalize the {@link String} of the read file.
	 */
	private static final StringFormat STRING_FORMAT = new StringFormat(FormatOption.NORMALIZE, FormatOption.REMOVE_MARKS);



	/**
	 * Private constructor since controller class isn't supposed to be initialized ever.
	 */
	private RegexController ()
	{
	}



	/**
	 * Searches a given {@link CharSequence} and finds all Documentations within that {@code CharSequence}.
	 *
	 * @param charSequence The {@code CharSequence} that's supposed to be analyzed.
	 *
	 * @return A {@link Collection} if {@link String} representing all occurring documentations within the {@code CharSequence}
	 */
	public static Collection<CharSequence> findDocumentations (final CharSequence charSequence)
	{
		// Creating a matcher from the DOCUMENTATION_PATTERN - Pattern and collecting all occurring documentations.
		final Matcher matcher = DOCUMENTATION_CODE_PATTERN.matcher(charSequence);
		final Collection<CharSequence> matches = new ArrayList<>();
		while (matcher.find())
		{
			matches.add(matcher.group());
		}

		// Logging the number of matches and returning the generated collection.
		LOGGER.logf(ILogger.Level.DEBUG, "Matcher has found {0} for Pattern: {1}", matches.size(), DOCUMENTATION_CODE_PATTERN);
		return matches;
	}



	/**
	 * Parses the given String multiple times with different regular expressions and creates a {@link Section} instance from the found matches.
	 *
	 * @param charSequence The input {@link String} which is parsed within the method.
	 *
	 * @return A {@link Section} instance, that could be generated from the given {@link String}.
	 */
	public static Section getSectionFromString (final String charSequence)
	{
		// Getting the header of the section
		final Header header = getClassHeaderFromArea(charSequence);
		LOGGER.logf(ILogger.Level.DEBUG, LoggingConstants.INSTANCE_CREATED_PTN, header);

		// Collecting the tags from the documentation and creating the body of the section
		final Collection<Summary> summaryCollection = RegexController.getSummariesFromCharSequence(charSequence);
		final Collection<Parameter> parameterCollection = RegexController.getParametersFromCharSequence(charSequence);
		final Collection<Return> returnCollection = RegexController.getReturnsFromCharSequence(charSequence);
		final Body body = new Body(summaryCollection, parameterCollection, returnCollection);
		LOGGER.logf(ILogger.Level.DEBUG, LoggingConstants.INSTANCE_CREATED_PTN, body);

		// Collecting the code snippet and creating the codeSnippet of the section.
		final CodeSnippet codeSnippet = RegexController.getSnippetFromCharSequence(charSequence);
		LOGGER.logf(ILogger.Level.DEBUG, LoggingConstants.INSTANCE_CREATED_PTN, codeSnippet);

		// Creating the metadata and creating the section.
		final Section section = new Section(header, body, codeSnippet);
		LOGGER.logf(ILogger.Level.DEBUG, LoggingConstants.INSTANCE_CREATED_PTN, section);
		return section;
	}



	/**
	 * Parses the given String multiple times with different regular expressions and creates a {@link Header} instance from the found matches.
	 *
	 * @param charSequence The input {@link String} which is parsed within the method.
	 *
	 * @return A {@link Header} instance, that could be generated from the given {@link String}.
	 */
	private static Header getClassHeaderFromArea (final String charSequence)
	{
		// Cleanes the sequence of all documentations and tabs / newlines etc.
		String cleansedSequence = charSequence.replaceAll(DOCUMENTATION_SINGLE_LINE_REGEX, "");
		cleansedSequence = STRING_FORMAT.apply(cleansedSequence);

		final Matcher matcher = CLASS_WITHOUT_DOC_REGEX.matcher(cleansedSequence);
		if (matcher.find())
		{
			final Header header = new Header(STRING_FORMAT.apply(matcher.group(1)), STRING_FORMAT.apply(matcher.group(2)));
			LOGGER.logf(ILogger.Level.DEBUG, LoggingConstants.INSTANCE_CREATED_PTN, header);
			return header;
		}
		return Header.EMPTY;
	}



	/**
	 * Parses the given String multiple times with different regular expressions and creates a {@link CodeSnippet} instance from the found matches.
	 *
	 * @param charSequence The input {@link String} which is parsed within the method.
	 *
	 * @return A {@link CodeSnippet} instance, that could be generated from the given {@link String}.
	 */
	private static CodeSnippet getSnippetFromCharSequence (final String charSequence)
	{
		// Cleanes the sequence of all documentations and tabs / newlines etc.
		String cleansedSequence = charSequence.replaceAll(DOCUMENTATION_SINGLE_LINE_REGEX, "");
		cleansedSequence = STRING_FORMAT.apply(cleansedSequence);

		// Creating the snippet instance and returning the result.
		final CodeSnippet codeSnippet = new CodeSnippet(cleansedSequence);
		LOGGER.logf(ILogger.Level.DEBUG, LoggingConstants.INSTANCE_CREATED_PTN, codeSnippet);
		return codeSnippet;
	}



	private static Collection<Summary> getSummariesFromCharSequence (final CharSequence charSequence)
	{
		final Matcher summaryMatcher = SUMMARY_PATTERN.matcher(charSequence);
		final Collection<Summary> summaryCollection = new ArrayList<>();
		while (summaryMatcher.find())
		{
			summaryCollection.add(new Summary(STRING_FORMAT.apply(summaryMatcher.group(1))));
		}
		return summaryCollection;
	}



	private static Collection<Return> getReturnsFromCharSequence (final CharSequence sequence)
	{
		final Matcher returnsMatcher = RETURN_PATTERN.matcher(sequence);
		final Collection<Return> returnCollection = new ArrayList<>();
		while (returnsMatcher.find())
		{
			returnCollection.add(new Return(STRING_FORMAT.apply(returnsMatcher.group(1))));
		}
		return returnCollection;
	}



	private static Collection<Parameter> getParametersFromCharSequence (final CharSequence sequence)
	{
		final Pattern paramPattern = Pattern.compile("///\\s*<param name=\"([^\"]+)\">([\\s\\S]*?)</param>");
		final Matcher paramMatcher = paramPattern.matcher(sequence);
		final Collection<Parameter> parameterCollection = new ArrayList<>();
		while (paramMatcher.find())
		{
			parameterCollection.add(new Parameter(STRING_FORMAT.apply(paramMatcher.group(1)), STRING_FORMAT.apply(paramMatcher.group(2))));
		}
		return parameterCollection;
	}



	private static boolean areaContainsClassDoc (final CharSequence area)
	{
		final Matcher matcher = CLASS_WITHOUT_DOC_REGEX.matcher(area);
		return matcher.find();
	}

}
