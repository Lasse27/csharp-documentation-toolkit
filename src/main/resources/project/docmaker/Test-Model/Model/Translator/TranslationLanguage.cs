namespace ProntoTool.Model.Translator
{
	/// <summary> The TranslationLanguage class represents a Language that can be used in the DeepL translator. </summary>
	public class TranslationLanguage
	{

		/// <summary> The ISO language code of the TranslationLanguage. </summary>
		public string Code { get; }


		/// <summary> The column identifier of the TranslationLanguage. </summary>
		public string Identifier { get; }


		/// <summary> Standard constructor of the class, initializes a new instance with all the necessary fields. </summary>
		/// <param name="code"> The ISO language code of the TranslationLanguage. </param>
		/// <param name="identifier"> The column identifier of the TranslationLanguage. </param>
		public TranslationLanguage (string code, string identifier)
		{
			this.Code = code;
			this.Identifier = identifier;
		}
	}
}