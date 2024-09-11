package project.docmaker.model.structure;

import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NotNull;
import project.docmaker.model.tag.Parameter;
import project.docmaker.model.tag.Return;
import project.docmaker.model.tag.Summary;
import project.docmaker.utility.annotation.NoLogger;
import project.docmaker.utility.constant.MiscConstants;

import java.text.MessageFormat;
import java.util.Collection;


@NoLogger
public record Body(Collection<Summary> summaries, Collection<Parameter> parameters, Collection<Return> returns) implements MarkdownStructure
{

	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Body#toString()} method gets called
	 */
	private static final String TEXT_DISPLAY_PATTERN = Body.class.getSimpleName() + "[summaries={0}, parameters={1}, returns={2}]";



	/**
	 * {@inheritDoc}
	 */
	@Override
	public @NotNull String toMarkdown ()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		if (!this.summaries.isEmpty())
		{
			stringBuilder.append("### _Summary:_\r\n");
			for (final Summary summary : this.summaries)
			{
				@Language (MiscConstants.MARKDOWN) final String summaryMarkdown = "{0}\r\n";
				stringBuilder.append(MessageFormat.format(summaryMarkdown, summary.content()));
			}
		}

		if (!this.parameters.isEmpty())
		{
			stringBuilder.append("### _Parameters:_\r\n");
			for (final Parameter parameter : this.parameters)
			{
				@Language (MiscConstants.MARKDOWN) final String parameterMarkdown = "#### _{0}:_ ``{1}``\r\n";
				stringBuilder.append(MessageFormat.format(parameterMarkdown, parameter.name(), parameter.content()));
			}
		}

		if (!this.returns.isEmpty())
		{
			stringBuilder.append("### _Returns:_\r\n");
			for (final Return returns : this.returns)
			{
				@Language (MiscConstants.MARKDOWN) final String returnsMarkdown = "{0}\r\n";
				stringBuilder.append(MessageFormat.format(returnsMarkdown, returns.content()));
			}
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
