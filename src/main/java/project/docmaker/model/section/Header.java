package project.docmaker.model.section;

import project.docmaker.model.NoLogger;

import java.text.MessageFormat;

@NoLogger
public class Header
{
	private final Class<? extends Section> sectionClass;

	private final String content;



	public Header (final Class<? extends Section> sectionClass, final String content)
	{
		this.sectionClass = sectionClass;
		this.content = content;
	}



	public String getContent ()
	{
		return this.content;
	}



	@Override
	public String toString ()
	{
		return MessageFormat.format("Header'{'sectionClass={0}, content=''{1}'''}'", this.sectionClass.getSimpleName(), this.content);
	}
}
