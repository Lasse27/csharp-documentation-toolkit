### public static class ActualizationJobFactory 


#### Summary:
```The <see cref="ActualizationJobFactory"/> class works as part of the factory pattern and provides generation methods for instances  of the <see cref="ActualizationJob"/> struct. Class is mainly used to hide the validation of the generation parameters.```


#### Code:
```cs
/// <summary>
/// The <see cref="ActualizationJobFactory"/> class works as part of the factory pattern and provides generation methods for instances
/// of the <see cref="ActualizationJob"/> struct. Class is mainly used to hide the validation of the generation parameters.
/// </summary>
/// <author> Lasse-Leander Hillen </author>
public static class ActualizationJobFactory
{

	/// <summary>
	/// Creates a new instance of <see cref="ActualizationJob"/> by validating the passed filepaths and collecting the needed files from the collections.
	/// </summary>
	/// <param name="updatePath"> The string path of the update directory, that contains the files that are inserted with the update. </param>
	/// <param name="workstationPaths"> A <see cref="CheckedItemCollection"/> that contains the paths of the target workstations. </param>
	/// <param name="filePaths"> A <see cref="CheckedItemCollection"/> that contains the selected files from the update directory. </param>
	/// <returns> A new <see cref="ActualizationJob"/> instance if all parameters were validated. </returns>
	/// <exception cref="ActualizationException"> Throws an exception if any parameter couldnt have been validated. </exception>
	public static ActualizationJob CreateJob (string updatePath, CheckedItemCollection workstationPaths, CheckedItemCollection filePaths)
	{
		// Validating the updatePath
		if (string.IsNullOrEmpty(updatePath) || !new DirectoryInfo(updatePath).Exists)
		{
			throw new ActualizationException(nameof(updatePath));
		}

		// Converting the itemcollections to string lists and collecting the Directory- and FileInfos
		List<string> workstationStrings = (from object inside in workstationPaths select inside.ToString()).ToList();
		List<string> fileStrings = (from object inside in filePaths select inside.ToString()).ToList();

		// Validating the workstationpaths
		foreach (var _ in from string workstation in workstationStrings where !new DirectoryInfo(workstation).Exists select new { })
		{
			throw new ActualizationException(nameof(workstationPaths));
		}


		// Validating the filePaths
		foreach (var _ in from string filePath in fileStrings where !new FileInfo(filePath).Exists select new { })
		{
			throw new ActualizationException(nameof(workstationPaths));

		}

		// Creating a new instance
		IList<DirectoryInfo> workstations = workstationStrings.Select(workstationPath => new DirectoryInfo(workstationPath)).ToList();
		IList<FileInfo> files = fileStrings.Select(filePath => new FileInfo(filePath)).ToList();
		return new ActualizationJob(new DirectoryInfo(updatePath), workstations, files, GetAffectedFiles(workstations, files));
	}


	/// <summary>
	/// Collects the affected files from the workstations by comparing the local filenames with the filenames of the update directory.
	/// </summary>
	/// <param name="workstations"> A <see cref="List{T}"/> of <see cref="DirectoryInfo"/> representing the workstations. </param>
	/// <param name="updateFiles">  A <see cref="List{T}"/> of <see cref="DirectoryInfo"/> representing the update files. </param>
	/// <returns> A <see cref="IDictionary{TKey, TValue}"/> that contains the workstation with its affected files as <see cref="KeyValuePair{TKey, TValue}"/></returns>
	private static IDictionary<DirectoryInfo, List<FileInfo>> GetAffectedFiles (IList<DirectoryInfo> workstations, IList<FileInfo> updateFiles)
	{
		Dictionary<DirectoryInfo, List<FileInfo>> affectedFiles = new Dictionary<DirectoryInfo, List<FileInfo>>();

		// Iterierung durch alle Workstations und Sammlung aller betroffenen Dateien
		foreach (DirectoryInfo workstation in workstations)
		{
			List<FileInfo> files = new List<FileInfo>();
			List<DirectoryInfo> possibleBackups = workstation.GetPossibleBackups(new List<string>() { "Backup_", "save" });
			List<FileInfo> fileSystemInfos = workstation.GetFilteredFiles(possibleBackups);
			foreach (FileSystemInfo fileSystemInfo in fileSystemInfos)
			{
				files.AddRange(from FileInfo updateFileInfo in updateFiles
							   where fileSystemInfo.Name.Equals(updateFileInfo.Name) && fileSystemInfo is FileInfo && !files.Contains(fileSystemInfo)
							   select fileSystemInfo as FileInfo);
			}

			affectedFiles.Add(workstation, files);
		}

		return affectedFiles;
	}
}
```

---
### public static ActualizationJob CreateJob (string updatePath, CheckedItemCollection workstationPaths, CheckedItemCollection filePaths 


#### Summary:
```Creates a new instance of <see cref="ActualizationJob"/> by validating the passed filepaths and collecting the needed files from the collections.```

