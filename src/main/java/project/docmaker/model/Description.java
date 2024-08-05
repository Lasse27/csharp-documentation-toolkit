package project.docmaker.model;

import java.text.MessageFormat;

@NoLogger
public class Description
{
	private final Class<? extends Section> sectionClass;

	private final String descriptionText;



	public Description (final Class<? extends Section> sectionClass, final String descriptionText)
	{
		this.sectionClass = sectionClass;
		this.descriptionText = descriptionText;
	}



	public Class<? extends Section> getSectionClass ()
	{
		return this.sectionClass;
	}



	public String getDescriptionText ()
	{
		return this.descriptionText;
	}



	@Override
	public String toString ()
	{
		return MessageFormat.format("Description'{'sectionClass={0}, descriptionText=''{1}'''}'", this.sectionClass.getSimpleName(), this.descriptionText);
	}
}
