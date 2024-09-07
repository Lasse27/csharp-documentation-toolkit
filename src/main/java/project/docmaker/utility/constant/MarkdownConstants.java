package project.docmaker.utility.constant;

import project.docmaker.utility.annotation.ConstantInterface;

/**
 * The interface {@code LoggingConstants} contains mainly Markdown formats for the creation of Markdown documents.
 *
 * @author Lasse-Leander Hillen
 * @since 07.09.2024
 */
@ConstantInterface
public interface MarkdownConstants
{
	String MARKDOWN_FILE_EXTENSION = ".md";

	String H1_HEADER = "#";

	String H2_HEADER = "##";

	String H3_HEADER = "###";

	String H4_HEADER = "####";

	String QUOTE = ">";
}
