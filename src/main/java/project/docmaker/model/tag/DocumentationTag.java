package project.docmaker.model.tag;

import project.docmaker.model.NoLogger;

@NoLogger
public interface DocumentationTag
{
	TagContentType getContentType ();



	TagContent getTagContent ();



	@Override
	public String toString ();

}
