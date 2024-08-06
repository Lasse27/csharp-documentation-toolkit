package project.docmaker.model;


import project.docmaker.model.tag.DocumentationTag;

import java.text.MessageFormat;


public class Section
{

	private final Header header;

	private final Description description;

	private final DocumentationTagList tags;



	Section (final Header header, final Description description, final DocumentationTag<?>... tags)
	{
		this.header = header;
		this.description = description;
		this.tags = new DocumentationTagList(tags);
	}



	public Header getHeader ()
	{
		return this.header;
	}



	public Description getDescription ()
	{
		return this.description;
	}



	public DocumentationTagList getTags ()
	{
		return this.tags;
	}



	@Override
	public String toString ()
	{
		return MessageFormat.format("Section'{'header={0}, description={1}'}'", this.header, this.description);
	}
}
