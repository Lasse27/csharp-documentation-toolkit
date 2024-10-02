package project.docmaker.view;


import javafx.scene.control.TreeItem;
import org.jetbrains.annotations.NotNull;
import project.docmaker.model.generation.GenerationJob;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public final class GenerationJobTreeItem extends TreeItem<String>
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


	private final Instant date;



	public GenerationJobTreeItem (final @NotNull GenerationJob generationJob)
	{
		this.date = generationJob.instant();
		this.getChildren().add(new TreeItem<>(generationJob.targetFile().toString()));
		this.getChildren().add(new TreeItem<>(generationJob.sourceFile().toString()));
	}



	@Override
	public @NotNull String toString ()
	{
		return "GenerationJob" + FORMATTER.format(this.date);
	}
}
