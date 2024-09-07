package project.docmaker.model;

import project.docmaker.utility.annotation.NoLogger;
import project.docmaker.utility.logging.ILogger;
import project.docmaker.utility.logging.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@NoLogger
public class FileContent
{
	/**
	 * A {@link Logger} object, which is being used to write formatted outputs into the console.
	 */
	private static final ILogger LOGGER = new Logger(FileContent.class.getSimpleName());

	/**
	 * A {@link File} object, which represents the origin of the {@code FileContent} instance.
	 */
	private final File file;

	/**
	 * An array of bytes, which represents the content of the {@code FileContent} instance.
	 */
	private String content;



	public FileContent (final File file)
	{
		this.file = file;
		this.content = "";
		try
		{
			this.content = new String(Files.readAllBytes(file.toPath()));
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}
	}



	public String getAsString ()
	{
		return this.content;
	}



	public char[] getAsCharArray ()
	{
		return this.content.toCharArray();
	}



	/**
	 * Getter-Method for the {@link File} attribute of the instance.
	 *
	 * @return A {@link File} representing the {@link File} attribute of the instance
	 **/
	public File getFile ()
	{
		return this.file;
	}
}
