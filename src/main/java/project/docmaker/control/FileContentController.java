package project.docmaker.control;

import project.docmaker.model.*;
import project.docmaker.utility.logging.ILogger;
import project.docmaker.utility.logging.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static project.docmaker.model.DocumentationTag.TagContentType;
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
		return RegexController.matchFirst(CLASS_DESC_REGEX, classArea);
	}



	public static DocumentationTag[] getClassTags (final FileContent fileContent)
	{
		// Getting the text area of the class section
		final String classArea = FileContentController.getClassArea(fileContent);

		// Adding all the found tags to the returner collection
		final Collection<DocumentationTag> tags = new ArrayList<>();

		for (final TagContentType tagContentType : TagContentType.values())
		{
			tags.add(FileContentController.getDocumentationTag(tagContentType, classArea));
		}
		// Returning the finished collection.
		return tags.toArray(DocumentationTag[]::new);
	}



	private static DocumentationTag getDocumentationTag (final TagContentType tagContentType, final String area)
	{
		return new DocumentationTag(tagContentType, RegexController.matchFirst(tagContentType.getRegex(), area));
	}



	public static List<FieldSection> getFieldSections ()
	{
		return null;
	}



	public static List<MethodSection> getMethodSections ()
	{
		return null;
	}

}
