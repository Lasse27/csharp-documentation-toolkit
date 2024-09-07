package project.docmaker.model.tag;

import project.docmaker.model.NoLogger;
import project.docmaker.model.Regex;

import java.text.MessageFormat;

@NoLogger
public enum TagType
{
	SUMMARY(new Regex("")),

	REMARKS(new Regex("")),

	RETURNS(new Regex("")),

	PARAM(new Regex("")),

	EXCEPTION(new Regex("")),

	PARA(new Regex("")),

	LIST(new Regex("")),

	CODE_INLINE(new Regex("")),

	CODE(new Regex("")),

	EXAMPLE(new Regex("")),
	EMPTY(new Regex(""));


	private final Regex regex;



	TagType (final Regex regex)
	{
		this.regex = regex;
	}



	public Regex getRegex ()
	{
		return this.regex;
	}



	@Override
	public String toString ()
	{
		return MessageFormat.format("TagContentType'{'regex={0}'}'", this.regex);
	}
}
