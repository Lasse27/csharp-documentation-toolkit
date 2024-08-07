using System.Collections.Generic;
using System.IO;


namespace Pronto_Tool.Model.RoboCopy
{

	/// <summary>	Die <b><c>RoboCopyJob</c></b>-Klasse soll einen RoboCopy-Auftrag darstellen, der in einer Powershell-Konsole ausgeführt werden soll/kann.
	///				<br></br> Der <b><c>RoboCopyJob</c></b> bietet dabei noch keine Funktionalität und soll lediglich als Datenklasse bzw. als Modell dienen. 
	///				<br></br> Ein <b><c>RoboCopyJob</c></b> kann in Verknüpfung mit der <b><c>StartJob</c></b>-Methode aus der <b><c>RoboCopyController</c>
	///				</b>-Klasse gestartet werden. </summary>
	///				
	public class RoboCopyJob
	{

		/// <summary>	Der Quellpfad des RoboCopy-Jobs. Dies ist der Pfad, aus dem die Dateien kopiert werden (copy). </summary>
		private readonly string source;


		/// <summary>	Der Quellpfad des RoboCopy-Jobs. Dies ist der Pfad, in den die Dateien eingesetzt werden (paste). </summary>
		private readonly string destination;


		/// <summary>	Der Liste von Dateien, die definiert welche Dateien übertragen werden sollen. Wird die Liste frei gelassen, so wird das gesamte 
		///				Quellverzeichnis übertragen </summary>
		private readonly List<FileInfo> files;


		/// <summary>	Die Optionen des RoboCopy-Befehls, die als PowerShellParameter angehangen werden. Sie verändern den ablauf der Übertragung und/oder beschränken 
		///				die Übertragung indem sie besondere Bedingungen setzen. </summary>
		private readonly RoboCopyOptions options;



		/// <summary>	Hauptkonstruktor der <b><c>RoboCopyJob</c></b>-Klasse, der die genannten PowerShellParameter benötigt, um einen RoboCopy-Befehl in der Powershell-
		///				Umgebung zu generieren. <br></br> Dabei können die PowerShellParameter <b><c>files</c></b> und <b><c>options</c></b> freigelassen werden, wenn diese nicht 
		///				benötigt werden. <br></br> In diesem Falle von bewirkt dies, dass grundsätzlich alle Dateien vom Ursprung ins Ziel kopiert werden. </summary>
		///				
		/// <param name="source">		Stellt den Quellpfad bzw. den Ursprung des RoboCopy-Befehls dar, dieser legt fest, aus welchem Verzeichnis kopiert wird. </param>
		/// <param name="destination">	Stellt den Zielpfad bzw. das Ziel des RoboCopy-Befehls dar, dieser legt fest, in welches Verzeichnis kopiert wird. </param>
		/// <param name="files">		Stellt eine Liste von Dateien dar, die definiert werden kann, wenn nur bestimmte Dateien kopiert werden sollen. </param>
		/// <param name="options">		Stellt die Optionen des RoboCopy-Befehls dar, dazu gehören alle PowerShellParameter, die die Übertragung beeinflussen können. </param>
		public RoboCopyJob(string source, string destination, List<FileInfo> files, RoboCopyOptions options)
		{
			this.source = source;
			this.destination = destination;
			this.files = files;
			this.options = options;
		}



		/// <summary>	Diese Methode spiegelt eine Getter-Funktion für den Quellpfad des RoboCopy-Befehls wieder. Dieser definiert den Ursprungsort des Kopiervorgangs, 
		///				also von wo die Daten kopiert werden sollen. </summary>
		///				
		/// <returns>	Gibt einen <b><c>String</c></b> zurück, der den Systempfad zum Ursprungsort des Kopiervorgangs beschreibt. </returns>
		public string GetSource()
		{
			return this.source;
		}



		/// <summary>	Diese Methode spiegelt eine Getter-Funktion für den Zielpfad des RoboCopy-Befehls wieder. Dieser definiert den Zielort des Kopiervorgangs, 
		///				also wo die Daten hin kopiert werden sollen. </summary>
		///				
		/// <returns>	Gibt einen <b><c>String</c></b> zurück, der den Systempfad zum Zielort des Kopiervorgangs beschreibt. </returns>
		public string GetDestination()
		{
			return this.destination;
		}



		/// <summary>	Diese Methode spiegelt eine Getter-Funktion für die Dateien des RoboCopy-Befehls wieder. Diese definieren die Dateinamen der übertragenen 
		///				Dateien des Befehls.</summary>
		///				
		/// <returns>	Gibt eine <b><c>List</c></b> zurück, in der alle Dateinamen des Kopiervorgangs beschrieben werden. </returns>
		public List<FileInfo> GetFiles()
		{
			return this.files;
		}



		/// <summary>	Diese Methode speigelt eine Getter-Funktion für die Optionen des RoboCopy-Jobs wieder. Es sind die PowerShellParameter, die definieren, unter welchen 
		///				Bedingung ein/e Datei/Ordner kopiert wird und wann nicht. </summary>
		///				
		/// <returns>	Gibt ein <b><c>RoboCopyOptions</c></b>-Objekt zurück, welches die einzelnen Optionen in gekapselter Form enthält. Die enthaltenen Optionen 
		///				sind ein weiteres Mal gekapselt und von Typ <b><c>IOptions</c></b> </returns>
		public RoboCopyOptions GetOptions()
		{
			return this.options;
		}
	}
}


