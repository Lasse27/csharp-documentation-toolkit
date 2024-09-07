package project.docmaker.model.structure.section.implementation;

import project.docmaker.model.NoLogger;
import project.docmaker.model.structure.Body;
import project.docmaker.model.structure.Footer;
import project.docmaker.model.structure.Header;
import project.docmaker.model.structure.section.Section;

@NoLogger
public class FieldSection extends Section
{

	protected FieldSection (final Header header, final Body body, final Footer footer)
	{
		super(header, body, footer);
	}

}
