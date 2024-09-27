using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace ProntoTool.Model.Translator
{
	/// <summary> Factory class used to validate and create TranslationJob instances. </summary>
	internal static class TranslationJobFactory
	{

		/// <summary> An array representing all the extensions an sqlite database can have. </summary>
		private static string[] SupportedFileExtensions { get; } = { ".sqlite", ".sqlite3", ".db", " .db3", ".s3db", ".sl3" };


		/// <summary> A dictionary representing all the source language codes supported by DeepL.</summary>
		/// https://developers.deepl.com/docs/resources/supported-languages
		private static Dictionary<string, string> SupportedSourceLanguageCodes { get; } = Program.Config.SupportedTranslationSourceLanguages;


		/// <summary> A dictionary representing all the target language codes supported by DeepL.</summary>
		/// https://developers.deepl.com/docs/resources/supported-languages
		private static Dictionary<string, string> SupportedTargetLanguageCodes { get; } = Program.Config.SupportedTranslationTargetLanguages;


		/// <summary> Creates a new job instance of Translation job class. </summary>
		internal static TranslationJob CreateJob (string sourceDB, string glossaryDB, string tableName, string sourceCode, string targetCode)
		{
			ValidateJobParameters(sourceDB, glossaryDB, tableName, sourceCode, targetCode);
			return new TranslationJob(sourceDatabase: new FileInfo(sourceDB),
									  glossaryDatabase: new FileInfo(glossaryDB),
									  tableName: tableName,
									  sourceLanguage: new TranslationLanguage(sourceCode, SupportedSourceLanguageCodes[sourceCode]),
									  targetLanguage: new TranslationLanguage(targetCode, SupportedTargetLanguageCodes[targetCode]));
		}


		/// <summary> Validates all the necessary parameters, so that the instance is ensured to be usable. </summary>
		private static void ValidateJobParameters (string sourceDB, string glossaryDB, string tableName, string sourceCode, string targetCode)
		{
			// Validating the source database
			FileInfo sourceDatabase = new FileInfo(sourceDB);
			if (!sourceDatabase.Exists || !SupportedFileExtensions.Contains(sourceDatabase.Extension))
			{
				throw new TranslationJobFactoryException(nameof(sourceDB));
			}

			// Validating the glossary database
			FileInfo glossaryDatabase = new FileInfo(glossaryDB);
			if (!glossaryDatabase.Exists || !SupportedFileExtensions.Contains(glossaryDatabase.Extension))
			{
				throw new TranslationJobFactoryException(nameof(glossaryDB));
			}

			// Validating the tableName
			if (string.IsNullOrWhiteSpace(tableName))
			{
				throw new TranslationJobFactoryException(nameof(tableName));
			}

			// Validating the source code
			if (string.IsNullOrWhiteSpace(sourceCode) || !SupportedSourceLanguageCodes.Keys.Contains(sourceCode))
			{
				throw new TranslationJobFactoryException(nameof(sourceCode));
			}

			// Validating the target code
			if (string.IsNullOrWhiteSpace(targetCode) || !SupportedTargetLanguageCodes.Keys.Contains(targetCode))
			{
				throw new TranslationJobFactoryException(nameof(targetCode));
			}
		}
	}


	/// <summary> Interal class that represents an exeception which occured in the TranslationJobFactory. </summary>
	internal class TranslationJobFactoryException : Exception
	{
		private new const string Message = "Fehler bei der Erstellung des Jobs aufgetreten. Verantwortlicher Parameter: {0}";

		public TranslationJobFactoryException (string message) : base(string.Format(Message, message)) { }
	}
}
