package project.docmaker.control;

import project.docmaker.model.Section;
import project.docmaker.model.tag.DocumentationTag;
import project.docmaker.model.tag.ParamTag;
import project.docmaker.model.tag.ReturnTag;
import project.docmaker.utility.logging.ILogger;
import project.docmaker.utility.logging.Logger;

import static project.docmaker.utility.constant.MarkdownConstants.*;
import static project.docmaker.utility.constant.MiscConstants.*;

public class MarkdownController
{
	private static final ILogger LOGGER = new Logger(MarkdownController.class.getSimpleName());



	private MarkdownController ()
	{
	}



	public static String generateSection (final Section section)
	{
		LOGGER.log(ILogger.Level.NORMAL, "Generating section: " + section.getHeader());

		final String header = section.getHeader().getContent();
		final String description = section.getDescription().getDescriptionText();
		final StringBuilder output = new StringBuilder();

		// Create the header
		output.append(generateSectionHeader(header));

		// Create the description
		output.append(generateSectionDescription(description));

		// Create the description
		output.append(generateSectionTags(section.getTags()));

		return output.toString();
	}



	private static String generateSectionTags (final DocumentationTag<?>[] tags)
	{
		final StringBuilder output = new StringBuilder();
		for (final DocumentationTag<?> tag : tags)
		{
			output.append(H4_HEADER).append(WHITESPACE).append(tag.getContentType().name()).append(NEW_LINE).append(CARRIAGE_RETURN);
			output.append(MINUS).append(WHITESPACE);
			switch (tag.getContentType())
			{
				case PARAM -> output.append(generateParamTag((ParamTag) tag));
				case RETURNS -> output.append(generateReturnTag((ReturnTag) tag));
				default -> output.append(EMPTY_STRING);
			}
			output.append(NEW_LINE).append(CARRIAGE_RETURN);
		}
		return output.toString();
	}



	private static String generateReturnTag (final ReturnTag tag)
	{
		return tag.getTagContent().content();
	}



	private static String generateParamTag (final ParamTag tag)
	{
		final StringBuilder output = new StringBuilder();
		output.append(tag.getTagContent().paramName()).append(WHITESPACE);
		output.append(MINUS).append(WHITESPACE).append(tag.getTagContent().paramValue());
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
