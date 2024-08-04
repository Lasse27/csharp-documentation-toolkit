package project.docmaker.model;


public class MethodSection extends Section
{

	protected MethodSection (final Header header, final Description description)
	{
		super(header, description);
	}



	protected MethodSection (final String headerText, final String descriptionText)
	{
		super(headerText, descriptionText);
	}

}
