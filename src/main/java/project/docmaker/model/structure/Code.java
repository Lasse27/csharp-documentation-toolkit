package project.docmaker.model.structure;


import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NotNull;
import project.docmaker.utility.mlogger.MLoggable;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import static project.docmaker.utility.stringutils.StringController.EMPTY_STRING;


/**
 * The record {@code Code} represents a {@link MarkdownStructure} that acts like a code snippet at the end of each Markdown section. It's supposed to contain the class/method
 * or field description and should never be more than one line long.
 *
 * @param content The code-sequence that's displayed in the {@code Code}.
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
	private static final String MARKDOWN_PATTERN = "#### Code:\r\n```cs\r\n{0}\r\n```\r\n";



	/**
	 * {@inheritDoc}
	 */
	@Override
	public @NotNull String toMarkdown ()
	{
		return MessageFormat.format(MARKDOWN_PATTERN, this.content);
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public @NotNull Collection<String> toStringCollection ()
	{
		final Collection<String> stringCollection = new ArrayList<>();
		stringCollection.add(MessageFormat.format("Instance: {0}", this.toString()));

		final String content = !Objects.equals(this.content, EMPTY_STRING) ? "Exists" : "Doesn't exist";
		stringCollection.add(MessageFormat.format("\tContent: {0}", content));

		return stringCollection;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public @NotNull String toString ()
	{
		return MessageFormat.format(TEXT_DISPLAY_PATTERN, this.getClass().getSimpleName(), Integer.toHexString(this.hashCode()));
	}
}
