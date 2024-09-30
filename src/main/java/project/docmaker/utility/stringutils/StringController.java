package project.docmaker.utility.stringutils;


import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.StringTokenizer;


public final class StringController
{

	public static final String TRIPLE_SLASH = "///";

	public static final String CARRIAGE_RETURN = "\r";

	public static final String TAB = "\t";

	public static final String NEW_LINE = "\n";

	public static final String MINUS = "-";

	public static final String EMPTY_STRING = "";

	public static final String WHITESPACE = " ";

	private static final Locale LOCALE = Locale.GERMANY;


	/**
	 * Private constructor since controller class isn't supposed to be initialized ever.
	 */
	private StringController ()
	{
	}


	/**
	 * @param input
	 *
	 * @return
	 */
	@Contract (pure = true)
	public static @NotNull String removeMarks (final @NotNull String input)
	{
		return input.replaceAll("/{3}", EMPTY_STRING).strip();
	}


	/**
	 * @param input
	 *
	 * @return
	 */
	@Contract (pure = true)
	public static @NotNull String upperString (final @NotNull String input)
	{
		return input.toUpperCase(LOCALE);
	}


	/**
	 * @param input
	 *
	 * @return
	 */
	@Contract (pure = true)
	public static @NotNull String lowerString (final @NotNull String input)
	{
		return input.toLowerCase(LOCALE);
	}


	/**
	 * @param input
	 *
	 * @return
	 */
	@Contract (pure = true)
	public static @NotNull String headerString (final @NotNull String input)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		final String[] subStrings = StringController.removeRedundantWhitespaces(input).split(WHITESPACE);
		for (final String substring : subStrings)
		{
			final char[] chars = substring.toCharArray();
			chars[0] = Character.toUpperCase(chars[0]);
			stringBuilder.append(new String(chars)).append(WHITESPACE);
		}
		return stringBuilder.toString().strip();
	}


	/**
	 * @param input
	 *
	 * @return
	 */
	@Contract (pure = true)
	public static @NotNull String normalizeString (final @NotNull String input)
	{
		final StringTokenizer tokenizer = new StringTokenizer(StringController.removeRedundantWhitespaces(input));
		final StringBuilder stringBuilder = new StringBuilder();
		while (tokenizer.hasMoreTokens())
		{
			stringBuilder.append(tokenizer.nextToken()).append(WHITESPACE);
		}
		return stringBuilder.toString().trim();
	}


	@Contract (pure = true)
	private static @NotNull String removeRedundantWhitespaces (final @NotNull String input)
	{
		return input.trim().replaceAll(" +", WHITESPACE);
	}
}