#### Parameters:
- updatePath: ```The string path of the update directory, that contains the files that are inserted with the update.```
- workstationPaths: ```A <see cref="CheckedItemCollection"/> that contains the paths of the target workstations.```
- filePaths: ```A <see cref="CheckedItemCollection"/> that contains the selected files from the update directory.```

#### Returns:
 ```A new <see cref="ActualizationJob"/> instance if all parameters were validated.``` 


#### Code:
```cs
/// <summary>
/// Creates a new instance of <see cref="ActualizationJob"/> by validating the passed filepaths and collecting the needed files from the collections.
/// </summary>
/// <param name="updatePath"> The string path of the update directory, that contains the files that are inserted with the update. </param>
/// <param name="workstationPaths"> A <see cref="CheckedItemCollection"/> that contains the paths of the target workstations. </param>
/// <param name="filePaths"> A <see cref="CheckedItemCollection"/> that contains the selected files from the update directory. </param>
/// <returns> A new <see cref="ActualizationJob"/> instance if all parameters were validated. </returns>
/// <exception cref="ActualizationException"> Throws an exception if any parameter couldnt have been validated. </exception>
public static ActualizationJob CreateJob (string updatePath, CheckedItemCollection workstationPaths, CheckedItemCollection filePaths)
{
	// Validating the updatePath
	if (string.IsNullOrEmpty(updatePath) || !new DirectoryInfo(updatePath).Exists)
	{
		throw new ActualizationException(nameof(updatePath));
	}

	// Converting the itemcollections to string lists and collecting the Directory- and FileInfos
	List<string> workstationStrings = (from object inside in workstationPaths select inside.ToString()).ToList();
	List<string> fileStrings = (from object inside in filePaths select inside.ToString()).ToList();

	// Validating the workstationpaths
	foreach (var _ in from string workstation in workstationStrings where !new DirectoryInfo(workstation).Exists select new { })
	{
		throw new ActualizationException(nameof(workstationPaths));
	}


	// Validating the filePaths
	foreach (var _ in from string filePath in fileStrings where !new FileInfo(filePath).Exists select new { })
	{
		throw new ActualizationException(nameof(workstationPaths));

	}

	// Creating a new instance
	IList<DirectoryInfo> workstations = workstationStrings.Select(workstationPath => new DirectoryInfo(workstationPath)).ToList();
	IList<FileInfo> files = fileStrings.Select(filePath => new FileInfo(filePath)).ToList();
	return new ActualizationJob(new DirectoryInfo(updatePath), workstations, files, GetAffectedFiles(workstations, files));
}
```

---
### private static IDictionary<DirectoryInfo, List<FileInfo>> GetAffectedFiles (IList<DirectoryInfo> workstations, IList<FileInfo> updateFiles 


#### Summary:
```Collects the affected files from the workstations by comparing the local filenames with the filenames of the update directory.```

#### Parameters:
- workstations: ```A <see cref="List{T}"/> of <see cref="DirectoryInfo"/> representing the workstations.```
- updateFiles: ```A <see cref="List{T}"/> of <see cref="DirectoryInfo"/> representing the update files.```

#### Returns:
 ```A <see cref="IDictionary{TKey, TValue}"/> that contains the workstation with its affected files as <see cref="KeyValuePair{TKey, TValue}"/>``` 


#### Code:
```cs
/// <summary>
/// Collects the affected files from the workstations by comparing the local filenames with the filenames of the update directory.
/// </summary>
/// <param name="workstations"> A <see cref="List{T}"/> of <see cref="DirectoryInfo"/> representing the workstations. </param>
/// <param name="updateFiles">  A <see cref="List{T}"/> of <see cref="DirectoryInfo"/> representing the update files. </param>
/// <returns> A <see cref="IDictionary{TKey, TValue}"/> that contains the workstation with its affected files as <see cref="KeyValuePair{TKey, TValue}"/></returns>
private static IDictionary<DirectoryInfo, List<FileInfo>> GetAffectedFiles (IList<DirectoryInfo> workstations, IList<FileInfo> updateFiles)
{
	Dictionary<DirectoryInfo, List<FileInfo>> affectedFiles = new Dictionary<DirectoryInfo, List<FileInfo>>();

	// Iterierung durch alle Workstations und Sammlung aller betroffenen Dateien
	foreach (DirectoryInfo workstation in workstations)
	{
		List<FileInfo> files = new List<FileInfo>();
		List<DirectoryInfo> possibleBackups = workstation.GetPossibleBackups(new List<string>() { "Backup_", "save" });
		List<FileInfo> fileSystemInfos = workstation.GetFilteredFiles(possibleBackups);
		foreach (FileSystemInfo fileSystemInfo in fileSystemInfos)
		{
			files.AddRange(from FileInfo updateFileInfo in updateFiles
						   where fileSystemInfo.Name.Equals(updateFileInfo.Name) && fileSystemInfo is FileInfo && !files.Contains(fileSystemInfo)
						   select fileSystemInfo as FileInfo);
		}

		affectedFiles.Add(workstation, files);
	}

	return affectedFiles;
}
```

---
