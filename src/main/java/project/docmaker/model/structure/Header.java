package project.docmaker.model.structure;

import project.docmaker.model.structure.section.Section;
import project.docmaker.utility.annotation.NoLogger;

import java.text.MessageFormat;

/**
 * The abstract class {@code Header} represents the header of one {@link Section} instance.
 *
 * @param content The string instance of the abstract section instance which represents the content
 *
 * @author Lasse-Leander Hillen
 * @since 02.09.2024
 */
@NoLogger
public record Header(String modifier, String type, String content)
{

	/** {@link MessageFormat} pattern, which is used, when the {@link Header#toString()} method gets called */
	private static final String TEXT_DISPLAY_PATTERN = Header.class.getSimpleName() + "[content={0}]";



	/**
	 * Getter-Method for the {@link Header#content} attribute of the instance.
	 *
	 * @return Returns the {@link String} instance of the calling instance.
	 */
	@Override
	public String content ()
	{
		return this.content;
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
