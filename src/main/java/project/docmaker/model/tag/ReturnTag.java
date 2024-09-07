package project.docmaker.model.tag;

import project.docmaker.utility.annotation.NoLogger;

import java.text.MessageFormat;

@NoLogger
public class ReturnTag implements Tag
{

	private final ReturnTagContent tagContent;



	public ReturnTag (final String content)
	{
		this.tagContent = new ReturnTagContent(content);
	}



	@Override
	public TagType getType ()
	{
		return TagType.RETURNS;
	}



	@Override
	public ReturnTagContent getContent ()
	{
		return this.tagContent;
	}



	@Override
	public String toString ()
	{
		return MessageFormat.format("ReturnTag'{'tagContent={0}'}'", this.tagContent);
	}



	@NoLogger
	public record ReturnTagContent(String content) implements TagContent
	{
		@Override
		public String toString ()
		{
			return MessageFormat.format("ReturnTagContent'{'content={0}'}'", this.content);
		}
	}

}

