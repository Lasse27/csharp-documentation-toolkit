## _Public Iequatable<iserver>_

### _Summary:_

### _Code-Snippet:_ ``public interface IServer : IEquatable<IServer> {``

---

## _Public Host_

### _Summary:_

Gets or sets the server address.

### _Code-Snippet:_ ``[JsonPropertyName("server")] public string Host {``

---

## _Public Port_

### _Summary:_

Gets or sets the server port.

### _Code-Snippet:_ ``[JsonPropertyName("server_port")] public int Port {``

---

## _Public Password_

### _Summary:_

Gets or sets the password for the server.

### _Code-Snippet:_ ``public string Password {``

---

## _Public Method_

### _Summary:_

Gets or sets the method used for the server.

### _Code-Snippet:_ ``public string Method {``

---

## _Public Plugin_

### _Summary:_

Gets or sets the plugin executable filename.

### _Code-Snippet:_ ``[JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingDefault)] public string? Plugin {``

---

## _Public Pluginopts_

### _Summary:_

Gets or sets the plugin options passed as environment variables.

### _Code-Snippet:_ ``[JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingDefault)] public string? PluginOpts {``

---

## _Public Name_

### _Summary:_

Gets or sets the server name.

### _Code-Snippet:_ ``[JsonPropertyName("remarks")] public string Name {``

---
