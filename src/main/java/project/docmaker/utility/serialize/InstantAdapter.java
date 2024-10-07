package project.docmaker.utility.serialize;


import com.google.gson.*;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class InstantAdapter implements JsonSerializer<Instant>, JsonDeserializer<Instant>
{

	private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;



	/**
	 * {@inheritDoc}
	 */
	@Override
	public JsonElement serialize (final @NotNull Instant instant, final Type type, final JsonSerializationContext jsonSerializationContext)
	{
		return new JsonPrimitive(instant.toString()); // "yyyy-MM-dd"
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Instant deserialize (final @NotNull JsonElement jsonElement, final Type type, final JsonDeserializationContext jsonDeserializationContext)
	{
		return Instant.parse(jsonElement.getAsString());
	}

}
