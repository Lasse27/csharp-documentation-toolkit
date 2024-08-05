package project.docmaker.model;

@NoLogger
public class DocumentationTag
{
	public static final DocumentationTag EMPTY = new DocumentationTag(TagContentType.EMPTY, null);

	private final TagContentType contentType;

	private final TagContent content;



	public DocumentationTag (final TagContentType contentType, final TagContent content)
	{
		this.contentType = contentType;
		this.content = content;
	}



	@NoLogger
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

		EXAMPLE(new Regex("")),
		EMPTY(new Regex(""));


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
