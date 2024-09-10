package project.docmaker.control;


import project.docmaker.model.structure.Body;
import project.docmaker.model.structure.Description;
import project.docmaker.model.structure.Header;
import project.docmaker.model.structure.Snippet;
import project.docmaker.model.structure.section.MetaData;
import project.docmaker.model.structure.section.Section;
import project.docmaker.utility.constant.LoggingConstants;
import project.docmaker.utility.logging.ILogger;
import project.docmaker.utility.logging.Logger;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static project.docmaker.utility.constant.MiscConstants.EMPTY_STRING;
import static project.docmaker.utility.constant.RegexConstants.*;


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



	/**
	 * Searches a given {@link CharSequence} and finds all Documentations within that {@code CharSequence}.
	 *
	 * @param charSequence The {@code CharSequence} that's supposed to be analyzed.
	 *
	 * @return A {@link Collection} if {@link String} representing all occurring documentations within the {@code CharSequence}
	 */
	public static Collection<CharSequence> findAllDocumentations (final CharSequence charSequence)
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



	public static Section getSectionFromCharSequence (final String charSequence)
	{
		// Getting the header of the section
		final Header header = getClassHeaderFromArea(charSequence);

		// Getting the body of the section
		final Description description = RegexController.getClassDescriptionFromArea(charSequence);
		final Snippet snippet = RegexController.getSnippetFromCharSequence(charSequence);
		final Body body = new Body(description, null, snippet);

		// Creating the metadata and creating the section.
		final Section section = new Section(new MetaData(header, body));
		LOGGER.logf(ILogger.Level.NORMAL, LoggingConstants.INSTANCE_CREATED_PTN, section);
		return section;
	}



	private static Header getClassHeaderFromArea (final String area)
	{
		// Cleanes the sequence of all documentations and tabs / newlines etc.
		String cleansedSequence = area.replaceAll(DOCUMENTATION_SINGLE_LINE_REGEX, "");
		cleansedSequence = Formatter.removeSpecialCharacters(cleansedSequence);

		final Matcher matcher = CLASS_WITHOUT_DOC_REGEX.matcher(cleansedSequence);
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



	private static Snippet getSnippetFromCharSequence (final String string)
	{
		// Cleanes the sequence of all documentations and tabs / newlines etc.
		String cleansedSequence = string.replaceAll(DOCUMENTATION_SINGLE_LINE_REGEX, "");
		cleansedSequence = Formatter.removeSpecialCharacters(cleansedSequence);

		// Creating the snippet instance and returning the result.
		final Snippet snippet = new Snippet(cleansedSequence);
		LOGGER.logf(ILogger.Level.DEBUG, LoggingConstants.INSTANCE_CREATED_PTN, snippet);
		return snippet;
	}



	private static Description getClassDescriptionFromArea (final String area)
	{
		final String editedContent = Formatter.removeSpecialCharacters(area);
		final Pattern summaryPattern = Pattern.compile("///\\s*<summary>([\\s\\S]*?)</summary>");
		final Matcher summaryMatcher = summaryPattern.matcher(editedContent);
		String descriptionContent = EMPTY_STRING;
		if (summaryMatcher.find())
		{
			descriptionContent = summaryMatcher.group(1);
		}
		return new Description(Formatter.removeDocMarks(descriptionContent));
	}



	private static String[][] matchParams (final String content)
	{
		final String editedContent = Formatter.removeSpecialCharacters(content);
		final Pattern paramPattern = Pattern.compile("///\\s*<param name=\"([^\"]+)\">([\\s\\S]*?)</param>");
		final Matcher paramMatcher = paramPattern.matcher(editedContent);
		final Collection<String[]> results = new ArrayList<>();
		while (paramMatcher.find())
		{
			results.add(new String[]{Formatter.removeDocMarks(paramMatcher.group(1)),
					Formatter.removeDocMarks(paramMatcher.group(2))});
		}
		return results.toArray(String[][]::new);
	}



	private static String[] matchReturns (final String content)
	{
		final String editedContent = Formatter.removeSpecialCharacters(content);
		final Pattern returnsPattern = Pattern.compile("(?<=///\\s<returns>)([\\s\\S]*?)(?=</returns>)");
		final Matcher returnsMatcher = returnsPattern.matcher(editedContent);
		final Collection<String> results = new ArrayList<>();
		while (returnsMatcher.find())
		{
			results.add(Formatter.removeDocMarks(returnsMatcher.group()));
		}
		return results.toArray(String[]::new);
	}



	private static boolean areaContainsClassDoc (final CharSequence area)
	{
		final Matcher matcher = CLASS_WITHOUT_DOC_REGEX.matcher(area);
		return matcher.find();
	}

}
