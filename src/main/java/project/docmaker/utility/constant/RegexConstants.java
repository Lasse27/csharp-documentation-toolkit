package project.docmaker.utility.constant;

import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NonNls;
import project.docmaker.utility.annotation.ConstantInterface;

import java.util.regex.Pattern;

/**
 * The {@code RegexConstants} class contains certain String patterns and {@link Pattern} objects, which can be used to analyze C#-Code files.
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


	@Language (REG_EXP)
	String DOCUMENTATION_CODE_REGEX = "///([\\s\\S]*?)([{;}])";

	Pattern DOCUMENTATION_CODE_PATTERN = Pattern.compile(DOCUMENTATION_CODE_REGEX, Pattern.MULTILINE);


	@Language (REG_EXP)
	String DOCUMENTATION_SINGLE_LINE_REGEX = "/{3}(.*)";

	Pattern DOCUMENTATION_SINGLE_LINE_PATTERN = Pattern.compile(DOCUMENTATION_SINGLE_LINE_REGEX, Pattern.MULTILINE);


	@Language (REG_EXP)
	String CLASS_WITHOUT_DOC =
			"(public|private|protected|internal|sealed|abstract|partial)?\\s*(static)?\\s*(class|record|struct|interface)\\s+(\\S*)\\s*:*\\s*" +
			"(.*?)\\s*(?=\\{)";

	Pattern CLASS_WITHOUT_DOC_REGEX = Pattern.compile(CLASS_WITHOUT_DOC, Pattern.MULTILINE);


	@Language (REG_EXP)
	String SUMMARY_REGEX = "<summary>([\\s\\S]*?)</summary>";

	Pattern SUMMARY_PATTERN = Pattern.compile(SUMMARY_REGEX);

	@Language (REG_EXP)
	String RETURN_REGEX = "<returns>([\\s\\S]*?)</returns>";

	Pattern RETURN_PATTERN = Pattern.compile(RETURN_REGEX);
}

