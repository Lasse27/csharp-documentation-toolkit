package project.docmaker.control;

import project.docmaker.model.DocumentationTagList;
import project.docmaker.model.structure.section.Section;
import project.docmaker.model.tag.Tag;
import project.docmaker.model.tag.ParameterTag;
import project.docmaker.model.tag.ReturnTag;
import project.docmaker.model.tag.TagType;
import project.docmaker.utility.logging.ILogger;
import project.docmaker.utility.logging.Logger;

import static project.docmaker.utility.constant.MarkdownConstants.H1_HEADER;
import static project.docmaker.utility.constant.MarkdownConstants.H4_HEADER;
import static project.docmaker.utility.constant.MiscConstants.*;

public class MarkdownController
{
	/**
	 * A {@link Logger} object, which is being used to write formatted outputs into the console.
	 */
	private static final ILogger LOGGER = new Logger(SectionFactory.class.getSimpleName());



	/**
	 * Private constructor since controller class isn't supposed to be initialized ever.
	 */
	private MarkdownController ()
	{
	}



	public static String generateSection (final Section section)
	{
		return "";
	}



	private static String generateSectionTags (final DocumentationTagList tags)
	{
		final StringBuilder output = new StringBuilder();
		for (final TagType type : TagType.values())
		{
			switch (type)
			{
				case PARAM -> output.append(generateWithParamsFormatting(tags.getTagGroup(type)));
				case RETURNS -> output.append(generateReturnTag(tags.getTagGroup(type)));
				default -> output.append(EMPTY_STRING);
			}
		}
		return output.toString();
	}



	private static String generateReturnTag (final Tag[] tags)
	{
		final StringBuilder output = new StringBuilder();
		output.append(generatedTagHeader(TagType.RETURNS));
		for (final Tag tag : tags)
		{
			final ReturnTag returnTag = (ReturnTag) tag;
			output.append(MINUS).append(WHITESPACE);
			output.append(returnTag.getContent().content()).append(WHITESPACE);
			output.append(NEW_LINE).append(CARRIAGE_RETURN);
		}
		return output.toString();
	}



	private static String generatedTagHeader (final TagType tagType)
	{
		return new StringBuilder().append(H4_HEADER).append(WHITESPACE).append(tagType.name()).append(NEW_LINE).append(CARRIAGE_RETURN)
				.toString();
	}



	private static String generateWithParamsFormatting (final Tag[] tags)
	{
		final StringBuilder output = new StringBuilder();
		output.append(generatedTagHeader(TagType.PARAM));

		for (final Tag tag : tags)
		{
			final ParameterTag parameterTag = (ParameterTag) tag;
			output.append(MINUS).append(WHITESPACE);
			output.append(parameterTag.getContent().paramName()).append(WHITESPACE);
			output.append(MINUS).append(WHITESPACE).append(parameterTag.getContent().paramValue()).append(NEW_LINE).append(CARRIAGE_RETURN);
		}
		return output.toString();
	}



	private static String generateSectionHeader (final String header)
	{
		final StringBuilder output = new StringBuilder();
		output.append(H1_HEADER).append(WHITESPACE).append(header).append(NEW_LINE).append(CARRIAGE_RETURN);
		return output.toString();
	}



	private static String generateSectionDescription (final String description)
	{
		final StringBuilder output = new StringBuilder();
		output.append(MINUS).append(WHITESPACE).append(description).append(NEW_LINE).append(CARRIAGE_RETURN);
		return output.toString();
	}
}
