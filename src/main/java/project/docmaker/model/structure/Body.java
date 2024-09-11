package project.docmaker.model.structure;

import project.docmaker.model.structure.tag.Parameter;
import project.docmaker.model.structure.tag.Return;
import project.docmaker.model.structure.tag.Summary;
import project.docmaker.utility.annotation.NoLogger;

import java.text.MessageFormat;
import java.util.Collection;


@NoLogger
public record Body(Collection<Summary> summaryCollection, Collection<Parameter> parameterCollection, Collection<Return> returnCollection,
                   Snippet snippet)
{

	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Body#toString()} method gets called
	 */
	private static final String TEXT_DISPLAY_PATTERN = Body.class.getSimpleName() + "[summary={0}, documentationTags={1}, codeSnippet={2}]";



	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state.
	 *
	 * @return A formatted {@link String} which represents the object in its current state.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TEXT_DISPLAY_PATTERN, this.summaryCollection, this.parameterCollection, this.snippet);
	}
}
