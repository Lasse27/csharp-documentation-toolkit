package project.docmaker.control;


import project.docmaker.exception.RegexException;
import project.docmaker.model.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexController
{

	private RegexController () {}


	public static String matchFirst (final Regex regex, final CharSequence content) throws RegexException
	{
		final Pattern pattern = regex.getPattern();
		final Matcher matcher = pattern.matcher(content);
		if (matcher.find())
		{
			return matcher.group();
		}
		throw new RegexException();
	}

}
