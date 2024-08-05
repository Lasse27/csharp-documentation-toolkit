package project.docmaker.utility.constant;

import project.docmaker.model.Regex;

public interface RegexConstants
{
	String PUBLIC_CLASS_PATTERN = "(/// *<summary>.*?)(?=\\s*(public|private)\\s+class\\s+\\w+)";

	/**
	 * A {@link Regex} object, which can be used to collect the {@link String} of the class area from a file.
	 */
	Regex PUBLIC_CLASS_REGEX = new Regex(PUBLIC_CLASS_PATTERN);

	String CLASS_NAME_PATTERN = "class\\s+([a-zA-Z_]\\w*)";

	/**
	 * A {@link Regex} object, which can be used to collect the {@link String} of the class name from the class area.
	 */
	Regex CLASS_NAME_REGEX = new Regex(CLASS_NAME_PATTERN);
}
