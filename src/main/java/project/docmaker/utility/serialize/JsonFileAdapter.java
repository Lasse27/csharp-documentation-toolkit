package project.docmaker.utility.serialize;


import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

import static project.docmaker.utility.stringutils.StringController.EMPTY_STRING;


public class JsonFileAdapter extends TypeAdapter<JsonFile>
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void write (final @NotNull JsonWriter jsonWriter, final @NotNull JsonFile value) throws IOException
	{
		jsonWriter.beginObject();
		jsonWriter.name("filepath");
		jsonWriter.value(value.getPath());
		jsonWriter.endObject();
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public JsonFile read (final @NotNull JsonReader jsonReader) throws IOException
	{
		jsonReader.beginObject();
		String tokenName = EMPTY_STRING;
		String filePath = EMPTY_STRING;
		while (jsonReader.hasNext())
		{
			final JsonToken token = jsonReader.peek();

			if (token == JsonToken.NAME)
			{
				tokenName = jsonReader.nextName();
			}

			if (tokenName.equals("filepath"))
			{
				filePath = jsonReader.nextString();
			}
		}
		jsonReader.endObject();

		return new JsonFile(filePath);
	}
}
