package project.docmaker.model;

import project.docmaker.utility.annotation.NoLogger;

import java.text.MessageFormat;

/**
 * A Record which represents one token the C#-File will be analyzed by.
 *
 * @author Lasse-Leander Hillen
 */
@NoLogger
public record Token(String content)
{

	/** {@link MessageFormat} pattern, which is used, when the {@link Token#toString()} method gets called */
	private static final String TEXT_DISPLAY_PATTERN = Token.class.getSimpleName() + "[content={0}]";



	/**
	 * @param content The string value of the token as a content.
	 */
	public Token
	{
	}



	/** {@inheritDoc} **/
	@Override
	public boolean equals (final Object obj)
	{
		if (obj instanceof final Token other)
		{
			return this == other || this.content.equals(other.content());
		}
		return false;
	}



	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state.
	 *
	 * @return A formatted {@link String} which represents the object in its current state.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TEXT_DISPLAY_PATTERN, this.content());
	}

}
