package project.docmaker.model.tag;

import project.docmaker.model.tag.ParamTag.ParamTagContent;

import java.text.MessageFormat;

public class ParamTag implements DocumentationTag<ParamTagContent>
{
	private ParamTagContent tagContent = null;



	public ParamTag (final String contentType, final String paramText)
	{
		this.tagContent = new ParamTagContent(contentType, paramText);
	}



	@Override
	public TagContentType getContentType ()
	{
		return TagContentType.PARAM;
	}



	@Override
	public ParamTagContent getTagContent ()
	{
		return this.tagContent;
	}



	@Override
	public String toString ()
	{
		return MessageFormat.format("ParamTag'{'content={0}'}'", this.tagContent);
	}



	public record ParamTagContent(String paramName, String paramValue) implements TagContent
	{
		@Override
		public String toString ()
		{
			return MessageFormat.format("ParamTagContent'{'paramName={0}, paramValue={1}'}'", this.paramName, this.paramValue);
		}
	}

}
