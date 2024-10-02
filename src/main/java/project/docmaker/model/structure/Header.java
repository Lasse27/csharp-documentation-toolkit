package project.docmaker.model.structure;


import org.jetbrains.annotations.NotNull;
import project.docmaker.utility.mlogger.MLoggable;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;


/**
 * The record {@code Header} represents a {@link MarkdownStructure} that acts like the header of each Markdown section. It's split into a descriptor {@link String} that
 * contains the modifier of the section and a content {@link String} that contains the name of the section.
 *
 * @param content    Content {@link String} that contains the name of the section.
 * @param descriptor Descriptor {@link String} that contains the modifier of the section
 *
 * @author Lasse-Leander Hillen
 * @see Record
 * @see MarkdownStructure
 * @since 11.09.2024
 */
public record Header(String annotation, String descriptor, String content) implements MarkdownStructure, MLoggable
{
	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Header#toString()} method gets called
	 */
	private static final String TEXT_DISPLAY_PATTERN = "{0} @ {1}";


	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Header#toMarkdown()} method gets called
	 */
	private static final String MARKDOWN_PATTERN = "### {0} {1} \n\n";



	/**
	 * {@inheritDoc}
	 */
	@Override
	public @NotNull String toMarkdown ()
	{
		return MessageFormat.format(MARKDOWN_PATTERN, this.descriptor, this.content);
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public @NotNull Collection<String> toStringCollection ()
	{
		final Collection<String> stringCollection = new ArrayList<>();
		stringCollection.add(MessageFormat.format("Instance: {0}", this.toString()));
		stringCollection.add(MessageFormat.format("\tAnnotations: {0}", this.annotation));
		stringCollection.add(MessageFormat.format("\tDescriptor: {0}", this.descriptor));
		stringCollection.add(MessageFormat.format("\tContent: {0}", this.content));
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
