package project.docmaker.utility.stringutils;


import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.text.MessageFormat;
import java.util.Arrays;


public record StringFormat(FormatOption... options)
{

	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link StringFormat#toString()} method gets called
	 */
	private static final String TEXT_DISPLAY_PATTERN = StringFormat.class.getSimpleName() + "[options={0}]";



	public String apply (final String input)
	{
		String adjustedString = input;
		for (final FormatOption option : this.options)
		{
			switch (option)
			{
				case NORMALIZE -> adjustedString = StringController.normalizeString(adjustedString);
				case REMOVE_MARKS -> adjustedString = StringController.removeMarks(adjustedString);
				case TO_LOWER -> adjustedString = StringController.lowerString(adjustedString);
				case TO_UPPER -> adjustedString = StringController.upperString(adjustedString);
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
	public @NotNull String toString ()
	{
		return MessageFormat.format(TEXT_DISPLAY_PATTERN, Arrays.toString(this.options));
	}



	public enum FormatOption
	{
		NORMALIZE,

		REMOVE_MARKS,

		TO_LOWER,

		TO_UPPER;


		/**
		 * {@link MessageFormat} pattern, which is used, when the {@link FormatOption#toString()} method gets called
		 */
		private static final String TEXT_DISPLAY_PATTERN = FormatOption.class.getSimpleName() + "[value={0}]";



		/**
		 * Generates and returns a formatted {@link String} which represents the instance in its current state.
		 *
		 * @return A formatted {@link String} which represents the object in its current state.
		 */
		@Contract (pure = true)
		@Override
		public @NotNull String toString ()
		{
			return MessageFormat.format(TEXT_DISPLAY_PATTERN, this);
		}
	}
}
