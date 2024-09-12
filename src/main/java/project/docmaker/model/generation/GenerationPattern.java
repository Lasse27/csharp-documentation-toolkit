package project.docmaker.model.generation;

import project.docmaker.utility.NoLogger;

import java.text.MessageFormat;

/**
 * The record {@code GenerationPattern} represents a Pattern, that can be used to create instances of {@link GenerationJob} with the
 * {@link GenerationJobFactory} class. A {@code GenerationPattern} is normally created by collecting the user inputs from the GUI.
 *
 * @param sourceFolderPath The path that contains the C#-Files that are supposed to be converted to Markdown.
 * @param targetFolderPath The path of the folder, that'll contain the generated Markdown documents.
 *
 * @author Lasse-Leander Hillen
 * @see Record
 * @see GenerationJobFactory
 * @see GenerationJob
 * @since 12.09.2024
 */
@NoLogger
public record GenerationPattern(String sourceFolderPath, String targetFolderPath)
{

	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link GenerationPattern#toString()} method gets called
	 */
	private static final String TEXT_DISPLAY_PATTERN = GenerationPattern.class.getSimpleName() + "[sourceFolderPath={0}, targetFolderPath={1}]";



	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state.
	 *
	 * @return A formatted {@link String} which represents the object in its current state.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TEXT_DISPLAY_PATTERN, this.sourceFolderPath, this.targetFolderPath);
	}
}
