package project.docmaker.model.section;

import project.docmaker.model.CodeSnippet;
import project.docmaker.model.DocumentationTagList;
import project.docmaker.model.NoLogger;
import project.docmaker.model.section.implementation.Description;

import java.text.MessageFormat;

/**
 * The abstract class {@code Body} represents the body of one instance of {@link Section}
 */
@NoLogger
public class Body
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
	 * @param description       The header instance of the abstract section instance
	 * @param documentationTags The body instance of the abstract section instance
	 * @param codeSnippet       The footer instance of the abstract section instance
	 */
	public Body (final Description description, final DocumentationTagList documentationTags, final CodeSnippet codeSnippet)
	{
		this.description = description;
		this.documentationTags = documentationTags;
		this.codeSnippet = codeSnippet;
	}



	/**
	 * Getter-Method for the {@link Body#description} attribute of the instance.
	 *
	 * @return Returns the {@link Description} instance of the calling instance.
	 */
	public Description getDescription ()
	{
		return this.description;
	}



	/**
	 * Getter-Method for the {@link Body#documentationTags} attribute of the instance.
	 *
	 * @return Returns the {@link DocumentationTagList} instance of the calling instance.
	 */
	public DocumentationTagList getDocumentationTags ()
	{
		return this.documentationTags;
	}



	/**
	 * Getter-Method for the {@link Body#codeSnippet} attribute of the instance.
	 *
	 * @return Returns the {@link CodeSnippet} instance of the calling instance.
	 */
	public CodeSnippet getCodeSnippet ()
	{
		return this.codeSnippet;
	}



	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state.
	 *
	 * @return A formatted {@link String} which represents the object in its current state.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.description, this.documentationTags, this.codeSnippet);
	}
}
