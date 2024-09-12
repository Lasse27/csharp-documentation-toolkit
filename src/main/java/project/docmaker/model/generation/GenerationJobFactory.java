package project.docmaker.model.generation;

import java.nio.file.Path;


public final class GenerationJobFactory
{
	private GenerationJobFactory ()
	{
	}



	public static GenerationJob createJob (final GenerationPattern pattern)
	{
		// Validating and creating the sourcePath
		if (pattern.sourceFolderPath() == null || pattern.sourceFolderPath().isBlank())
		{
			throw new IllegalArgumentException("Source folder path is null or empty");
		}
		final Path sourcePath = Path.of(pattern.sourceFolderPath());

		// Validating and creating the targetPath
		if (pattern.targetFolderPath() == null || pattern.targetFolderPath().isBlank())
		{
			throw new IllegalArgumentException("Target folder path is null or empty");
		}
		final Path targetPath = Path.of(pattern.targetFolderPath());

		// Creating and returning the instance with validated attributes
		return new GenerationJob(sourcePath, targetPath);
	}
}
