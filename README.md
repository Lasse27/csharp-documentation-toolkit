## C#-Documentation-Toolkit

Dieses Repository stellt ein persönliches Projekt zur Entwicklung eines Dokumentationstools für C# dar, das ähnlich wie
JavaDoc funktioniert. Ziel des Projekts ist es, eine Software zu erstellen, die aus C#-Quellcode mit
Dokumentationskommentaren automatisch lesbare Dateien, wie z.B. Markdown oder HTML, generiert. Der Fokus liegt dabei
nicht nur auf der Funktionalität, sondern auch darauf, ein klar strukturiertes und verständliches Projekt zu entwickeln.

### Zielgruppe

Das Repository ist mehr oder weniger nur ein Eigenprojekt und richtet sich daher an niemanden direkt. Jeder kann das Projekt forken oder kopieren und kann es für sich selbst ausprobieren. Packages werden nicht erstellt.

### Umsetzung

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
  
### Grafische Benutzeroberfläche

![grafik](https://github.com/user-attachments/assets/cfcac86d-f762-4528-a352-99b2a1608c86)

### UML-Diagramm

Ein grundlegendes UML-Diagramm zur Darstellung der Code-Struktur.

![Program_structure](https://github.com/user-attachments/assets/e6e9af06-e531-4888-92e4-4fada9cbedf0)

### Ausgabebeispiel

![grafik](https://github.com/user-attachments/assets/d788c237-5f1b-4df9-8db2-be65737505d6)

