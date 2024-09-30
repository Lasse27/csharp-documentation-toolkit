## public struct BackupJob : IJob 


### Summary:
```The <see cref="BackupJob"/> struct represents a job-dataclass that contains relevant information to start the backup process.```

### Code:
```cs
/// <summary>
/// The <see cref="BackupJob"/> struct represents a job-dataclass that contains relevant information to start the backup process.
/// </summary>
[DebuggerDisplay("{" + nameof(GetDebuggerDisplay) + "(),nq}")]
public struct BackupJob : IJob
{

	/// <summary>
	/// The <see cref="IList{T}"/> of <see cref="DirectoryInfo"/> that contains the target workstations of the update.
	/// </summary>
	public readonly IList<DirectoryInfo> Workstations;

	/// <summary>
	/// The <see cref="IDictionary{TKey, TValue}"/> of <see cref="DirectoryInfo"/> that contains the target workstations with their backup folders.
	/// </summary>
	public readonly IDictionary<DirectoryInfo, DirectoryInfo> BackupFolders;

	/// <summary>
	/// The <see cref="IList{T}"/> of <see cref="FileInfo"/> that contains the files of the workstations, that will be affected by updating.
	/// </summary>
	public readonly IDictionary<DirectoryInfo, List<FileInfo>> AffectedFiles;



	/// <summary>
	/// Standard constructor, which initalizes a new instance of <see cref="BackupJob"/> and sets all the necessary attributes.
	/// </summary>
	/// <param name="workstations"> The <see cref="IList{T}"/> of <see cref="DirectoryInfo"/> that contains the target workstations of the update. </param>
	/// <param name="backupFolders"> The <see cref="IDictionary{TKey, TValue}"/> of <see cref="DirectoryInfo"/> that contains the target workstations with their backup folders. </param>
	/// <param name="affectedFiles"> The <see cref="IList{T}"/> of <see cref="FileInfo"/> that contains the files of the workstations, that will be affected by updating. </param>
	/// <exception cref="ArgumentNullException"> Throws an exception if any of the parameters was null. </exception>
	public BackupJob (IList<DirectoryInfo> workstations, IDictionary<DirectoryInfo, DirectoryInfo> backupFolders, IDictionary<DirectoryInfo, List<FileInfo>> affectedFiles)
	{
		this.Workstations = workstations ?? throw new ArgumentNullException(nameof(workstations));
		this.BackupFolders = backupFolders ?? throw new ArgumentNullException(nameof(backupFolders));
		this.AffectedFiles = affectedFiles ?? throw new ArgumentNullException(nameof(affectedFiles));
	}



	/// <inheritdoc/>
	public string GetJobOverview () => $"{this.GetType()}{this.GetHashCode()} [workstations=\"{this.Workstations}\", backups=\"{this.BackupFolders}\"]";



	/// <inheritdoc/>
	private string GetDebuggerDisplay () => this.ToString();



	/// <inheritdoc/>
	public override bool Equals (object obj) => base.Equals(obj);



	/// <inheritdoc/>
	public override int GetHashCode () => base.GetHashCode();



	/// <inheritdoc/>
	public override string ToString () => base.ToString();
}
```

---
## public readonly IList<DirectoryInfo> Workstations 


### Summary:
```The <see cref="IList{T}"/> of <see cref="DirectoryInfo"/> that contains the target workstations of the update.```

### Code:
```cs
/// <summary>
/// The <see cref="IList{T}"/> of <see cref="DirectoryInfo"/> that contains the target workstations of the update.
/// </summary>
public readonly IList<DirectoryInfo> Workstations;
```

---
## public readonly IDictionary<DirectoryInfo, DirectoryInfo> BackupFolders 


### Summary:
```The <see cref="IDictionary{TKey, TValue}"/> of <see cref="DirectoryInfo"/> that contains the target workstations with their backup folders.```

### Code:
```cs
/// <summary>
/// The <see cref="IDictionary{TKey, TValue}"/> of <see cref="DirectoryInfo"/> that contains the target workstations with their backup folders.
/// </summary>
public readonly IDictionary<DirectoryInfo, DirectoryInfo> BackupFolders;
```

---
## public readonly IDictionary<DirectoryInfo, List<FileInfo>> AffectedFiles 


### Summary:
```The <see cref="IList{T}"/> of <see cref="FileInfo"/> that contains the files of the workstations, that will be affected by updating.```

### Code:
```cs
/// <summary>
/// The <see cref="IList{T}"/> of <see cref="FileInfo"/> that contains the files of the workstations, that will be affected by updating.
/// </summary>
public readonly IDictionary<DirectoryInfo, List<FileInfo>> AffectedFiles;
```

---
## public BackupJob (IList<DirectoryInfo> workstations, IDictionary<DirectoryInfo, DirectoryInfo> backupFolders, IDictionary<DirectoryInfo, List<FileInfo>> affectedFiles 


### Summary:
```Standard constructor, which initalizes a new instance of <see cref="BackupJob"/> and sets all the necessary attributes.```

### Parameters:
#### workstations: ```The <see cref="IList{T}"/> of <see cref="DirectoryInfo"/> that contains the target workstations of the update.```
#### backupFolders: ```The <see cref="IDictionary{TKey, TValue}"/> of <see cref="DirectoryInfo"/> that contains the target workstations with their backup folders.```
#### affectedFiles: ```The <see cref="IList{T}"/> of <see cref="FileInfo"/> that contains the files of the workstations, that will be affected by updating.```

### Code:
```cs
/// <summary>
/// Standard constructor, which initalizes a new instance of <see cref="BackupJob"/> and sets all the necessary attributes.
/// </summary>
/// <param name="workstations"> The <see cref="IList{T}"/> of <see cref="DirectoryInfo"/> that contains the target workstations of the update. </param>
/// <param name="backupFolders"> The <see cref="IDictionary{TKey, TValue}"/> of <see cref="DirectoryInfo"/> that contains the target workstations with their backup folders. </param>
/// <param name="affectedFiles"> The <see cref="IList{T}"/> of <see cref="FileInfo"/> that contains the files of the workstations, that will be affected by updating. </param>
/// <exception cref="ArgumentNullException"> Throws an exception if any of the parameters was null. </exception>
public BackupJob (IList<DirectoryInfo> workstations, IDictionary<DirectoryInfo, DirectoryInfo> backupFolders, IDictionary<DirectoryInfo, List<FileInfo>> affectedFiles)
{
	this.Workstations = workstations ?? throw new ArgumentNullException(nameof(workstations));
	this.BackupFolders = backupFolders ?? throw new ArgumentNullException(nameof(backupFolders));
	this.AffectedFiles = affectedFiles ?? throw new ArgumentNullException(nameof(affectedFiles));
}
```

---
## public string GetJobOverview 


### Code:
```cs
/// <inheritdoc/>
public string GetJobOverview () => $"{this.GetType()}
```

---
## private string GetDebuggerDisplay () 


### Code:
```cs
/// <inheritdoc/>
private string GetDebuggerDisplay () => this.ToString();
```

---
## public override bool Equals (object obj) 


### Code:
```cs
/// <inheritdoc/>
public override bool Equals (object obj) => base.Equals(obj);
```

---
## public override int GetHashCode () 


### Code:
```cs
/// <inheritdoc/>
public override int GetHashCode () => base.GetHashCode();
```

---
## public override string ToString () 


### Code:
```cs
/// <inheritdoc/>
public override string ToString () => base.ToString();
```

---
