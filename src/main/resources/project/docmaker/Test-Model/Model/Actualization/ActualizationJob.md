## public struct ActualizationJob : IJob 


### Summary:
```The <see cref="ActualizationJob"/> struct represents a job-dataclass that contains relevant information to start the actualization process.```


### Code:
```cs
/// <summary>
/// The <see cref="ActualizationJob"/> struct represents a job-dataclass that contains relevant information to start the actualization process.
/// </summary>
[DebuggerDisplay("{" + nameof(GetDebuggerDisplay) + "(),nq}")]
public struct ActualizationJob : IJob
{

	/// <summary>
	/// The <see cref="DirectoryInfo"/> that contains the files that are supposed to be inserted with the update.
	/// </summary>
	public readonly DirectoryInfo UpdateDirectory;

	/// <summary>
	/// The <see cref="IList{T}"/> of <see cref="DirectoryInfo"/> that contains the target workstations of the update.
	/// </summary>
	public readonly IList<DirectoryInfo> Workstations;

	/// <summary>
	/// The <see cref="IList{T}"/> of <see cref="FileInfo"/> that contains the files of the update.
	/// </summary>
	public readonly IList<FileInfo> UpdateFiles;

	/// <summary>
	/// The <see cref="IList{T}"/> of <see cref="FileInfo"/> that contains the files of the workstations, that will be affected by updating.
	/// </summary>
	public readonly IDictionary<DirectoryInfo, List<FileInfo>> AffectedFiles;



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



	/// <inheritdoc/>
	public string GetJobOverview () => $"{this.GetType()}{this.GetHashCode()} [updateDir=\"{this.UpdateDirectory}\", workstations=\"{this.Workstations}\"]";



	/// <inheritdoc/>
	public override bool Equals (object obj) => base.Equals(obj);



	/// <inheritdoc/>
	public override int GetHashCode () => base.GetHashCode();



	/// <inheritdoc/>
	public override string ToString () => base.ToString();



	/// <inheritdoc/>
	private string GetDebuggerDisplay () => this.ToString();
}
```

---
## public readonly DirectoryInfo UpdateDirectory 


### Summary:
```The <see cref="DirectoryInfo"/> that contains the files that are supposed to be inserted with the update.```


### Code:
```cs
/// <summary>
/// The <see cref="DirectoryInfo"/> that contains the files that are supposed to be inserted with the update.
/// </summary>
public readonly DirectoryInfo UpdateDirectory;
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
## public readonly IList<FileInfo> UpdateFiles 


### Summary:
```The <see cref="IList{T}"/> of <see cref="FileInfo"/> that contains the files of the update.```


### Code:
```cs
/// <summary>
/// The <see cref="IList{T}"/> of <see cref="FileInfo"/> that contains the files of the update.
/// </summary>
public readonly IList<FileInfo> UpdateFiles;
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
## public ActualizationJob (DirectoryInfo updateDirectory, IList<DirectoryInfo> workstations, IList<FileInfo> updateFiles, IDictionary<DirectoryInfo, List<FileInfo>> affectedFiles 


### Summary:
```Standard constructor, which initalizes a new instance of <see cref="ActualizationJob"/> and sets all the necessary attributes.```

### Parameters:
#### updateDirectory: ```The <see cref="DirectoryInfo"/> that contains the files that are supposed to be inserted with the update.```
#### workstations: ```The <see cref="IList{T}"/> of <see cref="DirectoryInfo"/> that contains the target workstations of the update.```
#### updateFiles: ```The <see cref="IList{T}"/> of <see cref="FileInfo"/> that contains the files of the update.```
#### affectedFiles: ```The <see cref="IList{T}"/> of <see cref="FileInfo"/> that contains the files of the workstations, that will be affected by updating.```


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
## public string GetJobOverview 



### Code:
```cs
/// <inheritdoc/>
public string GetJobOverview () => $"{this.GetType()}
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
## private string GetDebuggerDisplay () 



### Code:
```cs
/// <inheritdoc/>
private string GetDebuggerDisplay () => this.ToString();
```

---
