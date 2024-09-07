package project.docmaker.model.structure.section;


import project.docmaker.model.NoLogger;

import java.text.MessageFormat;


/**
 * The {@code Section} class represents a section of the read c# file.
 *
 * @author Lasse-Leander Hillen
 * @since 07.09.2024
 */
@NoLogger
public abstract class Section
{

	/** {@link MessageFormat} pattern, which is used, when the {@link Section#toString()} method gets called */
	private static final String TEXT_DISPLAY_PATTERN = Section.class.getSimpleName() + "[metaData={0}]";


	/** The metadata information about the {@link Section} instance. */
	private final MetaData metaData;



	/**
	 * Standard constructor, which initializes the object with all the necessary instance fields.
	 *
	 * @param metaData The metadata information about the {@link Section} instance.
	 */
	protected Section (final MetaData metaData)
	{
		this.metaData = metaData;
	}



	/**
	 * Getter-Method for the Markdown format of the section instance.
	 *
	 * @return A String that represents the Markdown format of the section instance.
	 */
	public abstract String getMarkdownFormat ();



	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state.
	 *
	 * @return A formatted {@link String} which represents the object in its current state.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TEXT_DISPLAY_PATTERN, this.metaData);
	}
}
