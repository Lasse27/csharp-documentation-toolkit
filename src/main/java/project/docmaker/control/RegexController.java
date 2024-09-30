package project.docmaker.control;


import project.docmaker.model.structure.Body;
import project.docmaker.model.structure.Code;
import project.docmaker.model.structure.Header;
import project.docmaker.model.structure.Section;
import project.docmaker.model.tag.Parameter;
import project.docmaker.model.tag.Return;
import project.docmaker.model.tag.Summary;
import project.docmaker.utility.LoggingConstants;
import project.docmaker.utility.StringFormat;
import project.docmaker.utility.mlogger.MLogger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static project.docmaker.utility.MiscConstants.EMPTY_STRING;
import static project.docmaker.utility.RegexConstants.*;
import static project.docmaker.utility.StringFormat.FormatOption;
import static project.docmaker.utility.mlogger.MLoggerMode.DEBUG;


public final class RegexController
{

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
	 * Searches a given {@link File} and finds all C#-Sections within the file.
	 *
	 * @param file The {@code File} that's supposed to be analyzed.
	 *
	 * @return A {@link List} of {@link Section} representing all occurring documentations C#-Sections within the file.
	 *
	 * @throws IOException Throws an exception if the file wasn't readable.
	 */
	public static List<Section> getSectionsFromFile (final File file) throws IOException
	{
		// Reading the file and matching the regular expression
		final Matcher matcher = CS_SECTION_PATTERN.matcher(Files.readString(file.toPath()));
		MLogger.logLnf(DEBUG, "{0} Matches found for {1}", matcher.groupCount(), file.getName());

		// Creating the output list
		final List<Section> sections = new ArrayList<>();
		int counter = 0;
		while (matcher.find())
		{
			counter++;
			MLogger.logSeparator();
			MLogger.logLnf(DEBUG, "Processing match - {0}", String.valueOf(counter));
			sections.add(RegexController.createSectionFromMatch(matcher));
		}

		// Returning the output list
		return sections;
	}


	private static Section createSectionFromMatch (final MatchResult matchResult)
	{
		// Creating/logging the header of the section
		final String keywords = STRING_FORMAT.apply(matchResult.group("KEYWORDS") != null ? matchResult.group("KEYWORDS") : EMPTY_STRING);
		final String description = STRING_FORMAT.apply(matchResult.group("DESCRIPTION") != null ? matchResult.group("DESCRIPTION") : EMPTY_STRING);
		final String annotation = STRING_FORMAT.apply(matchResult.group("ANNOTATION") != null ? matchResult.group("ANNOTATION") : EMPTY_STRING);
		final Header header = new Header(annotation, keywords, description);
		MLogger.logLnf(DEBUG, LoggingConstants.INSTANCE_CREATED_PTN, header);

		// Collecting the tags from the documentation and creating/logging the body of the section
		final Collection<Summary> summaryCollection = RegexController.getSummariesFromCharSequence(matchResult.group("DOCUMENTATION"));
		final Collection<Parameter> parameterCollection = RegexController.getParametersFromCharSequence(matchResult.group("DOCUMENTATION"));
		final Collection<Return> returnCollection = RegexController.getReturnsFromCharSequence(matchResult.group("DOCUMENTATION"));
		final Body body = new Body(summaryCollection, parameterCollection, returnCollection);
		MLogger.logLnf(DEBUG, LoggingConstants.INSTANCE_CREATED_PTN, body);

		// Creating/logging the section.
		final Section section = new Section(header, body, new Code(""));
		MLogger.logLnf(DEBUG, LoggingConstants.INSTANCE_CREATED_PTN, section);
		return section;
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
}
