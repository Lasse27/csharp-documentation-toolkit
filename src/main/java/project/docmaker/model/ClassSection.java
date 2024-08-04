package project.docmaker.model;


import java.text.MessageFormat;
import java.util.List;

import static project.docmaker.control.FileContentController.*;


/**
 *
 */
@NoLogger
public class ClassSection extends Section
{

	private final List<FieldSection> fields;

	private final List<MethodSection> methods;



	public ClassSection (final FileContent fileContent)
	{
		super(getClassName(fileContent), getClassDescription(fileContent), getClassTags(fileContent));
		this.fields = getFieldSections();
		this.methods = getMethodSections();
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
		return MessageFormat.format("ClassSection'{'header={0}, description={1}, fields={2}, methods={3}'}'", this.getHeader(),
				this.getDescription(), this.fields, this.methods);
	}
}
