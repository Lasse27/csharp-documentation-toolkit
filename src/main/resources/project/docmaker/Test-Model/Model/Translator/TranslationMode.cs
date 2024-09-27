namespace ProntoTool.Control.Translation
{
	/// <summary> The enum TranslationMode represents the different methods that can be used to translate a text with the DeepL API. </summary>
	public enum TranslationMode
	{
		/// <summary> The standard translation mode translates the text as a full sentence. </summary>
		Standard,

		/// <summary> The by word translation mode translates word by word ignoring all sentence sense. </summary>
		ByWord
	}
}
