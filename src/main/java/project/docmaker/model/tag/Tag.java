package project.docmaker.model.tag;

import project.docmaker.utility.annotation.NoLogger;

@NoLogger
public interface Tag
{
	TagType getType ();



	TagContent getContent ();



	@Override
	public String toString ();

}
