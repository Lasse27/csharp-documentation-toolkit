package project.docmaker.utility.constant;

import project.docmaker.model.Token;
import project.docmaker.utility.annotation.ConstantInterface;

@ConstantInterface
public interface TokenConstants
{
	Token PRIVATE = new Token("private");


	Token PUBLIC = new Token("public");


	Token PROTECTED = new Token("protected");


	Token STATIC = new Token("static");


	Token CONST = new Token("const");


	Token INTERNAL = new Token("internal");


	Token ClASS = new Token("class");


	Token INTERFACE = new Token("interface");


	Token RECORD = new Token("record");


	Token SUMMARY_START = new Token("<summary>");


	Token SUMMARY_END = new Token("</summary>");
}
