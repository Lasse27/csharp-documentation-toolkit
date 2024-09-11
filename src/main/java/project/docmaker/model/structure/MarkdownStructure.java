package project.docmaker.model.structure;

import org.jetbrains.annotations.NotNull;

public interface MarkdownStructure
{
	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state and as a Markdown string.
	 *
	 * @return A formatted {@link String} which represents the instance in its current state and as a Markdown string.
	 */
	@NotNull
	String toMarkdown ();
}
