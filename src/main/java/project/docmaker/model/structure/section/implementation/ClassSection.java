package project.docmaker.model.structure.section.implementation;


import project.docmaker.model.NoLogger;
import project.docmaker.model.structure.section.MetaData;
import project.docmaker.model.structure.section.Section;

import java.util.ArrayList;
import java.util.List;


@NoLogger
public class ClassSection extends Section
{

	/** {@link List} of {@link ClassSection} of the instance. */
	private final List<ClassSection> subClasses = new ArrayList<ClassSection>();


	/** {@link List} of {@link FieldSection} of the instance. */
	private final List<FieldSection> subFields = new ArrayList<FieldSection>();


	/** {@link List} of {@link MethodSection} of the instance. */
	private final List<MethodSection> subMethods = new ArrayList<MethodSection>();



	/**
	 * Standard constructor, which initializes the object with all the necessary instance fields.
	 *
	 * @param metaData The metadata information about the {@link ClassSection} instance.
	 */
	public ClassSection (final MetaData metaData)
	{
		super(metaData);
	}



	/**
	 * Getter-Method for the {@link List} of {@link FieldSection} of the instance.
	 *
	 * @return A {@link List} of {@link FieldSection} objects representing the methods of the class section.
	 */
	public List<FieldSection> getSubFields ()
	{
		return this.subFields;
	}



	/**
	 * Getter-Method for the {@link List} of {@link MethodSection} of the instance.
	 *
	 * @return A {@link List} of {@link MethodSection} objects representing the methods of the class section.
	 */
	public List<MethodSection> getSubMethods ()
	{
		return this.subMethods;
	}



	/**
	 * Getter-Method for the {@link List} of {@link ClassSection} of the instance.
	 *
	 * @return A {@link List} of {@link ClassSection} objects representing the methods of the class section.
	 */
	public List<ClassSection> getSubClasses ()
	{
		return this.subClasses;
	}



	/** {@inheritDoc} **/
	@Override
	public String getMarkdownFormat ()
	{
		return ""; // TODO: IMPLEMENT
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
