package project.docmaker.model.structure;

import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NotNull;
import project.docmaker.utility.annotation.NoLogger;

import java.text.MessageFormat;

import static project.docmaker.utility.constant.MiscConstants.MARKDOWN;

@NoLogger
public record Footer(Snippet snippet) implements MarkdownStructure
{

	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Footer#toString()} method gets called
	 */
	private static final String TEXT_DISPLAY_PATTERN = Footer.class.getSimpleName() + "[snippet={0}]";



	/**
	 * {@inheritDoc}
	 */
	@Override
	public @NotNull String toMarkdown ()
	{
		@Language (MARKDOWN) final String markdown = "### _{0}:_ ``{1}``\r\n";
		return MessageFormat.format(markdown, "Code-Snippet", this.snippet.content());
	}



	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state.
	 *
	 * @return A formatted {@link String} which represents the object in its current state.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TEXT_DISPLAY_PATTERN, this.snippet);
	}
}
