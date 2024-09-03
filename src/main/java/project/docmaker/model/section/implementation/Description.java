package project.docmaker.model.section.implementation;

import project.docmaker.model.NoLogger;

import java.text.MessageFormat;

@NoLogger
public class Description
{
	private final String descriptionText;



	public Description (final String descriptionText)
	{
		this.descriptionText = descriptionText;
	}



	public String getDescriptionText ()
	{
		return this.descriptionText;
	}



	@Override
	public String toString ()
	{
		return MessageFormat.format("Description'{'descriptionText=''{0}'''}'", this.descriptionText);
	}
}
