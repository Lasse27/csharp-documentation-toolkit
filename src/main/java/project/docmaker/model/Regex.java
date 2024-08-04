package project.docmaker.model;


import java.util.regex.Pattern;

@NoLogger
public class Regex
{

	private final Pattern pattern;



	public Regex (final String patternString)
	{
		this.pattern = Pattern.compile(patternString, Pattern.MULTILINE);
	}



	public Pattern getPattern ()
	{
		return this.pattern;
	}

}
