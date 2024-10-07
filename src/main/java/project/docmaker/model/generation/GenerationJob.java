package project.docmaker.model.generation;


import org.jetbrains.annotations.NotNull;
import project.docmaker.utility.serialize.JsonFile;

import java.io.File;
import java.text.MessageFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public record GenerationJob(Instant instant, JsonFile sourceFile, JsonFile targetFile)
{

	/**
	 * {@link String} constant representing the format of the displayed timestamp.
	 */
	@NotNull
	private static final String TIME = "dd.MM.yyyy HH:mm";


	/**
	 * {@link DateTimeFormatter} constant representing the DateTimeFormatter used to format the timestamp.
	 */
	@NotNull
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(TIME, Locale.GERMANY).withZone(ZoneId.systemDefault());



	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state.
	 *
	 * @return A formatted {@link String} which represents the object in its current state.
	 */
	@Override
	public @NotNull String toString ()
	{
		return MessageFormat.format("GenerationJob [{0}]", FORMATTER.format(this.instant));
	}
}
