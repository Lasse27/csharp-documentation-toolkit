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

# Ausgabebeispiel

## public ActualizationJob (DirectoryInfo updateDirectory, IList<DirectoryInfo> workstations, IList<FileInfo> updateFiles, IDictionary<DirectoryInfo, List<FileInfo>> affectedFiles 


### Summary:
```Standard constructor, which initalizes a new instance of <see cref="ActualizationJob"/> and sets all the necessary attributes.```

### Parameters:
##### updateDirectory: ```The <see cref="DirectoryInfo"/> that contains the files that are supposed to be inserted with the update.```
##### workstations: ```The <see cref="IList{T}"/> of <see cref="DirectoryInfo"/> that contains the target workstations of the update.```
##### updateFiles: ```The <see cref="IList{T}"/> of <see cref="FileInfo"/> that contains the files of the update.```
##### affectedFiles: ```The <see cref="IList{T}"/> of <see cref="FileInfo"/> that contains the files of the workstations, that will be affected by updating.```


### Code:
```cs
/// <summary>
/// Standard constructor, which initalizes a new instance of <see cref="ActualizationJob"/> and sets all the necessary attributes.
/// </summary>
/// <param name="updateDirectory"> The <see cref="DirectoryInfo"/> that contains the files that are supposed to be inserted with the update. </param>
/// <param name="workstations"> The <see cref="IList{T}"/> of <see cref="DirectoryInfo"/> that contains the target workstations of the update. </param>
/// <param name="updateFiles"> The <see cref="IList{T}"/> of <see cref="FileInfo"/> that contains the files of the update. </param>
/// <param name="affectedFiles"> The <see cref="IList{T}"/> of <see cref="FileInfo"/> that contains the files of the workstations, that will be affected by updating. </param>
public ActualizationJob (DirectoryInfo updateDirectory, IList<DirectoryInfo> workstations, IList<FileInfo> updateFiles, IDictionary<DirectoryInfo, List<FileInfo>> affectedFiles)
{
	this.UpdateDirectory = updateDirectory ?? throw new System.ArgumentNullException(nameof(updateDirectory));
	this.Workstations = workstations ?? throw new System.ArgumentNullException(nameof(workstations));
	this.UpdateFiles = updateFiles ?? throw new System.ArgumentNullException(nameof(updateFiles));
	this.AffectedFiles = affectedFiles ?? throw new System.ArgumentNullException(nameof(affectedFiles));
}
```
---
