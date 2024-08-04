package project.docmaker.model;

import java.text.MessageFormat;

@NoLogger
public class Header
{
	private final HeaderType type;

	private final String content;



	public Header (final HeaderType type, final String content)
	{
		this.type = type;
		this.content = content;
	}



	public HeaderType getType ()
	{
		return this.type;
	}



	public String getContent ()
	{
		return this.content;
	}



	@Override
	public String toString ()
	{
		return MessageFormat.format("Header'{'type={0}, content=''{1}'''}'", this.type, this.content);
	}



	@NoLogger
	public static enum HeaderType
	{
		CLASS,
		FIELD,
		METHOD
	}
}
