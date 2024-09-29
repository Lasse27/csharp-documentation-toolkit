package project.docmaker.model.structure;


import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NotNull;
import project.docmaker.utility.mlogger.NoLogger;

import java.text.MessageFormat;

import static project.docmaker.utility.MiscConstants.MARKDOWN;


/**
 * The record {@code CodeSnippet} represents a {@link MarkdownStructure} that acts like a code snippet at the end of each Markdown section. It's
 * supposed to contain the class/method or field description and should never be more than one line long.
 *
 * @param content The code-sequence that's displayed in the {@code CodeSnippet}.
 *
 * @author Lasse-Leander Hillen
 * @see Record
 * @see MarkdownStructure
 * @since 11.09.2024
 */
@NoLogger
public record Code(String content) implements MarkdownStructure
{

	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Code#toString()} method gets called
	 */
	private static final String TEXT_DISPLAY_PATTERN = Code.class.getSimpleName() + "[snippet={0}]";


	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Code#toMarkdown()} method gets called
	 */
	@Language (MARKDOWN)
	private static final String MARKDOWN_PATTERN = "### _Code-Snippet:_ ``{0}``\r\n";


	/**
	 * {@inheritDoc}
	 */
	@Override
	public @NotNull String toMarkdown ()
	{
		return MessageFormat.format(MARKDOWN_PATTERN, this.content);
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
