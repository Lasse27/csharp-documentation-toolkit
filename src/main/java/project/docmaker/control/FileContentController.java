package project.docmaker.control;

import project.docmaker.model.CodeSnippet;
import project.docmaker.model.DocumentationTagList;
import project.docmaker.model.FileContent;
import project.docmaker.model.Regex;
import project.docmaker.model.section.Body;
import project.docmaker.model.section.Footer;
import project.docmaker.model.section.Header;
import project.docmaker.model.section.Section;
import project.docmaker.model.section.implementation.Description;
import project.docmaker.model.tag.ParameterTag;
import project.docmaker.model.tag.ReturnTag;
import project.docmaker.model.tag.TagContentType;
import project.docmaker.utility.constant.RegexConstants;
import project.docmaker.utility.logging.ILogger;
import project.docmaker.utility.logging.Logger;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashSet;

import static project.docmaker.utility.constant.LoggingConstants.INSTANCE_CREATED_PTN;


/**
 * The {@code FileContentController} is used to analyze instances of {@link FileContent} and collect relevant information needed for the
 * {@link Section} classes. It's heavily reliant on the {@link Regex} class and the API methods regarding regular expressions.
 *
 * @author Lasse-Leander Hillen
 * @see Regex
 * @see RegexController
 * @see FileContent
 * @see Section
 * @since 03.09.2024
 */
public final class FileContentController
{
	/**
	 * A {@link Logger} object, which is being used to write formatted outputs into the console.
	 */
	private static final ILogger LOGGER = new Logger(FileContentController.class.getSimpleName());



	/**
	 * Private constructor since controller class isn't supposed to be initialized ever.
	 */
	private FileContentController ()
	{
	}



	private static String getClassArea (final FileContent fileContent)
	{
		final String fileContentString = fileContent.getAsString();
		return RegexController.matchFirst(RegexConstants.PUBLIC_CLASS_REGEX, fileContentString);
	}



	/**
	 * Method that gets the class header from a passed {@link FileContent} instance.
	 *
	 * @param fileContent The {@code FileContent} instance, which should be analyzed.
	 *
	 * @return A {@link Header} instance representing the class header of the {@code FileContent} instance.
	 */
	public static Header GetClassHeader (final FileContent fileContent)
	{
		final String classAreaStr = fileContent.getAsString();
		final String className = RegexController.matchFirst(RegexConstants.CLASS_NAME_REGEX, classAreaStr);
		return new Header(className);
	}



	/**
	 * Method that gets the class body from a passed {@link FileContent} instance.
	 *
	 * @param fileContent The {@code FileContent} instance, which should be analyzed.
	 *
	 * @return A {@link Header} instance representing the class header of the {@code FileContent} instance.
	 */
	public static Body GetClassBody (final FileContent fileContent)
	{
		// Getting the strings which are analyzed for the body parts
		final String fileContentString = fileContent.getAsString();
		final String classArea = FileContentController.getClassArea(fileContent);

		// Getting the description instance
		final String descriptionStr = FormatController.removeDocMarks(RegexController.matchFirst(RegexConstants.CLASS_DESCRIPTION_REGEX, classArea));
		final Description description = new Description(descriptionStr);
		LOGGER.log(ILogger.Level.DEBUG, MessageFormat.format(INSTANCE_CREATED_PTN, description));

		// Getting the DocumentationTags
		final DocumentationTagList documentationTags = FileContentController.GetDocumentationTagList(classArea);

		// Getting the code snippet
		final String codeStr = FormatController.removeDocMarks(RegexController.matchFirst(RegexConstants.CLASS_CODE_REGEX, fileContentString));
		final CodeSnippet codeSnippet = new CodeSnippet(codeStr);
		LOGGER.log(ILogger.Level.DEBUG, MessageFormat.format(INSTANCE_CREATED_PTN, description));

		// Returning the finished product
		return new Body(description, documentationTags, codeSnippet);
	}



	/**
	 * Method that gets the {@link DocumentationTagList} from a documentation {@link String} of a file content.
	 *
	 * @param regexArea The {@code String} which is meant to be analyzed for a {@code DocumentationTagList}.
	 *
	 * @return A new instance of the {@code DocumentationTagList}.
	 */
	private static DocumentationTagList GetDocumentationTagList (final String regexArea)
	{
		final DocumentationTagList documentationTags = new DocumentationTagList();
		for (final TagContentType tagContentType : TagContentType.values())
		{
			switch (tagContentType)
			{
				case TagContentType.PARAM -> documentationTags.addAll(FileContentController.GetParameterTags(regexArea));
				case TagContentType.RETURNS -> documentationTags.addAll(FileContentController.GetReturnTags(regexArea));
			}
		}
		return documentationTags;
	}



	private static Collection<ParameterTag> GetParameterTags (final String regexArea)
	{
		final Collection<ParameterTag> parameterTags = new HashSet<>();
		for (final String[] match : RegexController.matchParams(regexArea))
		{
			parameterTags.add(new ParameterTag(match[0], match[1]));
		}
		return parameterTags;
	}



	private static Collection<ReturnTag> GetReturnTags (final String regexArea)
	{
		final Collection<ReturnTag> parameterTags = new HashSet<>();
		for (final String match : RegexController.matchReturns(regexArea))
		{
			parameterTags.add(new ReturnTag(match));
		}
		return parameterTags;
	}



	public static Footer GetClassFooter (final FileContent fileContent)
	{
		return null; // TODO:
	}
}
