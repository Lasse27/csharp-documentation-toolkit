package project.docmaker.fxml;


import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import project.docmaker.model.generation.GenerationJob;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class JobTreeItemFactory
{
	public static TreeItem<String> createItem (final GenerationJob generationJob)
	{
		final TreeItem<String> sourcePathItem = new TreeItem<>("Quellpfad: " + generationJob.sourceFile().toString());
		final TreeItem<String> targetPathItem = new TreeItem<>("Zielpfad: " + generationJob.sourceFile().toString());
		final TreeItem<String> jobTreeItem = new TreeItem<>(generationJob.toString());
		jobTreeItem.setExpanded(true);
		jobTreeItem.getChildren().add(sourcePathItem);
		jobTreeItem.getChildren().add(targetPathItem);
		return jobTreeItem;
	}



	/**
	 * Loads an image from the supplied resourcePath.
	 *
	 * @param resourcePath The path from which the resource (the image) is loaded.
	 *
	 * @return An instance of {@link Image}.
	 *
	 * @precondition A valid resource path has to be supplied as a parameter.
	 * @postcondition the specified Image is returned; null if the resourcePath isn't valid.
	 */
	public static Image loadImage (final String resourcePath)
	{
		try
		{
			return new Image(new FileInputStream(resourcePath));
		}
		catch (final FileNotFoundException e)
		{
			return null;
		}
	}
}
