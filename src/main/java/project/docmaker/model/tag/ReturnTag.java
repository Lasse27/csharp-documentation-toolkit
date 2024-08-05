package project.docmaker.model.tag;

import project.docmaker.model.NoLogger;

import java.text.MessageFormat;

import static project.docmaker.model.tag.ReturnTag.ReturnTagContent;

@NoLogger
public class ReturnTag implements DocumentationTag<ReturnTagContent>
{

	private final ReturnTagContent tagContent;



	public ReturnTag (final String content)
	{
		this.tagContent = new ReturnTagContent(content);
	}



	@Override
	public TagContentType getContentType ()
	{
		return TagContentType.RETURNS;
	}



	@Override
	public ReturnTagContent getTagContent ()
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

