package project.docmaker.model.generation;


import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import project.docmaker.utility.serialize.JsonFile;

import java.io.File;
import java.nio.file.Path;
import java.time.Instant;


public final class GenerationJobFactory
{
	private GenerationJobFactory () {}



	@Contract ("_ -> new")
	public static @NotNull GenerationJob createJob (final GenerationPattern pattern)
	{
		// Validating and creating the sourceFile
		if (pattern.sourceFolderPath() == null || pattern.sourceFolderPath().isBlank())
		{
			throw new IllegalArgumentException("Source folder path is null or empty");
		}
		final JsonFile sourcePath = new JsonFile(pattern.sourceFolderPath());

		// Validating and creating the targetFile
		if (pattern.targetFolderPath() == null || pattern.targetFolderPath().isBlank())
		{
			throw new IllegalArgumentException("Target folder path is null or empty");
		}
		final JsonFile targetPath = new JsonFile(pattern.targetFolderPath());

		// Creating and returning the instance with validated attributes
		return new GenerationJob(Instant.now(), sourcePath, targetPath);
	}
}
