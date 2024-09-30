package project.docmaker.model.structure;


import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NotNull;
import project.docmaker.utility.mlogger.MLoggable;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import static project.docmaker.utility.MiscConstants.MARKDOWN;
import static project.docmaker.utility.stringutils.StringController.EMPTY_STRING;
import static project.docmaker.utility.stringutils.StringController.TAB;


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
public record Code(String content) implements MarkdownStructure, MLoggable
{

	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Code#toString()} method gets called
	 */
	private static final String TEXT_DISPLAY_PATTERN = "{0} @ {1}";


	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Code#toMarkdown()} method gets called
	 */
	@Language (MARKDOWN)
	private static final String MARKDOWN_PATTERN = "### Code:\r\n```cs\r\n{0}\r\n```\r\n";


	/**
	 * {@inheritDoc}
	 */
	@Override
	public @NotNull String toMarkdown ()
	{
		return MessageFormat.format(MARKDOWN_PATTERN, this.content);
	}


	/**
	 * Generates and returns a {@link Collection} of {@link String} which represents the instance in its current state.
	 *
	 * @return A {@link Collection} of {@link String} which represents the object in its current state.
	 */
	@Override
	public @NotNull Collection<String> toStringCollection ()
	{
		final Collection<String> stringCollection = new ArrayList<>();
		stringCollection.add("Instance: " + this.toString());
		stringCollection.add(TAB + "Content: " + (! Objects.equals(this.content, EMPTY_STRING) ? "Exists" : "Doesn't exist"));
		return stringCollection;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TEXT_DISPLAY_PATTERN, this.getClass().getSimpleName(), Integer.toHexString(this.hashCode()));
	}
}
