package project.docmaker.model.structure;

import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NotNull;
import project.docmaker.model.tag.Parameter;
import project.docmaker.model.tag.Return;
import project.docmaker.model.tag.Summary;
import project.docmaker.utility.MiscConstants;
import project.docmaker.utility.NoLogger;

import java.text.MessageFormat;
import java.util.Collection;

/**
 * The record {@code Body} represents a {@link MarkdownStructure} that acts like the body of each Markdown section. It contains the description of the
 * section as well as several collections of different parameters that can be found in C#-Documentation.
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
@NoLogger
public record Body(Collection<Summary> summaries, Collection<Parameter> parameters, Collection<Return> returns) implements MarkdownStructure
{

	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Body#toString()} method gets called
	 */
	private static final String TEXT_DISPLAY_PATTERN = Body.class.getSimpleName() + "[summaries={0}, parameters={1}, returns={2}]";


	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Body#toMarkdown()} method gets called
	 */
	@Language (MiscConstants.MARKDOWN)
	private static final String SUMMARY_MARKDOWN_HEADER = "### _Summary:_\r\n";


	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Body#toMarkdown()} method gets called
	 */
	@Language (MiscConstants.MARKDOWN)
	private static final String SUMMARY_MARKDOWN_PATTERN = "{0}\r\n";


	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Body#toMarkdown()} method gets called
	 */
	@Language (MiscConstants.MARKDOWN)
	private static final String PARAMETER_MARKDOWN_HEADER = "### _Parameters:_\r\n";


	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Body#toMarkdown()} method gets called
	 */
	@Language (MiscConstants.MARKDOWN)
	private static final String PARAMETER_MARKDOWN_PATTERN = "#### _{0}:_ ``{1}``\r\n";


	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Body#toMarkdown()} method gets called
	 */
	@Language (MiscConstants.MARKDOWN)
	private static final String RETURNS_MARKDOWN_HEADER = "### _Returns:_\r\n";


	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Body#toMarkdown()} method gets called
	 */
	@Language (MiscConstants.MARKDOWN)
	private static final String RETURNS_MARKDOWN_PATTERN = "{0}\r\n";



	/**
	 * {@inheritDoc}
	 */
	@Override
	public @NotNull String toMarkdown ()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		if (!this.summaries.isEmpty())
		{
			stringBuilder.append(SUMMARY_MARKDOWN_HEADER);
			this.summaries.stream().map(summary -> MessageFormat.format(SUMMARY_MARKDOWN_PATTERN, summary.content())).forEach(stringBuilder::append);
		}

		if (!this.parameters.isEmpty())
		{
			stringBuilder.append(PARAMETER_MARKDOWN_HEADER);
			this.parameters.stream().map(parameter -> MessageFormat.format(PARAMETER_MARKDOWN_PATTERN, parameter.name(), parameter.content()))
					.forEach(stringBuilder::append);
		}

		if (!this.returns.isEmpty())
		{
			stringBuilder.append(RETURNS_MARKDOWN_HEADER);
			this.returns.stream().map(returns -> MessageFormat.format(RETURNS_MARKDOWN_PATTERN, returns.content())).forEach(stringBuilder::append);
		}


		return stringBuilder.toString();
	}



	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state.
	 *
	 * @return A formatted {@link String} which represents the object in its current state.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TEXT_DISPLAY_PATTERN, this.summaries, this.parameters, this.returns);
	}
}
