package project.docmaker.model.structure;

import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NotNull;
import project.docmaker.utility.NoLogger;
import project.docmaker.utility.MiscConstants;

import java.text.MessageFormat;

/**
 * The record {@code Header} represents a {@link MarkdownStructure} that acts like a the header of each Markdown section. It's split into a descriptor
 * {@link String} that contains the modifier of the section and a content {@link String} that contains the name of the section.
 *
 * @param content    Content {@link String} that contains the name of the section.
 * @param descriptor Descriptor {@link String} that contains the modifier of the section
 *
 * @author Lasse-Leander Hillen
 * @see Record
 * @see MarkdownStructure
 * @since 11.09.2024
 */
@NoLogger
public record Header(String descriptor, String content) implements MarkdownStructure
{

	/**
	 * An empty {@link Header} instance that contains placeholder attributes and can be used to fill missing matches.
	 */
	public static final Header EMPTY = new Header("{Empty}", "{Empty}");


	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Header#toString()} method gets called
	 */
	private static final String TEXT_DISPLAY_PATTERN = Header.class.getSimpleName() + "[content={0}]";


	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link CodeSnippet#toMarkdown()} method gets called
	 */
	@Language (MiscConstants.MARKDOWN)
	private static final String MARKDOWN_PATTERN = "# _{0} {1}_\r\n";



	/**
	 * {@inheritDoc}
	 */
	@Override
	public @NotNull String toMarkdown ()
	{
		return MessageFormat.format(MARKDOWN_PATTERN, this.descriptor, this.content);
	}



	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state.
	 *
	 * @return A formatted {@link String} which represents the object in its current state.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TEXT_DISPLAY_PATTERN, this.content);
	}
}
