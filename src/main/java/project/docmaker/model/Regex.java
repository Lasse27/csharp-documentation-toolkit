package project.docmaker.model;


import java.util.regex.Pattern;


public class Regex
{

	private final Pattern pattern;



	public Regex (final String patternString)
	{
		this.pattern = Pattern.compile(patternString);
	}



	public Pattern getPattern ()
	{
		return this.pattern;
	}

}
