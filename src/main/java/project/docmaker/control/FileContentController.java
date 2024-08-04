package project.docmaker.control;


import project.docmaker.exception.RegexException;
import project.docmaker.model.*;
import project.docmaker.utility.logging.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static project.docmaker.model.DocumentationTag.TagContentType;
import static project.docmaker.utility.constant.MiscConstants.EMPTY_STRING;
import static project.docmaker.utility.logging.ILogger.Level.ERROR;


public final class FileContentController
{

	private static final Logger LOGGER = new Logger(FileContentController.class.getSimpleName());

	private static final Regex CLASS_AREA_REGEX = new Regex("");

	private static final Regex CLASS_NAME_REGEX = new Regex("");

	private static final Regex CLASS_DESC_REGEX = new Regex("");


	private FileContentController () {}


	private static String getClassArea (final FileContent fileContent)
	{
		try
		{
			final String fileContentString = fileContent.getAsString();
			return RegexController.matchFirst(CLASS_AREA_REGEX, fileContentString);
		}
		catch (final RegexException e)
		{
			LOGGER.log(ERROR, e.getMessage());
		}
		return EMPTY_STRING;
	}


	public static String getClassName (final FileContent fileContent)
	{
		try
		{
			final String classArea = FileContentController.getClassArea(fileContent);
			return RegexController.matchFirst(CLASS_NAME_REGEX, classArea);
		}
		catch (final RegexException e)
		{
			LOGGER.log(ERROR, e.getMessage());
		}
		return EMPTY_STRING;
	}


	public static String getClassDescription (final FileContent fileContent)
	{
		try
		{
			final String classArea = FileContentController.getClassArea(fileContent);
			return RegexController.matchFirst(CLASS_DESC_REGEX, classArea);
		}
		catch (final RegexException e)
		{
			LOGGER.log(ERROR, e.getMessage());
		}
		return EMPTY_STRING;
	}


	public static DocumentationTag[] getClassTags (final FileContent fileContent)
	{
		// Getting the text area of the class section
		final String classArea = FileContentController.getClassArea(fileContent);

		// Adding all the found tags to the returner collection
		final Collection<DocumentationTag> tags = new ArrayList<>();
		try
		{
			for (final TagContentType tagContentType : TagContentType.values())
			{
				tags.add(FileContentController.getDocumentationTag(tagContentType, classArea));
			}
		}
		catch (final RegexException e)
		{
			LOGGER.log(ERROR, e.getMessage());
		}

		// Returning the finished collection.
		return tags.toArray(DocumentationTag[]::new);
	}


	private static DocumentationTag getDocumentationTag (final TagContentType tagContentType, final CharSequence area) throws RegexException
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
