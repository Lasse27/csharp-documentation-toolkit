package project.docmaker.model.structure;


import project.docmaker.utility.mlogger.NoLogger;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;


@NoLogger
public record Section(Header header, Body body, Code code)
{

	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Section#toString()} method gets called
	 */
	private static final String TEXT_DISPLAY_PATTERN = Section.class.getSimpleName() + "[header={0}, body={1}, codesnippet={2}]";


	/**
	 * Generates and returns a {@link Collection} of {@link String} which represents the instance in its current state.
	 *
	 * @return A {@link Collection} of {@link String} which represents the object in its current state.
	 */
	public Collection<String> toStringCollection ()
	{
		final Collection<String> objectInformation = new ArrayList<>();
		objectInformation.add("Class: " + this.getClass().getSimpleName());
		objectInformation.add("Header: " + this.header);
		objectInformation.add("Code: " + this.code);

		// Add summaries using Stream
		objectInformation.addAll(this.body.summaries().stream().map(summary -> "Summary: " + summary).collect(Collectors.toList()));

		// Add parameters using Stream
		objectInformation.addAll(this.body.parameters().stream().map(parameter -> "Parameter: " + parameter).collect(Collectors.toList()));

		// Add returns using Stream
		objectInformation.addAll(this.body.returns().stream().map(returns -> "Returns: " + returns).collect(Collectors.toList()));

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
		return MessageFormat.format(TEXT_DISPLAY_PATTERN, this.header, this.body, this.code);
	}
}
