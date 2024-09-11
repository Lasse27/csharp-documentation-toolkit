package project.docmaker.control;

import project.docmaker.model.section.Section;
import project.docmaker.utility.constant.MiscConstants;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MarkdownController
{
	private MarkdownController ()
	{
	}



	public static void createMarkdownFile (final File targetFile, final Iterable<Section> sections)
	{
		try (final FileWriter fileWriter = new FileWriter(targetFile))
		{
			for (final Section section : sections)
			{
				fileWriter.append(section.metaData().header().toMarkdown());
				fileWriter.append(MiscConstants.NEW_LINE);
				fileWriter.append(section.metaData().body().toMarkdown());
				fileWriter.append(section.metaData().footer().toMarkdown());
				fileWriter.append(MiscConstants.NEW_LINE).append("---").append(MiscConstants.NEW_LINE);
			}
		}
		catch (final IOException ex)
		{
			throw new RuntimeException(ex);
		}
	}
}
