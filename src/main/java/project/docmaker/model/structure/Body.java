package project.docmaker.model.structure;


import org.jetbrains.annotations.NotNull;
import project.docmaker.model.tag.Parameter;
import project.docmaker.model.tag.Return;
import project.docmaker.model.tag.Summary;
import project.docmaker.utility.mlogger.MLoggable;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;


/**
 * The record {@code Body} represents a {@link MarkdownStructure} that acts like the body of each Markdown section. It contains the description of the section as well as
 * several collections of different parameters that can be found in C#-Documentation.
 *
 * @param parameters The {@link Collection} of {@link Summary} that resembles the summary of the {@code Body}.
 * @param returns    The {@link Collection} of {@link Return} that resembles the returns of the {@code Body}.
 * @param summaries  The {@link Collection} of {@link Parameter} that resembles the parameters of the {@code Body}.
 *
 * @author Lasse-Leander Hillen
 * @see Record
 * @see MarkdownStructure
 * @since 11.09.2024
 */
public record Body(Collection<Summary> summaries, Collection<Parameter> parameters, Collection<Return> returns) implements MarkdownStructure, MLoggable
{

	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Body#toString()} method gets called
	 */
	private static final String TEXT_DISPLAY_PATTERN = "{0} @ {1}";


	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Body#toMarkdown()} method gets called
	 */
	private static final String SUMMARY_MD_HEADER = "#### Summary:\r\n";


	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Body#toMarkdown()} method gets called
	 */
	private static final String SUMMARY_MD = "```{0}```\r\n";


	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Body#toMarkdown()} method gets called
	 */
	private static final String PARAMETER_MD_HEADER = "#### Parameters:\r\n";


	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Body#toMarkdown()} method gets called
	 */
	private static final String PARAMS_MD = "- {0}: ```{1}```\r\n";


	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Body#toMarkdown()} method gets called
	 */
	private static final String RETURNS_MD_HEADER = "#### Returns:\r\n";


	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Body#toMarkdown()} method gets called
	 */
	private static final String RETURNS_MD = " ```{0}``` \r\n";



	/**
	 * {@inheritDoc}
	 */
	@Override
	public @NotNull String toMarkdown ()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		if (!this.summaries.isEmpty())
		{
			stringBuilder.append(SUMMARY_MD_HEADER);
			this.summaries.stream().map(summary -> MessageFormat.format(SUMMARY_MD, summary.content())).forEach(stringBuilder::append);
			stringBuilder.append("\r\n");
		}
		if (!this.parameters.isEmpty())
		{
			stringBuilder.append(PARAMETER_MD_HEADER);
			this.parameters.stream().map(param -> MessageFormat.format(PARAMS_MD, param.name(), param.content())).forEach(stringBuilder::append);
			stringBuilder.append("\r\n");
		}
		if (!this.returns.isEmpty())
		{
			stringBuilder.append(RETURNS_MD_HEADER);
			this.returns.stream().map(returns -> MessageFormat.format(RETURNS_MD, returns.content())).forEach(stringBuilder::append);
			stringBuilder.append("\r\n");
		}
		return stringBuilder.toString();
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public @NotNull Collection<String> toStringCollection ()
	{
		final Collection<String> stringCollection = new ArrayList<>();
		stringCollection.add(MessageFormat.format("Instance: {0}", this.toString()));
		stringCollection.add(MessageFormat.format("\tSummaries: {0}", this.summaries));
		stringCollection.add(MessageFormat.format("\tParameters: {0}", this.parameters));
		stringCollection.add(MessageFormat.format("\tReturns: {0}", this.returns));
		return stringCollection;
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
