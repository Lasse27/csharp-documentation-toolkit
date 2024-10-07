package project.docmaker.utility.serialize;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.jetbrains.annotations.NotNull;
import project.docmaker.model.generation.GenerationJob;
import project.docmaker.utility.mlogger.MLogger;

import java.io.*;
import java.text.MessageFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 *
 */
public final class Configuration
{
	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link Configuration#toString()} method gets called
	 */
	private static final String TEXT_DISPLAY_PATTERN = "{0} @ {1} [finishedJobs={2}, lastSourceUsed={3}, lastTargetUsed={4}]";


	/**
	 * {@link GsonBuilder} instance responsible for building {@link Gson} instances to load and store data from JSON files.
	 */
	private static final GsonBuilder GSON_BUILDER = new GsonBuilder().setPrettyPrinting().serializeNulls()
		                                                /*  --> Register needed adapters here <--  */.registerTypeAdapter(Instant.class, new InstantAdapter())
		                                                .registerTypeAdapter(JsonFile.class, new JsonFileAdapter());


	/* -----------------------------------------------
	 * --> Put necessary configuration fields here <--
	 * ----------------------------------------------- */


	/**
	 *
	 */
	private final List<GenerationJob> finishedGenerationJobs = new ArrayList<>();


	private JsonFile lastSourceUsed = new JsonFile("");


	private JsonFile lastTargetUsed = new JsonFile("");



	/**
	 * @param file
	 *
	 * @return
	 *
	 * @throws FileNotFoundException
	 */
	public static Configuration fromJsonFile (final File file) throws FileNotFoundException
	{
		// Create a Gson object to read the JSON file.
		final Gson gson = GSON_BUILDER.create();
		final JsonReader jsonReader = new JsonReader(new FileReader(file));

		// Get the Configuration instance from the JSON file.
		final Configuration output = gson.fromJson(jsonReader, Configuration.class);

		// Logging and returning the output.
		MLogger.logLnf("Configuration found and read: {0}", output);
		return output;
	}



	public static void toJsonFile (final Configuration configuration, final File file) throws IOException
	{
		try (final FileWriter writer = new FileWriter(file))
		{
			final Gson gson = GSON_BUILDER.create();
			writer.write(gson.toJson(configuration));
		}
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public @NotNull String toString ()
	{
		return MessageFormat.format(TEXT_DISPLAY_PATTERN, this.getClass()
			                                                  .getSimpleName(), Integer.toHexString(this.hashCode()), this.finishedGenerationJobs, this.lastSourceUsed,
			this.lastTargetUsed);
	}



	public Collection<GenerationJob> getFinishedJobs ()
	{
		return this.finishedGenerationJobs;
	}



	public void setLastSourceFolder (final String value)
	{
		this.lastSourceUsed = new JsonFile(value);
	}



	public void setlastTargetFolder (final String value)
	{
		this.lastTargetUsed = new JsonFile(value);
	}



	public String getLastSourceFolder ()
	{
		return this.lastSourceUsed.getAbsolutePath();
	}



	public String getLastTargetFolder ()
	{
		return this.lastTargetUsed.getAbsolutePath();
	}



	public void addFinishedJob (final GenerationJob generationJob)
	{
		this.finishedGenerationJobs.add(generationJob);
	}
}
