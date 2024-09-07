package project.docmaker.control;

import project.docmaker.model.FileContent;
import project.docmaker.model.structure.Body;
import project.docmaker.model.structure.Footer;
import project.docmaker.model.structure.Header;
import project.docmaker.model.structure.section.Section;
import project.docmaker.model.structure.section.implementation.ClassSection;
import project.docmaker.model.structure.section.implementation.ClassSectionBuilder;
import project.docmaker.model.structure.section.implementation.FieldSection;
import project.docmaker.model.structure.section.implementation.MethodSection;
import project.docmaker.utility.logging.ILogger;
import project.docmaker.utility.logging.Logger;

/**
 * The {@code SectionFactory} class is used to create instance of the {@link Section} class and its subtypes
 *
 * @author Lasse-Leander Hillen
 * @since 02.09.2024
 */
public final class SectionFactory
{

	/**
	 * A {@link Logger} object, which is being used to write formatted outputs into the console.
	 */
	private static final ILogger LOGGER = new Logger(SectionFactory.class.getSimpleName());



	/**
	 * Private constructor since controller class isn't supposed to be initialized ever.
	 */
	private SectionFactory ()
	{
	}



	/**
	 * Factory method for the {@link ClassSection}-Class
	 *
	 * @param header The header of the new {@code ClassSection} instance.
	 * @param body   The body of the new {@code ClassSection} instance.
	 * @param footer The footer of the new {@code ClassSection} instance.
	 *
	 * @return A new instance of the {@code ClassSection} class.
	 */
	public static ClassSection CreateClassSection (final Header header, final Body body, final Footer footer)
	{
		final ClassSection classSection = new ClassSectionBuilder().setHeader(header).setBody(body).setFooter(footer).createClassSection();

		LOGGER.log(ILogger.Level.DEBUG, classSection.toString());
		return classSection;
	}



	/**
	 * Factory method for the {@link ClassSection}-Class
	 *
	 * @param fileContent The {@link FileContent} instance the class section will be based on.
	 *
	 * @return A new instance of the {@code ClassSection} class.
	 */
	public static ClassSection CreateClassSection (final FileContent fileContent)
	{
		final Header header = FileContentController.GetClassHeader(fileContent);
		final Body body = FileContentController.GetClassBody(fileContent);
		final Footer footer = FileContentController.GetClassFooter(fileContent);
		return CreateClassSection(header, body, footer);
	}



	public static MethodSection CreateMethodSection ()
	{
		return null; // TODO:
	}



	public static FieldSection CreateFieldSection ()
	{
		return null; // TODO:
	}
}
