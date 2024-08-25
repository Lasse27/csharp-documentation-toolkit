package project.docmaker.model.section;

import project.docmaker.model.CodeSnippet;
import project.docmaker.model.DocumentationTagList;
import project.docmaker.model.NoLogger;

import java.text.MessageFormat;

/**
 * The abstract class {@code Body} represents the body of one instance of {@link Section}
 */
@NoLogger
public abstract class Body
{
	/** {@link MessageFormat} pattern, which is used, when the {@link Body#toString()} method gets called */
	private static final String TO_STRING_PATTERN = "Body'{'description={0}, documentationTags={1}, codeSnippet={2}'}'";


	/** The {@link Description} instance of the abstract section instance */
	private final Description description;


	/** The {@link DocumentationTagList} instance of the abstract section instance */
	private final DocumentationTagList documentationTags;


	/** The header {@link CodeSnippet} of the abstract section instance */
	private final CodeSnippet codeSnippet;


	/**
	 * Standard constructor, which initializes the object with all the necessary instance fields.
	 *
	 * @param description The header instance of the abstract section instance
	 * @param documentationTags   The body instance of the abstract section instance
	 * @param codeSnippet The footer instance of the abstract section instance
	 */
	protected Body (final Description description, final DocumentationTagList documentationTags, final CodeSnippet codeSnippet)
	{
		this.description = description;
		this.documentationTags = documentationTags;
		this.codeSnippet = codeSnippet;
	}



	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.description, this.documentationTags, this.codeSnippet);
	}
}
