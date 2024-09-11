package project.docmaker.model.format;

import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

import static project.docmaker.utility.constant.MiscConstants.EMPTY_STRING;

public class StringFormat
{
	private final FormatOption[] options;



	public StringFormat (final FormatOption... options)
	{
		this.options = options;
	}



	public String apply (final String input)
	{
		String adjustedString = input;
		for (final FormatOption option : this.options)
		{
			switch (option)
			{
				case NORMALIZE -> adjustedString = NormalizeString(adjustedString);
				case REMOVE_MARKS -> adjustedString = RemoveMarks(adjustedString);
				case TO_LOWER -> adjustedString = LowerString(adjustedString);
				case TO_UPPER -> adjustedString = UpperString(adjustedString);
			}
		}
		return adjustedString;
	}



	private static String RemoveMarks (final String input)
	{
		return input.replaceAll("/{3}", EMPTY_STRING).strip();
	}



	private static String UpperString (final String input)
	{
		return input.toUpperCase(Locale.ROOT);
	}



	private static String LowerString (final String input)
	{

		return input.toLowerCase(Locale.ROOT);
	}



	private static String NormalizeString (final String input)
	{
		final String configured = input.trim().replaceAll(" +", " ");
		final StringTokenizer tokenizer = new StringTokenizer(configured);
		final StringBuilder stringBuilder = new StringBuilder();
		while (tokenizer.hasMoreTokens())
		{
			stringBuilder.append(" ").append(tokenizer.nextToken());
		}
		return stringBuilder.toString();
	}



	public FormatOption[] getOptions ()
	{
		return this.options;
	}



	@Override
	public String toString ()
	{
		return "StringFormat{" +
		       "options=" + Arrays.toString(this.options) +
		       '}';
	}
}
