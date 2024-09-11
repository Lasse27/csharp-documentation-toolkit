package project.docmaker.model.structure;

import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NotNull;
import project.docmaker.model.section.Section;
import project.docmaker.utility.annotation.NoLogger;
import project.docmaker.utility.constant.MiscConstants;

import java.text.MessageFormat;

/**
 * The record {@code Header} represents the header of one {@link Section} instance.
 *
 * @param content The string instance of the abstract section instance which represents the content
 *
 * @author Lasse-Leander Hillen
 * @since 02.09.2024
 */
@NoLogger
public record Header(String descriptor, String content) implements MarkdownStructure
{

	/** {@link MessageFormat} pattern, which is used, when the {@link Header#toString()} method gets called */
	private static final String TEXT_DISPLAY_PATTERN = Header.class.getSimpleName() + "[content={0}]";



	/**
	 * {@inheritDoc}
	 */
	@Override
	public @NotNull String toMarkdown ()
	{
		@Language (MiscConstants.MARKDOWN) final String markdown = "# _{0}:_ {1}\r\n";
		return MessageFormat.format(markdown, this.descriptor, this.content);
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
