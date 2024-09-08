package project.docmaker.model.structure.section.implementation;

import project.docmaker.model.structure.section.MetaData;
import project.docmaker.model.structure.section.Section;
import project.docmaker.utility.annotation.NoLogger;

@NoLogger
public class FieldSection extends Section
{

	/**
	 * Standard constructor, which initializes the object with all the necessary instance fields.
	 *
	 * @param metaData The metadata information about the {@link ClassSection} instance.
	 */
	public FieldSection (final MetaData metaData)
	{
		super(metaData);
	}



	/**
	 * Getter-Method for the Markdown format of the section instance.
	 *
	 * @return A String that represents the Markdown format of the section instance.
	 */
	@Override
	public String getMarkdownFormat ()
	{
		return "";
	}



	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state.
	 *
	 * @return A formatted {@link String} which represents the object in its current state.
	 */
	@Override
	public String toString ()
	{
		return super.toString();
	}
}
