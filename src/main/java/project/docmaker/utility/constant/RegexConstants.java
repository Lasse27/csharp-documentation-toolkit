package project.docmaker.utility.constant;

import org.intellij.lang.annotations.Language;
import project.docmaker.model.NoLogger;
import project.docmaker.model.Regex;
import project.docmaker.model.structure.Snippet;

/**
 * The {@code RegexConstants} class contains certain patterns and {@link Regex} objects, which can be used to analyze C#-Code files.
 *
 * @author Lasse-Leander Hillen
 * @since 02.09.2024
 */
@NoLogger
public interface RegexConstants
{
	/**
	 * A {@link String} pattern, which can be used to collect the {@link String} of the class area from a file.
	 */
	String PUBLIC_CLASS_PATTERN = "(/// *<summary>.*?)(?=\\s*(public|private|internal)\\s+class\\s+\\w+)";

	/**
	 * A {@link Regex} object, which can be used to collect the {@link String} of the class area from a file.
	 */
	Regex PUBLIC_CLASS_REGEX = new Regex(PUBLIC_CLASS_PATTERN);

	/**
	 * A {@link String} pattern, which can be used to collect the {@link String} of the class name from the class area.
	 */
	String CLASS_NAME_PATTERN = "class\\s+([a-zA-Z_]\\w*)";

	/**
	 * A {@link Regex} object, which can be used to collect the {@link String} of the class name from the class area.
	 */
	Regex CLASS_NAME_REGEX = new Regex(CLASS_NAME_PATTERN);

	/**
	 * A {@link String} pattern, which can be used to collect the {@link Snippet} of the class.
	 */
	String CLASS_CODE_PATTERN = "(public|private|protected|internal|sealed|abstract|partial)\\s*(class|struct|interface|record)\\s+\\w+" +
	                            "(\\s*:\\s*[\\w\\s,]+)?\\s*?";

	/**
	 * A {@link Regex} object, which can be used to collect the {@link Snippet} of the class.
	 */
	Regex CLASS_CODE_REGEX = new Regex(CLASS_CODE_PATTERN);

	/**
	 * A {@link String} pattern, which can be used to collect the {@link Snippet} of the class.
	 */
	@Language ("RegExp")
	String CLASS_DESCRIPTION_PATTERN = "<summary>([\\s\\S]*?)</summary>";

	/**
	 * A {@link Regex} object, which can be used to collect the {@link Snippet} of the class.
	 */
	Regex CLASS_DESCRIPTION_REGEX = new Regex(CLASS_DESCRIPTION_PATTERN);
}
