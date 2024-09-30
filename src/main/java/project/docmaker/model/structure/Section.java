package project.docmaker.model.structure;


import org.jetbrains.annotations.NotNull;
import project.docmaker.utility.mlogger.MLoggable;
import project.docmaker.utility.stringutils.StringController;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static project.docmaker.utility.stringutils.StringController.TAB;


public record Section(Header header, Body body, Code code) implements MarkdownStructure, MLoggable
{

	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Header#toString()} method gets called
	 */
	private static final String TEXT_DISPLAY_PATTERN = "{0} @ {1}";


	/**
	 * Generates and returns a {@link Collection} of {@link String} which represents the instance in its current state.
	 *
	 * @return A {@link Collection} of {@link String} which represents the object in its current state.
	 */
	@Override
	public @NotNull Collection<String> toStringCollection ()
	{
		final Collection<String> objectInformation = new ArrayList<>();
		objectInformation.add("Instance: " + this.toString());
		objectInformation.addAll(this.header.toStringCollection().stream().map(c -> TAB + c).collect(Collectors.toList()));
		objectInformation.addAll(this.body.toStringCollection().stream().map(c -> TAB + c).collect(Collectors.toList()));
		objectInformation.addAll(this.code.toStringCollection().stream().map(c -> TAB + c).collect(Collectors.toList()));
		return objectInformation;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TEXT_DISPLAY_PATTERN, this.getClass().getSimpleName(), Integer.toHexString(this.hashCode()));
	}


	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state and as a Markdown string.
	 *
	 * @return A formatted {@link String} which represents the instance in its current state and as a Markdown string.
	 */
	@Override
	public @NotNull String toMarkdown ()
	{
		final StringBuilder stringBuilder = new StringBuilder();
		if (this.header == Header.EMPTY)
		{
			return "";
		}
		stringBuilder.append(this.header.toMarkdown());
		stringBuilder.append(StringController.NEW_LINE);
		stringBuilder.append(this.body.toMarkdown());
		stringBuilder.append(this.code().toMarkdown());
		stringBuilder.append(StringController.NEW_LINE).append("---").append(StringController.NEW_LINE);
		return stringBuilder.toString();
	}
}
