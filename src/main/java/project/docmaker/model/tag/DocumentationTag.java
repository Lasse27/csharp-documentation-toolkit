package project.docmaker.model.tag;

import project.docmaker.model.NoLogger;

@NoLogger
public interface DocumentationTag<V>
{
	TagContentType getContentType ();



	V getTagContent ();



	@Override
	public String toString ();

}
