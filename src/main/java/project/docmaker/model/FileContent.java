package project.docmaker.model;

import project.docmaker.utility.logging.ILogger;
import project.docmaker.utility.logging.Logger;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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
	private final byte[] content;



	public FileContent (final File file)
	{
		try (final BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file)))
		{
			this.file = file;
			this.content = inputStream.readAllBytes();
		}
		catch (final IOException e)
		{
			LOGGER.log(ILogger.Level.ERROR, e.getMessage());
			throw new RuntimeException();
		}
	}



	public String getAsString ()
	{
		final StringBuilder builder = new StringBuilder();
		for (final byte b : this.content)
		{
			builder.append((char) b);
		}
		return builder.toString();
	}



	public char[] getAsCharArray ()
	{
		final char[] chars = new char[this.content.length];
		for (int i = 0; i < this.content.length; i++)
		{
			chars[i] = (char) this.content[i];
		}
		return chars;
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



	/**
	 * Getter-Method for the content byte[] attribute of the instance.
	 *
	 * @return A {@link File} representing the content byte[] attribute of the instance
	 **/
	public byte[] getContent ()
	{
		return this.content;
	}
}
