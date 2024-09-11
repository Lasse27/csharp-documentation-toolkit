package project.docmaker.control;

import project.docmaker.model.structure.Section;
import project.docmaker.model.structure.Header;
import project.docmaker.utility.MiscConstants;

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
				if (section.header() == Header.EMPTY)
				{
					continue;
				}
				fileWriter.append(section.header().toMarkdown());
				fileWriter.append(MiscConstants.NEW_LINE);
				fileWriter.append(section.body().toMarkdown());
				fileWriter.append(section.codeSnippet().toMarkdown());
				fileWriter.append(MiscConstants.NEW_LINE).append("---").append(MiscConstants.NEW_LINE);
			}
		}
		catch (final IOException ex)
		{
			throw new RuntimeException(ex);
		}
	}
}
