package project.docmaker.model.section;


import project.docmaker.model.NoLogger;

import java.text.MessageFormat;


/**
 * The {@code Section} class represents an abstract section of the generated document.
 */
@NoLogger
public abstract class Section
{

	/** {@link MessageFormat} pattern, which is used, when the {@link Section#toString()} method gets called */
	private static final String TO_STRING_PATTERN = "Section'{'header={0}, body={1}, footer={2}'}'";


	/** The header instance of the abstract section instance */
	private final Header header;


	/** The body instance of the abstract section instance */
	private final Body body;


	/** The footer instance of the abstract section instance */
	private final Footer footer;



	/**
	 * Standard constructor, which initializes the object with all the necessary instance fields.
	 *
	 * @param header The header instance of the abstract section instance
	 * @param body   The body instance of the abstract section instance
	 * @param footer The footer instance of the abstract section instance
	 */
	Section (final Header header, final Body body, final Footer footer)
	{
		this.header = header;
		this.body = body;
		this.footer = footer;
	}



	/**
	 * Getter-Method for the {@link Section#header} attribute of the instance.
	 *
	 * @return Returns the {@link Header} instance of the calling instance.
	 */
	public Header getHeader ()
	{
		return this.header;
	}



	/**
	 * Getter-Method for the {@link Section#body} attribute of the instance.
	 *
	 * @return Returns the {@link Body} instance of the calling instance.
	 */
	public Body getBody ()
	{
		return this.body;
	}



	/**
	 * Getter-Method for the {@link Section#footer} attribute of the instance.
	 *
	 * @return Returns the {@link Footer} instance of the calling instance.
	 */
	public Footer getFooter ()
	{
		return this.footer;
	}


	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state.
	 *
	 * @return A formatted {@link String} which represents the object in its current state.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.header, this.body, this.footer);
	}
}
