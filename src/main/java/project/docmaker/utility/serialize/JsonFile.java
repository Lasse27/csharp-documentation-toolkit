package project.docmaker.utility.serialize;


import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.net.URI;
import java.nio.file.Paths;
import java.text.MessageFormat;


/**
 * {@inheritDoc}
 */
public class JsonFile extends File
{
	private final String path;



	/**
	 * {@inheritDoc}
	 */
	public JsonFile (@NotNull final String pathname)
	{
		super(pathname);
		this.path = Paths.get(pathname).toAbsolutePath().toString();
	}



	/**
	 * {@inheritDoc}
	 */
	public JsonFile (final String parent, @NotNull final String child)
	{
		super(parent, child);
		this.path = Paths.get(parent, child).toAbsolutePath().toString();
	}



	/**
	 * {@inheritDoc}
	 */
	public JsonFile (final File parent, @NotNull final String child)
	{
		super(parent, child);
		this.path = Paths.get(parent.getPath(), child).toAbsolutePath().toString();
	}



	/**
	 * {@inheritDoc}
	 */
	public JsonFile (@NotNull final URI uri)
	{
		super(uri);
		this.path = uri.getRawPath();
	}



	@Override
	public String toString ()
	{
		return MessageFormat.format("JsonFile [path={0}, super={1}]", this.path, super.toString());
	}
}
