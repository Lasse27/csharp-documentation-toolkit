package project.docmaker.model.structure;


import org.jetbrains.annotations.NotNull;


/**
 * The interface {@code MarkdownStructure} is implemented as an {@link FunctionalInterface} that only provides a method and resembles a single
 * structure within a section of the Markdown document.
 *
 * @author Lasse-Leander Hillen
 * @see Body
 * @see Code
 * @see Header
 * @see FunctionalInterface
 * @since 11.09.2024
 */
@FunctionalInterface
interface MarkdownStructure
{
	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state and as a Markdown string.
	 *
	 * @return A formatted {@link String} which represents the instance in its current state and as a Markdown string.
	 */
	@NotNull
	String toMarkdown ();
}
