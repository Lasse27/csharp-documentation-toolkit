package project.docmaker.control;

import org.jetbrains.annotations.NotNull;
import project.docmaker.model.*;
import project.docmaker.model.section.implementation.FieldSection;
import project.docmaker.model.section.implementation.MethodSection;
import project.docmaker.model.section.Section;
import project.docmaker.model.tag.DocumentationTag;
import project.docmaker.model.tag.ParamTag;
import project.docmaker.model.tag.ReturnTag;
import project.docmaker.model.tag.TagContentType;
import project.docmaker.utility.logging.ILogger;
import project.docmaker.utility.logging.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static project.docmaker.model.tag.TagContentType.values;
import static project.docmaker.utility.constant.RegexConstants.CLASS_NAME_REGEX;
import static project.docmaker.utility.constant.RegexConstants.PUBLIC_CLASS_REGEX;


/**
 * The {@code FileContentController} is used to analyze instances of {@link FileContent} and collect relevant information needed for the
 * {@link Section} classes. It's heavily reliant on the {@link Regex} class and the API methods regarding regular expressions.
 *
 * @author Lasse-Leander Hillen
 * @version 0.0.1
 * @see java.util.regex.Pattern
 * @see java.util.regex.Matcher
 * @see Regex
 * @see RegexController
 * @see FileContent
 * @see Section
 * @since 04.08.2024
 */
public final class FileContentController
{
	/**
	 * A {@link Logger} object, which is being used to write formatted outputs into the console.
	 */
	private static final ILogger LOGGER = new Logger(FileContentController.class.getSimpleName());

	/**
	 * A {@link Regex} object, which can be used to collect the {@link String} of the class description from the class area.
	 */
	private static final Regex CLASS_DESC_REGEX = new Regex("");



	/**
	 * Private constructor since controller class isn't supposed to be initialized ever.
	 */
	private FileContentController ()
	{
	}



	private static String getClassArea (final FileContent fileContent)
	{
		final String fileContentString = fileContent.getAsString();
		return RegexController.matchFirst(PUBLIC_CLASS_REGEX, fileContentString);
	}



	public static String getClassName (final FileContent fileContent)
	{
		final String fileContentString = fileContent.getAsString();
		return RegexController.matchFirst(CLASS_NAME_REGEX, fileContentString).replace("class ", "");
	}



	public static String getClassDescription (final FileContent fileContent)
	{
		final String classArea = FileContentController.getClassArea(fileContent);
		final String summaryNonFormatted = RegexController.matchSummary(classArea);
		return FormatController.removeDocumentationMarks(summaryNonFormatted);
	}



	public static DocumentationTag[] getClassTags (final FileContent fileContent)
	{
		// Getting the text area of the class section
		final String classArea = FileContentController.getClassArea(fileContent);

		// Adding all the found tags to the returner collection
		final Collection<DocumentationTag> tags = new ArrayList<>();

		for (final TagContentType tagContentType : values())
		{
			tags.addAll(FileContentController.getDocumentationTag(tagContentType, classArea));
		}
		// Returning the finished collection.
		return tags.toArray(DocumentationTag[]::new);
	}



	private static Collection<DocumentationTag> getDocumentationTag (@NotNull final TagContentType tagContentType, final String area)
	{
		final List<DocumentationTag> tags = new ArrayList<>();
		switch (tagContentType)
		{
			case PARAM -> tags.addAll(FileContentController.getParameters(area));
			case RETURNS -> tags.addAll(FileContentController.getReturns(area));
			case EXCEPTION -> tags.addAll(FileContentController.getExceptions(area));
			case REMARKS -> tags.addAll(FileContentController.getRemarks(area));
			case EXAMPLE -> tags.addAll(FileContentController.getExamples(area));
			case CODE -> tags.addAll(FileContentController.getCodes(area));
			default -> tags.addAll(new ArrayList<>());
		}
		return tags;
	}



	private static List<DocumentationTag> getParameters (final String area)
	{
		final List<DocumentationTag> documentationTags = new ArrayList<>();
		final String[][] matches = RegexController.matchParams(area);
		for (final String[] match : matches)
		{
			documentationTags.add(new ParamTag(match[0], match[1]));
		}
		return documentationTags;
	}



	private static Collection<? extends DocumentationTag> getReturns (final String area)
	{
		final List<DocumentationTag> documentationTags = new ArrayList<>();
		final String[] matches = RegexController.matchReturns(area);
		for (final String match : matches)
		{
			documentationTags.add(new ReturnTag(match));
		}
		return documentationTags;
	}



	private static Collection<? extends DocumentationTag> getExceptions (final String area)
	{
		return new ArrayList<>();
	}



	private static Collection<? extends DocumentationTag> getRemarks (final String area)
	{
		return new ArrayList<>();
	}



	private static Collection<? extends DocumentationTag> getCodes (final String area)
	{
		return new ArrayList<>();
	}



	private static Collection<? extends DocumentationTag> getExamples (final String area)
	{
		return new ArrayList<>();
	}



	public static List<FieldSection> getFieldSections ()
	{
		return new ArrayList<>();
	}



	public static List<MethodSection> getMethodSections ()
	{
		return new ArrayList<>();
	}

}
