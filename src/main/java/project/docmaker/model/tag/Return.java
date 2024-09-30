package project.docmaker.model.tag;


import java.text.MessageFormat;


public record Return(String content)
{

	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Return#toString()} method gets called
	 */
	private static final String TEXT_DISPLAY_PATTERN = Return.class.getSimpleName() + "[content={0}]";


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
