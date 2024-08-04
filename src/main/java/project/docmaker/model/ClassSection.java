package project.docmaker.model;


import java.util.List;


public class ClassSection extends Section
{

	private List<FieldSection> fields;

	private List<MethodSection> methods;


	public ClassSection (final Header header, final Description description)
	{
		super(header, description);
	}


	public ClassSection (final String headerText, final String descriptionText, final DocumentationTag... tags)
	{
		super(headerText, descriptionText, tags);
	}

}
