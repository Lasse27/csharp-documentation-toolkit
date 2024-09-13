package project.docmaker.model.generation;

import java.io.File;
import java.text.MessageFormat;

public record GenerationJob(File sourceFile, File targetFile)
{
	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state.
	 *
	 * @return A formatted {@link String} which represents the object in its current state.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format("GenerationJob'{'sourceFile={0}, targetFile={1}'}'", this.sourceFile, this.targetFile);
	}
}
