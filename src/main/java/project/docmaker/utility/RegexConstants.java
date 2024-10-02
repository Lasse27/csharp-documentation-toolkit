package project.docmaker.utility;


import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NonNls;
import project.docmaker.utility.mlogger.ConstantInterface;

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
	 * The language code for the {@link Language} annotation of regular expressions.
	 */
	@NonNls String REG_EXP = "RegExp";


	/**
	 *
	 */
	@Language (REG_EXP)
	String SUMMARY_REGEX = "<summary>([\\s\\S]*?)</summary>";

	/**
	 *
	 */
	Pattern SUMMARY_PATTERN = Pattern.compile(SUMMARY_REGEX);

	/**
	 *
	 */
	@Language (REG_EXP)
	String RETURN_REGEX = "<returns>([\\s\\S]*?)</returns>";

	/**
	 *
	 */
	Pattern RETURN_PATTERN = Pattern.compile(RETURN_REGEX);

	/**
	 *
	 */
	@Language (REG_EXP)
	String REGEX_CS_SECTION = "(?<DOCUMENTATION>\\t*///[\\w\\W]+?)" +
	                          "(?<ANNOTATION>\\[[\\w\\W]*])*[\\r\\n]*" +
	                          "(?<KEYWORDS>(?:public\\s+|private\\s+|static\\s+|readonly\\s+|protected\\s+|override\\s+|struct\\s+|class\\s+|interface\\s+)+)" +
	                          "(?<DESCRIPTION>.*?)(?==|\\{|\\W*?\\{|;)";

	/**
	 *
	 */
	Pattern CS_SECTION_PATTERN = Pattern.compile(REGEX_CS_SECTION);
}

