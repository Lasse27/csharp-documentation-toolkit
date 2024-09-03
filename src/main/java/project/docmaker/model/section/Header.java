package project.docmaker.model.section;

import project.docmaker.model.NoLogger;

import java.text.MessageFormat;

/**
 * The abstract class {@code Header} represents the header of one {@link Section} instance.
 *
 * @author Lasse-Leander Hillen
 * @since 02.09.2024
 */
@NoLogger
public class Header
{

	/** {@link MessageFormat} pattern, which is used, when the {@link Body#toString()} method gets called */
	private static final String TO_STRING_PATTERN = "Header'{'title=''{0}'''}'";


	/** The string instance of the abstract section instance which represents the title */
	private final String title;



	/**
	 * Standard constructor, which initializes the object with all the necessary instance fields.
	 *
	 * @param title The header instance of the abstract section instance
	 */
	public Header (final String title)
	{
		this.title = title;
	}



	/**
	 * Getter-Method for the {@link Header#title} attribute of the instance.
	 *
	 * @return Returns the {@link String} instance of the calling instance.
	 */
	public String getTitle ()
	{
		return this.title;
	}



	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state.
	 *
	 * @return A formatted {@link String} which represents the object in its current state.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.title);
	}
}
