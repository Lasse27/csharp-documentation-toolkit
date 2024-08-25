package project.docmaker.model.section;

import project.docmaker.model.NoLogger;

@NoLogger
public class MethodSection extends Section
{

	protected MethodSection (final Header header, final Description description)
	{
		super(header, description);
	}
}
