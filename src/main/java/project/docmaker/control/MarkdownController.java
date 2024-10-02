package project.docmaker.control;


import project.docmaker.model.structure.Section;
import project.docmaker.utility.mlogger.MLogger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 */
public final class MarkdownController
{
	/**
	 * Private constructor since controller class isn't supposed to be initialized ever.
	 */
	private MarkdownController ()
	{
	}



	/**
	 * @param targetFile
	 * @param sections
	 */
	public static void createMarkdownFile (final File targetFile, final Iterable<Section> sections)
	{
		try (final FileWriter fileWriter = new FileWriter(targetFile))
		{
			for (final Section section : sections)
			{
				fileWriter.append(section.toMarkdown());
			}
		}
		catch (final IOException ex)
		{
			MLogger.logEx(ex);
		}
	}
}
