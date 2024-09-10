package project.docmaker.control;

import project.docmaker.model.structure.Body;
import project.docmaker.model.structure.Description;
import project.docmaker.model.structure.Header;
import project.docmaker.model.structure.Snippet;
import project.docmaker.model.structure.section.MetaData;
import project.docmaker.model.structure.section.implementation.ClassSection;
import project.docmaker.utility.constant.LoggingConstants;
import project.docmaker.utility.logging.ILogger;
import project.docmaker.utility.logging.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public final class FileController
{

	private static final ILogger LOGGER = new Logger(FileController.class.getSimpleName());



	private FileController ()
	{
	}



	/**
	 * Gets the documentation of a c# file as a {@link ClassSection} instance.
	 *
	 * @param file The file that contains the wanted documentation.
	 *
	 * @return A new instance of {@code ClassSection} that represents the documentation.
	 *
	 * @throws IOException If the file couldn't be read or similar.
	 */
	public static ClassSection getDocumentation (final File file) throws IOException
	{
		// Converting the file content to string
		final String fileString = Files.readString(file.toPath());

		// Header-creation
		final Header header = RegexController.getClassHeaderFromArea(fileString);

		// Body creation
		Body body = Body.EMPTY;
		if (RegexController.AreaContainsClassDoc(fileString))
		{
			final Description description = RegexController.getClassDescriptionFromArea(fileString);
			final Snippet codeSnippet = RegexController.getClassCodeSnippet(fileString);
			body = new Body(description, null, codeSnippet);
		}

		// Creating and logging the classSection
		final ClassSection classSection = new ClassSection(new MetaData(header, body));
		LOGGER.logf(ILogger.Level.NORMAL, LoggingConstants.INSTANCE_CREATED_PTN, classSection);
		return classSection;
	}
}
