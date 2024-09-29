package project.docmaker.utility;

import project.docmaker.utility.mlogger.NoLogger;

import java.util.Locale;

@NoLogger
public class StringUtilities
{
	public static final String EMPTY = "";

	public static final String WHITESPACE = " ";

	private static final Locale LOCALE = Locale.GERMANY;



	private StringUtilities ()
	{
	}



	public static String applyHeaderStyle (final String input)
	{
		final String[] splits = StringUtilities.removeRedundantWhitespaces(input).split(WHITESPACE);
//		for (int i = 0; i < splits.to; i++)
//		{
//
//		}
		return input;
	}



	public static String removeRedundantWhitespaces (final String input)
	{
		return input.trim().replaceAll(" +", WHITESPACE);
	}
}
