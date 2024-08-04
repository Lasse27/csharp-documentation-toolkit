package project.docmaker.model;


public class FieldSection extends Section
{

	protected FieldSection (final Header header, final Description description)
	{
		super(header, description);
	}



	protected FieldSection (final String headerText, final String descriptionText)
	{
		super(headerText, descriptionText);
	}

}
