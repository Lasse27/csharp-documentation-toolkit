package project.docmaker.model.structure.section.implementation;

import project.docmaker.model.structure.section.MetaData;
import project.docmaker.model.structure.section.Section;
import project.docmaker.utility.annotation.NoLogger;

import java.util.Collection;
import java.util.List;

@NoLogger
public class MethodSection extends Section
{

	/**
	 * Standard constructor, which initializes the object with all the necessary instance fields.
	 *
	 * @param metaData The metadata information about the {@link ClassSection} instance.
	 */
	public MethodSection (final MetaData metaData)
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
	 * @return
	 */
	@Override
	public Collection<String> getSectionInformation ()
	{
		return List.of();
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
