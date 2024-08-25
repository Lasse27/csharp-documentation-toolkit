package project.docmaker.model.section.implementation;

import project.docmaker.model.NoLogger;
import project.docmaker.model.section.Header;
import project.docmaker.model.section.Section;

@NoLogger
public class MethodSection extends Section
{

	protected MethodSection (final Header header, final Description description)
	{
		super(header, description);
	}
}
