package project.docmaker.model.generation;

import java.nio.file.Path;

public record GenerationJob(Path sourcePath, Path targetPath)
{
	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state.
	 *
	 * @return A formatted {@link String} which represents the object in its current state.
	 */
	@Override
	public String toString ()
	{
		return "GenerationJob{" + "sourcePath=" + this.sourcePath + ", targetPath=" + this.targetPath + '}';
	}
}
