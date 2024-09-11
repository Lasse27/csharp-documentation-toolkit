package project.docmaker.model.structure;

import project.docmaker.model.tag.Parameter;
import project.docmaker.model.tag.Return;
import project.docmaker.model.tag.Summary;
import project.docmaker.utility.annotation.NoLogger;

import java.text.MessageFormat;
import java.util.Collection;


@NoLogger
public record Body(Collection<Summary> summaryCollection, Collection<Parameter> parameterCollection, Collection<Return> returnCollection)
{

	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Body#toString()} method gets called
	 */
	private static final String TEXT_DISPLAY_PATTERN = Body.class.getSimpleName() + "[summaries={0}, parameters={1}, returns={2}]";



	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state.
	 *
	 * @return A formatted {@link String} which represents the object in its current state.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TEXT_DISPLAY_PATTERN, this.summaryCollection, this.parameterCollection, this.returnCollection);
	}
}
