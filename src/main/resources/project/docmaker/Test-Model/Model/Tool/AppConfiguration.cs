using System.Collections.Generic;
using System.Diagnostics;

using ProntoTool.Model.Installation;

namespace ProntoTool.Model.Tool
{
	/// <summary> The Configuration of the program used to personalize each started program process </summary>
	[DebuggerDisplay("{" + nameof(GetDebuggerDisplay) + "(),nq}")]
	public class AppConfiguration
	{
		/********************************************************************* 
		 * Settings 
		 *********************************************************************/

		public int CheckListBox_MaxItems { get; set; }


		/********************************************************************* 
		 * Supported Translation Languages
		 *********************************************************************/

		/// <summary> A dictionary representing all the source language codes supported by DeepL.</summary>
		/// https://developers.deepl.com/docs/resources/supported-languages
		public Dictionary<string, string> SupportedTranslationSourceLanguages { get; set; }


		/// <summary> A dictionary representing all the target language codes supported by DeepL.</summary>
		/// https://developers.deepl.com/docs/resources/supported-languages
		public Dictionary<string, string> SupportedTranslationTargetLanguages { get; set; }


		/********************************************************************* 
		 * Installation scripts
		 *********************************************************************/

		public List<InstallationPattern> InstallationPatterns { get; set; }


		/********************************************************************** 
		 * Combobox-Entries 
		 *********************************************************************/

		public IEnumerable<string> CheckBoxItems_UpdateFolder { get; set; }


		public IEnumerable<string> CheckBoxItems_WorkstationFolder { get; set; }


		public IEnumerable<string> CheckBoxItems_ScriptFolder { get; set; }


		public IEnumerable<string> CheckBoxItems_TranslationDB { get; set; }


		public IEnumerable<string> CheckBoxItems_GlossaryDB { get; set; }


		public IEnumerable<string> CheckBoxItems_TableName { get; set; }


		public IEnumerable<string> CheckBoxItems_DBTransferSource { get; set; }


		public IEnumerable<string> CheckBoxItems_DBTransferTarget { get; set; }



		/********************************************************************** 
		 * Built-In
		 *********************************************************************/

		public override bool Equals (object obj) => base.Equals(obj);


		public override int GetHashCode () => base.GetHashCode();


		public override string ToString () => base.ToString();


		private string GetDebuggerDisplay () => this.ToString();
	}
}
