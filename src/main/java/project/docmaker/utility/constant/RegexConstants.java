package project.docmaker.utility.constant;

import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NonNls;
import project.docmaker.model.Regex;
import project.docmaker.model.structure.Snippet;
import project.docmaker.utility.annotation.ConstantInterface;

import java.util.regex.Pattern;

/**
 * The {@code RegexConstants} class contains certain patterns and {@link Regex} objects, which can be used to analyze C#-Code files.
 *
 * @author Lasse-Leander Hillen
 * @since 02.09.2024
 */
@ConstantInterface
public interface RegexConstants
{

	/**
	 * The language code for the @Language annotation and regex.
	 */
	@NonNls
	String REG_EXP = "RegExp";

	/**
	 * A {@link String} pattern, which can be used to collect the {@link String} of the class area from a file.
	 */
	@Language (REG_EXP)
	String CLASS_WITH_DOC = "(///)(.|\\R)*?(public|private|protected|internal|sealed|abstract|partial)?\\s*(static)?\\s*" +
	                        "(class|record|struct|interface)\\s+(\\S*)\\s*:*\\s*(.*?)\\s*(?=\\{)";

	/**
	 * A {@link Regex} object, which can be used to collect the {@link String} of the class area from a file.
	 */
	Pattern CLASS_WITH_DOC_PATTERN = Pattern.compile(CLASS_WITH_DOC, Pattern.MULTILINE);


	/**
	 * A {@link String} pattern, which can be used to collect the {@link Snippet} of the class.
	 */
	@Language (REG_EXP)
	String CLASS_WITHOUT_DOC =
			"(public|private|protected|internal|sealed|abstract|partial)?\\s*(static)?\\s*(class|record|struct|interface)\\s+(\\S*)\\s*:*\\s*" +
			"(.*?)\\s*(?=\\{)";

	/**
	 * A {@link Regex} object, which can be used to collect the {@link Snippet} of the class.
	 */
	Pattern CLASS_WITHOUT_DOC_REGEX = Pattern.compile(CLASS_WITHOUT_DOC, Pattern.MULTILINE);


	/**
	 * A {@link String} pattern, which can be used to collect the {@link Snippet} of the class.
	 */
	@Language (REG_EXP)
	String CLASS_DESCRIPTION_PATTERN = "<summary>([\\s\\S]*?)</summary>";


	/**
	 * A {@link Regex} object, which can be used to collect the {@link Snippet} of the class.
	 */
	Regex CLASS_DESCRIPTION_REGEX = new Regex(CLASS_DESCRIPTION_PATTERN);
}

// (\/\/\/*)(.*)(?=(public|private|protected|internal|sealed|abstract|partial)\s+(class|record|struct|interface))(.*)\{