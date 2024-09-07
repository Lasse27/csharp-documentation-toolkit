package project.docmaker.model.structure;

import project.docmaker.model.NoLogger;

import java.text.MessageFormat;

@NoLogger
public record Description(String content)
{

	/** {@link MessageFormat} pattern, which is used, when the {@link Description#toString()} method gets called */
	private static final String TEXT_DISPLAY_PATTERN = Description.class.getSimpleName() + "[content={0}]";



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