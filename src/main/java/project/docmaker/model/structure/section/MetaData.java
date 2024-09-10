package project.docmaker.model.structure.section;

import project.docmaker.model.structure.Body;
import project.docmaker.model.structure.Header;
import project.docmaker.utility.annotation.NoLogger;

import java.text.MessageFormat;

/**
 * The  {@code MetaData} record represents the metadata of a section. So basically the information the user gets by just looking at the documentation
 * in the c# file.
 *
 * @param header The header instance of the metadata instance
 * @param body   The body instance of the metadata instance
 *
 * @author Lasse-Leander Hillen
 * @since 10.09.2024
 */
@NoLogger
public record MetaData(Header header, Body body)
{

	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Section#toString()} method gets called
	 */
	private static final String TEXT_DISPLAY_PATTERN = MetaData.class.getSimpleName() + "[header={0}, body={1}]";



	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state.
	 *
	 * @return A formatted {@link String} which represents the object in its current state.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TEXT_DISPLAY_PATTERN, this.header, this.body);
	}
}
