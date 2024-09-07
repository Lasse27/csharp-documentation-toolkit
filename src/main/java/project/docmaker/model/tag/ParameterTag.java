package project.docmaker.model.tag;

import java.text.MessageFormat;

public class ParameterTag implements Tag
{
	private final ParamTagContent tagContent;



	public ParameterTag (final String contentType, final String paramText)
	{
		this.tagContent = new ParamTagContent(contentType, paramText);
	}



	@Override
	public TagType getType ()
	{
		return TagType.PARAM;
	}



	@Override
	public ParamTagContent getContent ()
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
