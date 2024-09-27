package project.docmaker.utility;


import project.docmaker.utility.mlogger.NoLogger;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

import static project.docmaker.utility.MiscConstants.EMPTY_STRING;


@NoLogger
public record StringFormat(FormatOption... options)
{

	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link StringFormat#toString()} method gets called
	 */
	private static final String TEXT_DISPLAY_PATTERN = StringFormat.class.getSimpleName() + "[options={0}]";


	private static String removeMarks (final String input)
	{
		return input.replaceAll("/{3}", EMPTY_STRING).strip();
	}


	private static String upperString (final String input)
	{
		return input.toUpperCase(Locale.ROOT);
	}


	private static String lowerString (final String input)
	{

		return input.toLowerCase(Locale.ROOT);
	}


	private static String normalizeString (final String input)
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


	public String apply (final String input)
	{
		String adjustedString = input;
		for (final FormatOption option : this.options)
		{
			switch (option)
			{
				case NORMALIZE -> adjustedString = StringFormat.normalizeString(adjustedString);
				case REMOVE_MARKS -> adjustedString = StringFormat.removeMarks(adjustedString);
				case TO_LOWER -> adjustedString = StringFormat.lowerString(adjustedString);
				case TO_UPPER -> adjustedString = StringFormat.upperString(adjustedString);
			}
		}
		return adjustedString;
	}


	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state.
	 *
	 * @return A formatted {@link String} which represents the object in its current state.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TEXT_DISPLAY_PATTERN, Arrays.toString(this.options));
	}


	public enum FormatOption
	{
		NORMALIZE,

		REMOVE_MARKS,

		TO_UPPER,

		TO_LOWER;


		/**
		 * {@link MessageFormat} pattern, which is used, when the {@link FormatOption#toString()} method gets called
		 */
		private static final String TEXT_DISPLAY_PATTERN = FormatOption.class.getSimpleName() + "[value={0}]";


		/**
		 * Generates and returns a formatted {@link String} which represents the instance in its current state.
		 *
		 * @return A formatted {@link String} which represents the object in its current state.
		 */
		@Override
		public String toString ()
		{
			return MessageFormat.format(TEXT_DISPLAY_PATTERN, this);
		}
	}
}
