package project.docmaker.model.section.implementation;


import project.docmaker.model.NoLogger;
import project.docmaker.model.section.Body;
import project.docmaker.model.section.Footer;
import project.docmaker.model.section.Header;
import project.docmaker.model.section.Section;

import java.util.List;



/**
 *
 */
@NoLogger
public class ClassSection extends Section
{

	private List<FieldSection> fields;

	private List<MethodSection> methods;



	public ClassSection (final Header header, final Body body, final Footer footer)
	{
		super(header, body, footer);
	}



	/**
	 * Getter-Method for the {@link List} of {@link FieldSection} of the instance.
	 *
	 * @return A {@link List} of {@link FieldSection} objects representing the methods of the class section.
	 */
	public List<FieldSection> getFields ()
	{
		return this.fields;
	}



	/**
	 * Getter-Method for the {@link List} of {@link MethodSection} of the instance.
	 *
	 * @return A {@link List} of {@link MethodSection} objects representing the methods of the class section.
	 */
	public List<MethodSection> getMethods ()
	{
		return this.methods;
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
