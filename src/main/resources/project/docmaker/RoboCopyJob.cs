# _public class RoboCopyJob_

### _Summary:_
Die <b><c>RoboCopyJob</c></b>-Klasse soll einen RoboCopy-Auftrag darstellen, der in einer Powershell-Konsole ausgeführt werden soll/kann.  <br></br> Der <b><c>RoboCopyJob</c></b> bietet dabei noch keine Funktionalität und soll lediglich als Datenklasse bzw. als Modell dienen.  <br></br> Ein <b><c>RoboCopyJob</c></b> kann in Verknüpfung mit der <b><c>StartJob</c></b>-Methode aus der <b><c>RoboCopyController</c>  </b>-Klasse gestartet werden.
### _Code-Snippet:_ ``public class RoboCopyJob {``

---
# _private readonly string source_

### _Summary:_
Der Quellpfad des RoboCopy-Jobs. Dies ist der Pfad, aus dem die Dateien kopiert werden (copy).
### _Code-Snippet:_ ``private readonly string source;``

---
# _private readonly string destination_

### _Summary:_
Der Quellpfad des RoboCopy-Jobs. Dies ist der Pfad, in den die Dateien eingesetzt werden (paste).
### _Code-Snippet:_ ``private readonly string destination;``

---
# _private readonly List<FileInfo> files_

### _Summary:_
Der Liste von Dateien, die definiert welche Dateien übertragen werden sollen. Wird die Liste frei gelassen, so wird das gesamte  Quellverzeichnis übertragen
### _Code-Snippet:_ ``private readonly List<FileInfo> files;``

---
# _private readonly RoboCopyOptions options_

### _Summary:_
Die Optionen des RoboCopy-Befehls, die als PowerShellParameter angehangen werden. Sie verändern den ablauf der Übertragung und/oder beschränken  die Übertragung indem sie besondere Bedingungen setzen.
### _Code-Snippet:_ ``private readonly RoboCopyOptions options;``

---
# _public RoboCopyJob_

### _Summary:_
Hauptkonstruktor der <b><c>RoboCopyJob</c></b>-Klasse, der die genannten PowerShellParameter benötigt, um einen RoboCopy-Befehl in der Powershell-  Umgebung zu generieren. <br></br> Dabei können die PowerShellParameter <b><c>files</c></b> und <b><c>options</c></b> freigelassen werden, wenn diese nicht  benötigt werden. <br></br> In diesem Falle von bewirkt dies, dass grundsätzlich alle Dateien vom Ursprung ins Ziel kopiert werden.
### _Parameters:_
#### _source:_ ``Stellt den Quellpfad bzw. den Ursprung des RoboCopy-Befehls dar, dieser legt fest, aus welchem Verzeichnis kopiert wird.``
#### _destination:_ ``Stellt den Zielpfad bzw. das Ziel des RoboCopy-Befehls dar, dieser legt fest, in welches Verzeichnis kopiert wird.``
#### _files:_ ``Stellt eine Liste von Dateien dar, die definiert werden kann, wenn nur bestimmte Dateien kopiert werden sollen.``
#### _options:_ ``Stellt die Optionen des RoboCopy-Befehls dar, dazu gehören alle PowerShellParameter, die die Übertragung beeinflussen können.``
### _Code-Snippet:_ ``public RoboCopyJob(string source, string destination, List<FileInfo> files, RoboCopyOptions options) {``

---
# _public string GetSource_

### _Summary:_
Diese Methode spiegelt eine Getter-Funktion für den Quellpfad des RoboCopy-Befehls wieder. Dieser definiert den Ursprungsort des Kopiervorgangs,  also von wo die Daten kopiert werden sollen.
### _Returns:_
Gibt einen <b><c>String</c></b> zurück, der den Systempfad zum Ursprungsort des Kopiervorgangs beschreibt.
### _Code-Snippet:_ ``public string GetSource() {``

---
# _public string GetDestination_

### _Summary:_
Diese Methode spiegelt eine Getter-Funktion für den Zielpfad des RoboCopy-Befehls wieder. Dieser definiert den Zielort des Kopiervorgangs,  also wo die Daten hin kopiert werden sollen.
### _Returns:_
Gibt einen <b><c>String</c></b> zurück, der den Systempfad zum Zielort des Kopiervorgangs beschreibt.
### _Code-Snippet:_ ``public string GetDestination() {``

---
# _public List<FileInfo> GetFiles_

### _Summary:_
Diese Methode spiegelt eine Getter-Funktion für die Dateien des RoboCopy-Befehls wieder. Diese definieren die Dateinamen der übertragenen  Dateien des Befehls.
### _Returns:_
Gibt eine <b><c>List</c></b> zurück, in der alle Dateinamen des Kopiervorgangs beschrieben werden.
### _Code-Snippet:_ ``public List<FileInfo> GetFiles() {``

---
# _public RoboCopyOptions GetOptions_

### _Summary:_
Diese Methode speigelt eine Getter-Funktion für die Optionen des RoboCopy-Jobs wieder. Es sind die PowerShellParameter, die definieren, unter welchen  Bedingung ein/e Datei/Ordner kopiert wird und wann nicht.
### _Returns:_
Gibt ein <b><c>RoboCopyOptions</c></b>-Objekt zurück, welches die einzelnen Optionen in gekapselter Form enthält. Die enthaltenen Optionen  sind ein weiteres Mal gekapselt und von Typ <b><c>IOptions</c></b>
### _Code-Snippet:_ ``public RoboCopyOptions GetOptions() {``

---
