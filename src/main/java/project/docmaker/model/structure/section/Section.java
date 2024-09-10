package project.docmaker.model.structure.section;


import project.docmaker.utility.annotation.NoLogger;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;


/**
 * The {@code Section} class represents a section in the generated Markdown document.
 *
 * @param metaData The metadata information about the {@link Section} instance.
 *
 * @author Lasse-Leander Hillen
 * @since 10.09.2024
 */
@NoLogger
public record Section(MetaData metaData)
{

	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Section#toString()} method gets called
	 */
	private static final String TEXT_DISPLAY_PATTERN = Section.class.getSimpleName() + "[metaData={0}]";



	/**
	 * Generates and returns a {@link Collection} of {@link String} which represents the instance in its current state.
	 *
	 * @return A {@link Collection} of {@link String} which represents the object in its current state.
	 */
	public Collection<String> toStringCollection ()
	{
		final Collection<String> objectInformation = new ArrayList<>();
		objectInformation.add("Class: " + this.getClass().getSimpleName());
		objectInformation.add("Header: " + this.metaData().header());
		objectInformation.add("Description: " + this.metaData().body().description());
		objectInformation.add("Tags: " + this.metaData().body().documentationTags());
		objectInformation.add("Code: " + this.metaData().body().snippet());
		return objectInformation;
	}



	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state.
	 *
	 * @return A formatted {@link String} which represents the object in its current state.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TEXT_DISPLAY_PATTERN, this.metaData);
	}
}
