package project.docmaker.model;


import java.text.MessageFormat;


public class Section
{

	private final Header header;

	private final Description description;

	private final DocumentationTag[] tags;


	Section (final Header header, final Description description, final DocumentationTag... tags)
	{
		this.header = header;
		this.description = description;
		this.tags = tags;
	}


	Section (final String headerText, final String descriptionText, final DocumentationTag... tags)
	{
		this.header = new Header(headerText);
		this.description = new Description(descriptionText);
		this.tags = tags;
	}


	public Header getHeader ()
	{
		return this.header;
	}


	public Description getDescription ()
	{
		return this.description;
	}


	@Override
	public String toString ()
	{
		return MessageFormat.format("Section'{'header={0}, description={1}'}'", this.header, this.description);
	}


	public DocumentationTag[] getTags ()
	{
		return this.tags;
	}

}
