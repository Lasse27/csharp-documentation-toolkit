package project.docmaker.model.structure;


import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NotNull;
import project.docmaker.utility.MiscConstants;
import project.docmaker.utility.mlogger.MLoggable;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;

import static project.docmaker.utility.stringutils.StringController.TAB;


/**
 * The record {@code Header} represents a {@link MarkdownStructure} that acts like a the header of each Markdown section. It's split into a descriptor {@link String} that
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
	 * An empty {@link Header} instance that contains placeholder attributes and can be used to fill missing matches.
	 */
	public static final Header EMPTY = new Header("{Empty}", "{Empty}", "{Empty}");


	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Header#toString()} method gets called
	 */
	private static final String TEXT_DISPLAY_PATTERN = "{0} @ {1}";


	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Header#toMarkdown()} method gets called
	 */
	@Language (MiscConstants.MARKDOWN)
	private static final String MARKDOWN_PATTERN = "## {0} {1} \n\n";


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
		stringCollection.add("Instance: " + this.toString());
		stringCollection.add(TAB + "Annotations: " + this.annotation);
		stringCollection.add(TAB + "Descriptor: " + this.descriptor);
		stringCollection.add(TAB + "Content: " + this.content);
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
