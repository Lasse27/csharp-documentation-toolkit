package project.docmaker.model.structure.section.implementation;


import project.docmaker.model.structure.section.MetaData;
import project.docmaker.model.structure.section.Section;
import project.docmaker.utility.annotation.NoLogger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * The {@code ClassSection} class represents a section in the Markdown document that represents a class.
 *
 * @author Lasse-Leander Hillen
 * @see Section
 * @since 10.09.2024
 */
@NoLogger
public class ClassSection extends Section
{

	/**
	 * {@link List} of {@link ClassSection} of the instance.
	 */
	private final List<ClassSection> subClasses = new ArrayList<>();


	/**
	 * {@link List} of {@link FieldSection} of the instance.
	 */
	private final List<FieldSection> subFields = new ArrayList<>();


	/**
	 * {@link List} of {@link MethodSection} of the instance.
	 */
	private final List<MethodSection> subMethods = new ArrayList<>();



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



	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state.
	 *
	 * @return A formatted {@link String} which represents the object in its current state.
	 */
	@Override
	public Collection<String> getSectionInformation ()
	{
		final Collection<String> objectInformation = new ArrayList<>();
		objectInformation.add("Class: " + this.getClass().getSimpleName());
		objectInformation.add("Header: " + this.getMetaData().header());
		objectInformation.add("Description: " + this.getMetaData().body().description());
		objectInformation.add("Tags: " + this.getMetaData().body().documentationTags());
		objectInformation.add("Code: " + this.getMetaData().body().snippet());
		return objectInformation;
	}

}
