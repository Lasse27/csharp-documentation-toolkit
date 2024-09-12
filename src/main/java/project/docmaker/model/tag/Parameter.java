package project.docmaker.model.tag;

import project.docmaker.utility.NoLogger;

import java.text.MessageFormat;

@NoLogger
public record Parameter(String name, String content)
{

	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Parameter#toString()} method gets called
	 */
	private static final String TEXT_DISPLAY_PATTERN = Parameter.class.getSimpleName() + "[name={0}, content={1}]";



	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state.
	 *
	 * @return A formatted {@link String} which represents the object in its current state.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TEXT_DISPLAY_PATTERN, this.name, this.content);
	}
}
