# _internal static class Json_

### _Summary:_
This class encodes and decodes JSON strings.  Spec. details, see http://www.json.org/   JSON uses Arrays and Objects. These correspond here to the datatypes IList and IDictionary.  All numbers are parsed to doubles.
### _Code-Snippet:_ ``internal static class Json {``

---
# _public static object Deserialize_

### _Summary:_
Parses the string json into a value
### _Parameters:_
#### _json:_ ``A JSON string.``
### _Returns:_
An List&lt object&gt , a Dictionary&lt string, object&gt , a double, an integer,a string, null, true, or false
### _Code-Snippet:_ ``public static object Deserialize (string json) {``

---
# _public static string Serialize_

### _Summary:_
Converts a IDictionary / IList object or a simple type (string, int, etc.) into a JSON string
### _Parameters:_
#### _json:_ ``A Dictionary&lt string, object&gt / List&lt object&gt``
#### _pretty:_ ``A boolean to indicate whether or not JSON should be prettified, default is false.``
#### _indentText:_ ``A string to ibe used as indentText, default is 2 spaces.``
### _Returns:_
A JSON encoded string, or null if object 'json' is not serializable
### _Code-Snippet:_ ``public static string Serialize (object obj, bool pretty = false, string indentText = " ") {``

---
