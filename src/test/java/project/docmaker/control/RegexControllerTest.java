package project.docmaker.control;

import org.jetbrains.annotations.NonNls;
import org.junit.jupiter.api.Test;
import project.docmaker.utility.logging.ILogger;
import project.docmaker.utility.logging.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.MessageFormat;
import java.util.Collection;

class RegexControllerTest
{
	private static final ILogger LOGGER = new Logger(RegexControllerTest.class.getName());

	@NonNls
	private static final String INCORRECT_DOC_AMOUNT = "Did not find the correct number of docs for: {0}";

	private static final File TEST_FILE_1 = new File("src/main/resources/project/docmaker/RoboCopyJob.cs");

	private static final File TEST_FILE_2 = new File("src/main/resources/project/docmaker/testdocumentation.cs");

	private static final File TEST_FILE_3 = new File("src/main/resources/project/docmaker/testdocumentation_2.cs");



	@Test
	void findAllDocumentations () throws IOException
	{
		final Collection<CharSequence> docs = RegexController.findAllDocumentations(Files.readString(TEST_FILE_1.toPath()));
		assert docs.size() == 10 : MessageFormat.format(INCORRECT_DOC_AMOUNT, TEST_FILE_1);

		final Collection<CharSequence> docs1 = RegexController.findAllDocumentations(Files.readString(TEST_FILE_2.toPath()));
		assert docs1.size() == 3 : MessageFormat.format(INCORRECT_DOC_AMOUNT, TEST_FILE_2);

		final Collection<CharSequence> docs2 = RegexController.findAllDocumentations(Files.readString(TEST_FILE_3.toPath()));
		assert docs2.size() == 20 : MessageFormat.format(INCORRECT_DOC_AMOUNT, TEST_FILE_3);
	}



	@Test
	void getSectionFromCharSequence ()
	{
	}
}