package project.docmaker.control;


import org.jetbrains.annotations.NotNull;
import project.docmaker.model.structure.Body;
import project.docmaker.model.structure.Code;
import project.docmaker.model.structure.Header;
import project.docmaker.model.structure.Section;
import project.docmaker.model.tag.Parameter;
import project.docmaker.model.tag.Return;
import project.docmaker.model.tag.Summary;
import project.docmaker.utility.mlogger.MLogger;
import project.docmaker.utility.stringutils.StringFormat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static project.docmaker.utility.RegexConstants.*;
import static project.docmaker.utility.mlogger.MLoggerMode.DEBUG;
import static project.docmaker.utility.mlogger.MLoggerMode.VERBOSE;
import static project.docmaker.utility.stringutils.StringController.EMPTY_STRING;
import static project.docmaker.utility.stringutils.StringFormat.FormatOption;


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

	public static @NotNull List<Section> getSectionsFromFile (final @NotNull File file) throws IOException
	{
		// Reading the file and matching the regular expression
		final Matcher matcher = CS_SECTION_PATTERN.matcher(Files.readString(file.toPath()));
		MLogger.logLnf(DEBUG, "{0} Matches found for {1}", matcher.groupCount(), file.getName());

		// Creating the output list
		final List<Section> sections = new ArrayList<>();
		while (matcher.find())
		{
			MLogger.logLnf(DEBUG, "Processing match - {0}", sections.size());
			sections.add(RegexController.createSectionFromMatch(matcher, file));
		}

		// Returning the output list
		return sections;
	}


	private static @NotNull Section createSectionFromMatch (final MatchResult matchResult, final File file) throws IOException
	{
		final Header header = getHeaderFromMatchResult(matchResult);

		// Collecting the tags from the documentation and creating/logging the body of the section
		final Body body = getBodyFromMatchResult(matchResult);

		// Collecting the code snippet of the section
		final Code code = getCodeFromMatchResult(matchResult, file);

		// Creating/logging the section.
		MLogger.logLn(DEBUG, "Creating new section instance");
		final Section section = new Section(header, body, code);
		MLogger.logMLoggable(DEBUG, section);
		MLogger.logLn(VERBOSE, "----------------------------------------------------------------");
		return section;
	}


	private static @NotNull Header getHeaderFromMatchResult (final @NotNull MatchResult matchResult)
	{
		final String keywords = STRING_FORMAT.apply(matchResult.group("KEYWORDS") != null ? matchResult.group("KEYWORDS") : EMPTY_STRING);
		final String description = STRING_FORMAT.apply(matchResult.group("DESCRIPTION") != null ? matchResult.group("DESCRIPTION") : EMPTY_STRING);
		final String annotation = STRING_FORMAT.apply(matchResult.group("ANNOTATION") != null ? matchResult.group("ANNOTATION") : EMPTY_STRING);
		return new Header(annotation, keywords, description);
	}


	private static @NotNull Body getBodyFromMatchResult (final @NotNull MatchResult matchResult)
	{
		final Collection<Summary> summaryCollection = RegexController.getSummariesFromCharSequence(matchResult.group("DOCUMENTATION"));
		final Collection<Parameter> parameterCollection = RegexController.getParametersFromCharSequence(matchResult.group("DOCUMENTATION"));
		final Collection<Return> returnCollection = RegexController.getReturnsFromCharSequence(matchResult.group("DOCUMENTATION"));
		return new Body(summaryCollection, parameterCollection, returnCollection);
	}


	private static @NotNull Code getCodeFromMatchResult (final MatchResult matchResult, final @NotNull File file) throws IOException
	{
		final String codebase = Files.readString(file.toPath());
		final int endIndex = RegexController.getEndOfCodeSnippet(matchResult, codebase);
		final String codeSnippet = codebase.substring(matchResult.start(), endIndex);
		return new Code(codeSnippet.stripIndent());
	}


	private static int getEndOfCodeSnippet (final @NotNull MatchResult matchResult, final String codebase)
	{
		// Substring of the original match gets reduced to just the description which is used to find the method in the file
		final Matcher matcher = Pattern.compile(matchResult.group("DESCRIPTION"), Pattern.LITERAL).matcher(codebase);
		int startindex = 0;

		if (matcher.find())
		{
			startindex = matcher.start();
		}
		final char[] tokens = codebase.substring(startindex).toCharArray();

		// Once found, the index of the last section-brace gets returned
		int braces = 0;
		int endoffset = 0;
		for (final char token : tokens)
		{
			endoffset++;
			if (token == '{')
			{
				braces++;
			}
			else if (token == ';' && braces == 0)
			{
				break;
			}
			else if (token == '}')
			{
				braces--;
				if (braces == 0)
				{
					break;
				}
			}
		}
		return startindex + endoffset;
	}


	private static @NotNull Collection<Summary> getSummariesFromCharSequence (final CharSequence charSequence)
	{
		final Matcher summaryMatcher = SUMMARY_PATTERN.matcher(charSequence);
		final Collection<Summary> summaryCollection = new ArrayList<>();
		while (summaryMatcher.find())
		{
			summaryCollection.add(new Summary(STRING_FORMAT.apply(summaryMatcher.group(1))));
		}
		return summaryCollection;
	}


	private static @NotNull Collection<Return> getReturnsFromCharSequence (final CharSequence sequence)
	{
		final Matcher returnsMatcher = RETURN_PATTERN.matcher(sequence);
		final Collection<Return> returnCollection = new ArrayList<>();
		while (returnsMatcher.find())
		{
			returnCollection.add(new Return(STRING_FORMAT.apply(returnsMatcher.group(1))));
		}
		return returnCollection;
	}


	private static @NotNull Collection<Parameter> getParametersFromCharSequence (final CharSequence sequence)
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
