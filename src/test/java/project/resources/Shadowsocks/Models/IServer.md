# _public interface IServer : IEquatable<IServer>_

### _Summary:_

### _Code-Snippet:_ ``public interface IServer : IEquatable<IServer> {``

---
# _public string Host_

### _Summary:_
Gets or sets the server address.
### _Code-Snippet:_ ``[JsonPropertyName("server")] public string Host {``

---
# _public int Port_

### _Summary:_
Gets or sets the server port.
### _Code-Snippet:_ ``[JsonPropertyName("server_port")] public int Port {``

---
# _public string Password_

### _Summary:_
Gets or sets the password for the server.
### _Code-Snippet:_ ``public string Password {``

---
# _public string Method_

### _Summary:_
Gets or sets the method used for the server.
### _Code-Snippet:_ ``public string Method {``

---
# _public string? Plugin_

### _Summary:_
Gets or sets the plugin executable filename.
### _Code-Snippet:_ ``[JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingDefault)] public string? Plugin {``

---
# _public string? PluginOpts_

### _Summary:_
Gets or sets the plugin options passed as environment variables.
### _Code-Snippet:_ ``[JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingDefault)] public string? PluginOpts {``

---
# _public string Name_

### _Summary:_
Gets or sets the server name.
### _Code-Snippet:_ ``[JsonPropertyName("remarks")] public string Name {``

---
