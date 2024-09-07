package project.docmaker.model.tag;

import project.docmaker.model.NoLogger;

@NoLogger
public interface Tag
{
	TagType getType ();



	TagContent getContent ();



	@Override
	public String toString ();

}
