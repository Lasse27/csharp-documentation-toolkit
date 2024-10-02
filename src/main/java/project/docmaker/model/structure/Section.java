package project.docmaker.model.structure;


import org.jetbrains.annotations.NotNull;
import project.docmaker.utility.mlogger.MLoggable;
import project.docmaker.utility.stringutils.StringController;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;

import static project.docmaker.utility.stringutils.StringController.TAB;


public record Section(Header header, Body body, Code code) implements MarkdownStructure, MLoggable
{

	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Header#toString()} method gets called
	 */
	private static final String TEXT_DISPLAY_PATTERN = "{0} @ {1}";



	/**
	 * {@inheritDoc}
	 */
	@Override

	public @NotNull Collection<String> toStringCollection ()
	{
		final Collection<String> objectInformation = new ArrayList<>();
		objectInformation.add(MessageFormat.format("Instance: {0}", this.toString()));
		objectInformation.addAll(this.header.toStringCollection().stream().map(descriptorString -> TAB + descriptorString).toList());
		objectInformation.addAll(this.body.toStringCollection().stream().map(descriptorString -> TAB + descriptorString).toList());
		objectInformation.addAll(this.code.toStringCollection().stream().map(descriptorString -> TAB + descriptorString).toList());
		return objectInformation;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public @NotNull String toMarkdown ()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(this.header.toMarkdown());
		stringBuilder.append(StringController.NEW_LINE);

		stringBuilder.append(this.body.toMarkdown());
		stringBuilder.append(StringController.NEW_LINE);

		stringBuilder.append(this.code.toMarkdown());
		stringBuilder.append(StringController.NEW_LINE);

		stringBuilder.append("---").append(StringController.NEW_LINE);
		return stringBuilder.toString();
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public @NotNull String toString ()
	{
		return MessageFormat.format(TEXT_DISPLAY_PATTERN, this.getClass().getSimpleName(), Integer.toHexString(this.hashCode()));
	}
}
