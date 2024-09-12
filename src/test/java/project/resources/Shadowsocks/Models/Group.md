# _public string Name_

### _Summary:_
Gets or sets the group name.
### _Code-Snippet:_ ``public string Name {``

---
# _public Guid Id_

### _Summary:_
Gets or sets the UUID of the group.
### _Code-Snippet:_ ``public Guid Id {``

---
# _public int Version_

### _Code-Snippet:_ ``public int Version {``

---
# _public List<Server> Servers_

### _Code-Snippet:_ ``public List<Server> Servers {``

---
# _public ulong BytesUsed_

### _Summary:_
Gets or sets the data usage in bytes.  The value is fetched from SIP008 provider.
### _Code-Snippet:_ ``[JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingDefault)] public ulong BytesUsed {``

---
# _public ulong BytesRemaining_

### _Summary:_
Gets or sets the data remaining to be used in bytes.  The value is fetched from SIP008 provider.
### _Code-Snippet:_ ``[JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingDefault)] public ulong BytesRemaining {``

---
