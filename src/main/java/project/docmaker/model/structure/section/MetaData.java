package project.docmaker.model.structure.section;

import project.docmaker.model.NoLogger;
import project.docmaker.model.structure.Body;
import project.docmaker.model.structure.Footer;
import project.docmaker.model.structure.Header;

import java.text.MessageFormat;

/**
 * The  {@code MetaData} record represents the metadata of a section. So basically the information the user gets by just looking at the documentation
 * in the c# file.
 *
 * @param header The header instance of the abstract section instance
 * @param body   The body instance of the abstract section instance
 * @param footer The footer instance of the abstract section instance
 *
 * @author Lasse-Leander Hillen
 * @since 07.09.2024
 */
@NoLogger
public record MetaData(Header header, Body body, Footer footer)
{

	/** {@link MessageFormat} pattern, which is used, when the {@link Section#toString()} method gets called */
	private static final String TEXT_DISPLAY_PATTERN = MetaData.class.getSimpleName() + "[header={0}, body={1}, footer={2}]";



	/**
	 * Getter-Method for the {@link MetaData#header} attribute of the instance.
	 *
	 * @return Returns the {@link Header} instance of the calling instance.
	 */
	@Override
	public Header header ()
	{
		return this.header;
	}



	/**
	 * Getter-Method for the {@link MetaData#body} attribute of the instance.
	 *
	 * @return Returns the {@link Body} instance of the calling instance.
	 */
	@Override
	public Body body ()
	{
		return this.body;
	}



	/**
	 * Getter-Method for the {@link MetaData#footer} attribute of the instance.
	 *
	 * @return Returns the {@link Footer} instance of the calling instance.
	 */
	@Override
	public Footer footer ()
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
		return MessageFormat.format(TEXT_DISPLAY_PATTERN, this.header, this.body, this.footer);
	}
}
