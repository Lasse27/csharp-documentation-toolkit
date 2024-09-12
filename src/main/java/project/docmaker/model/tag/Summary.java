package project.docmaker.model.tag;

import project.docmaker.utility.NoLogger;

import java.text.MessageFormat;

@NoLogger
public record Summary(String content)
{

	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Summary#toString()} method gets called
	 */
	private static final String TEXT_DISPLAY_PATTERN = Summary.class.getSimpleName() + "[content={0}]";



	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state.
	 *
	 * @return A formatted {@link String} which represents the object in its current state.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TEXT_DISPLAY_PATTERN, this.content);
	}
}
