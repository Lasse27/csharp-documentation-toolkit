# C#-Documentation Maker

Dieses Repository stellt ein persönliches Projekt zur Entwicklung eines Dokumentationstools für C# dar, das ähnlich wie
JavaDoc funktioniert. Ziel des Projekts ist es, eine Software zu erstellen, die aus C#-Quellcode mit
Dokumentationskommentaren automatisch lesbare Dateien, wie z.B. Markdown oder HTML, generiert. Der Fokus liegt dabei
nicht nur auf der Funktionalität, sondern auch darauf, ein klar strukturiertes und verständliches Projekt zu entwickeln.

# Zielgruppe

Das Tool richtet sich an alle, die C#-Projekte dokumentieren möchten, egal ob Anfänger oder erfahrene Entwickler. Es ist
bewusst allgemein gehalten, sodass jeder, der es nützlich findet, es einsetzen kann.

# Umsetzung

- **Programmiersprache**: Die Implementierung erfolgt in Java, da mir der Umgang mit regulären Ausdrücken und den zugehörigen Klassen (Regex, Pattern,
  Matcher) in Java bereits vertraut ist. Außerdem wird Java in meiner Ausbildung eingesetzt.

- **Grafische Benutzeroberfläche**: Zu Beginn steht die Konsolenanwendung im Vordergrund, da das Tool hauptsächlich über Programmparameter gesteuert
  wird. Eine grafische Benutzeroberfläche (GUI) ist in einer späteren Version geplant, wobei diese einfach und zweckorientiert sein wird.
  Dokumentationsstandard: Es wird überwiegend der JavaDoc-Stil verwendet, da dieser klar und strukturiert ist. Die Auszeichnung der Kommentare ist
  dabei so gut wie überall im Tool konsistent umgesetzt.

- **Anpassungsfähigkeit**: Das Tool bietet Flexibilität und Erweiterbarkeit. Benutzer sollen in der Lage sein, eigene Parameter in den
  Dokumentationskommentaren zu definieren und diese bei der Generierung von Markdown-Dokumenten zu nutzen.

- **Fokus des Projekts**: Ein Hauptaspekt des Projekts liegt auf der Verständlichkeit und einer sauberen Strukturierung des Codes, da es als
  Eigenprojekt betrieben wird. Perfomance-Optimierungen sind derzeit nicht die oberste Priorität, da der Fokus auf einem leicht nachvollziehbaren und
  gut organisierten Projekt liegt.

# UML-Diagramm

Ein grundlegendes UML-Diagramm zur Darstellung der Code-Struktur wird in Kürze hier hinzugefügt.
Ausgabebeispiel (Markdown)

# Ausgabebeispiel - Unformatiert

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

# _public static bool TryParse_

### _Summary:_

Tries to parse an ss:// URL into a Server object.

### _Parameters:_

#### _url:_ ``The ss:// URL to parse.``

#### _server:_ ``A Server object represented by the URL. A new empty Server object if the URL is invalid.``

### _Returns:_

True for success. False for failure.

### _Code-Snippet:_ ``public static bool TryParse(string url, [NotNullWhen(true)] out Server? server) {``

---

# _public static bool TryParse_

### _Summary:_

Tries to parse an ss:// URL into a Server object.

### _Parameters:_

#### _uri:_ ``The ss:// URL to parse.``

#### _server:_ ``A Server object represented by the URL. A new empty Server object if the URL is invalid.``

### _Returns:_

True for success. False for failure.

### _Code-Snippet:_ ``public static bool TryParse(Uri uri, [NotNullWhen(true)] out Server? server) {``

---
