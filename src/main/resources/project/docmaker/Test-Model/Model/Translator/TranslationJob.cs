using System.IO;

namespace ProntoTool.Model.Translator
{
	/// <summary> The TranslationJob represents one Translation operation and can be executed with the TranslationExecutor. </summary>
	internal class TranslationJob
	{

		/// <summary> The file path of the source database, which contains the containers and is meant to be updated. </summary>
		internal FileInfo SourceDatabase { get; }


		/// <summary> The file path of the glossary database, which contains the glossary entries used in the translation. </summary>
		internal FileInfo GlossaryDatabase { get; }


		/// <summary> The name of the table within the source database. </summary>
		internal string DatabaseTableName { get; }


		/// <summary> The source language of the translation. </summary>
		internal TranslationLanguage SourceLanguage { get; }


		/// <summary> The target language of the translation. </summary>
		internal TranslationLanguage TargetLanguage { get; }



		/// <summary> Standard constructor of the class, initializes a new instance with all the necessary fields. </summary>
		/// <param name="sourceDatabase"> The file path of the source database, which contains the containers and is meant to be updated. </param>
		/// <param name="glossaryDatabase"> The file path of the glossary database, which contains the glossary entries used in the translation. </param>
		/// <param name="tableName"> The name of the table within the source database. </param>
		/// <param name="sourceLanguage"> The source language of the translation. </param>
		/// <param name="targetLanguage"> The target language of the translation. </param>
		internal TranslationJob (FileInfo sourceDatabase, FileInfo glossaryDatabase, string tableName, TranslationLanguage sourceLanguage, TranslationLanguage targetLanguage)
		{
			this.SourceDatabase = sourceDatabase;
			this.GlossaryDatabase = glossaryDatabase;
			this.DatabaseTableName = tableName;
			this.SourceLanguage = sourceLanguage;
			this.TargetLanguage = targetLanguage;
		}
	}
}