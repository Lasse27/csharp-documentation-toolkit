# C#-Documentation Maker
Bei diesem Repository handelt es sich vornehmlich um ein Eigenprojekt, bei dem ein Dokumentationstool wie bspw. JavaDoc für C# entwickelt werden soll.
Ziel ist es, eine Software zu erschaffen, die aus einem Quellcode mit Dokumentationskommentaren in C# eine lesbare Datei, z.B. in MarkDown oder HTML erstellt.

---

## Umsetzung
- Zur Umsetzung wird dabei vor allem mit regulären Ausdrücken und der Programmiersprache Java gearbeitet, da ich mit dem Java Framework JavaFX zur Entwicklung von
grafischen Beutzeroberflächen bereits vertraut bin. 
- Das GUI steht dabei zunächst im Hintergrund, denn das Tool soll vorerst nur über die Konsole bzw. Programmparameter funktionieren.

---

## Anpassungsfähigkeit
- Es soll dabei auch ein großes Maß an Änderbarkeit vorhanden sein: Der Nutzer soll z.B. in der Lage sein, eigene Parameter in Dokumentationskommentaren zu erstellen und
auch damit ein MarkDown-Dokument zu generieren.

---

## UML-Diagramm
Ein grundlegendes UML-Diagramm für die Struktur des Codes wird nach angefügt...

---

## Ausgabebeispiel - Markdown

# _public static bool TryParse_

### _Summary:_
Tries to parse an ss:// URL into a Server object.
### _Parameters:_
#### _url:_ ``The ss:// URL to parse.``
#### _server:_ ``A Server object represented by the URL.  A new empty Server object if the URL is invalid.``
### _Returns:_
True for success. False for failure.
### _Code-Snippet:_ ``public static bool TryParse(string url, [NotNullWhen(true)] out Server? server) {``

---
# _public static bool TryParse_

### _Summary:_
Tries to parse an ss:// URL into a Server object.
### _Parameters:_
#### _uri:_ ``The ss:// URL to parse.``
#### _server:_ ``A Server object represented by the URL.  A new empty Server object if the URL is invalid.``
### _Returns:_
True for success. False for failure.
### _Code-Snippet:_ ``public static bool TryParse(Uri uri, [NotNullWhen(true)] out Server? server) {``

---
