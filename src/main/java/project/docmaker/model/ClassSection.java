package project.docmaker.model;


import java.util.List;

import static project.docmaker.control.FileContentController.*;


public class ClassSection extends Section
{

	private final List<FieldSection> fields;

	private final List<MethodSection> methods;


	public ClassSection (final FileContent fileContent)
	{
		super(getClassName(fileContent), getClassDescription(fileContent), getClassTags(fileContent));
		this.fields = getFieldSections();
		this.methods = getMethodSections();
	}


	public List<FieldSection> getFields ()
	{
		return this.fields;
	}


	public List<MethodSection> getMethods ()
	{
		return this.methods;
	}

}
