package project.docmaker.model;

import java.text.MessageFormat;

public class ParamTag extends DocumentationTag
{
	public ParamTag (final String contentType, final String content)
	{
		super(TagContentType.PARAM, new ParamTagContent(contentType, content));
	}



	private record ParamTagContent(String paramName, String paramValue) implements TagContent
	{
		@Override
		public String toString ()
		{
			return MessageFormat.format("ParamTagContent'{'paramName={0}, paramValue={1}'}'", this.paramName, this.paramValue);
		}
	}
}
