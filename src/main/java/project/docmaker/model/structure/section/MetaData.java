package project.docmaker.model.structure.section;

import project.docmaker.model.structure.Body;
import project.docmaker.model.structure.Footer;
import project.docmaker.model.structure.Header;
import project.docmaker.utility.annotation.NoLogger;

import java.text.MessageFormat;


@NoLogger
public record MetaData(Header header, Body body, Footer footer)
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
