package project.docmaker.model;


public class DocumentationTag
{

	private final TagContentType contentType;

	private final String content;


	public DocumentationTag (final TagContentType contentType, final String content)
	{
		this.contentType = contentType;
		this.content = content;
	}


	public enum TagContentType
	{
		SUMMARY(new Regex("")),

		REMARKS(new Regex("")),

		RETURNS(new Regex("")),

		PARAM(new Regex("")),

		EXCEPTION(new Regex("")),

		PARA(new Regex("")),

		LIST(new Regex("")),

		CODE_INLINE(new Regex("")),

		CODE(new Regex("")),

		EXAMPLE(new Regex(""));


		private final Regex regex;


		TagContentType (final Regex regex)
		{
			this.regex = regex;
		}


		public Regex getRegex ()
		{
			return this.regex;
		}

	}

}
