using System.Collections.Generic;
using System.Linq;

using ProntoTool.Control.Translation;


namespace ProntoTool.Model.Translator
{
	/// <summary>
	///     Die TContainer-Klasse stellt ein Tabellencontainer dar, der zur Bearbeitung von Daten aus der Übersetzungstabelle
	///     dient
	///     und aus Strings besteht. Der erste Wert des Tabellencontainers ist der Primärschlüsel der Tabellenzeile und die
	///     anderen beiden Werte
	///     sind beliebige Zellen aus der selben Zeile.
	/// </summary>
	public class TranslationContainer
	{
		//-------------------------------------------------------------------------------------------------------------------
		public string PrimaryValue { get; }


		public string SecondaryValue { get; }


		public string TranslatedValue { get; set; }



		//-------------------------------------------------------------------------------------------------------------------
		/// <summary> Instanziiert einen neuen TContainer mit drei Strings. </summary>
		/// <param name="primaryValue">	   Der Primärschlüssel des TContainers. </param>
		/// <param name="originalValue">   Der zweite Wert des TContainers		</param>
		/// <param name="translatedValue"> Der dritte Wert des TContainers		</param>
		public TranslationContainer (string primaryValue, string originalValue, string translatedValue)
		{
			this.PrimaryValue = primaryValue;
			this.SecondaryValue = originalValue;
			this.TranslatedValue = translatedValue;
		}



		public TranslationContainer (string[] values)
		{
			this.PrimaryValue = values[0];
			this.SecondaryValue = values[1];
			this.TranslatedValue = values.Length > 2 ? values[2] : "";
		}



		public bool ContainsFormatErrors ()
		{
			List<string> formatsKey = TranslationController.GetFormats(this.SecondaryValue);
			List<string> formatsVal = TranslationController.GetFormats(this.TranslatedValue);

			return FormatIsInvalid(formatsKey, formatsVal);
		}



		/// <summary> Gibt eine Zeichenfolge zurück, die das Objekt repräsentiert. </summary>
		/// <returns> Einen String, der das Objekt und seine Attribute darstellt.  </returns>
		public override string ToString ()
		{
			return this.PrimaryValue + "; " + this.SecondaryValue + "; " + this.TranslatedValue;
		}



		private static bool FormatIsInvalid (List<string> formatsOrigin, List<string> formatsTrans)
		{
			bool res = formatsOrigin.Count != formatsTrans.Count || formatsOrigin.Where((t, n) => !t.Equals(formatsTrans[n])).Any();
			return res;
		}
	}
}