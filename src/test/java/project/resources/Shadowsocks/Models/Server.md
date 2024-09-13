# _public class Server : IServer_

### _Summary:_

### _Code-Snippet:_ ``public class Server : IServer {``

---
# _public string Host_

### _Code-Snippet:_ ``[JsonPropertyName("server")] public string Host {``

---
# _public int Port_

### _Code-Snippet:_ ``[JsonPropertyName("server_port")] public int Port {``

---
# _public string Password_

### _Code-Snippet:_ ``public string Password {``

---
# _public string Method_

### _Code-Snippet:_ ``public string Method {``

---
# _public string? Plugin_

### _Code-Snippet:_ ``[JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingDefault)] public string? Plugin {``

---
# _public string? PluginOpts_

### _Code-Snippet:_ ``[JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingDefault)] public string? PluginOpts {``

---
# _public List<string>? PluginArgs_

### _Summary:_
Gets or sets the arguments passed to the plugin process.
### _Code-Snippet:_ ``[JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingDefault)] public List<string>? PluginArgs {``

---
# _public string Name_

### _Code-Snippet:_ ``[JsonPropertyName("remarks")] public string Name {``

---
# _public string Uuid_

### _Code-Snippet:_ ``[JsonPropertyName("id")] public string Uuid {``

---
# _public Uri ToUrl_

### _Summary:_
Converts this server object into an ss:// URL.
### _Returns:_

### _Code-Snippet:_ ``public Uri ToUrl() {``

---
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
