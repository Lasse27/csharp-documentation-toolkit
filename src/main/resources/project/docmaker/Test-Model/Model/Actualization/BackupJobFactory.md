### public static class BackupJobFactory 


#### Summary:
```The <see cref="BackupJobFactory"/> class works as part of the factory pattern and provides generation methods for instances  of the <see cref="BackupJob"/> struct. Class is mainly used to hide the validation of the generation parameters.```


#### Code:
```cs
/// <summary>
/// The <see cref="BackupJobFactory"/> class works as part of the factory pattern and provides generation methods for instances
/// of the <see cref="BackupJob"/> struct. Class is mainly used to hide the validation of the generation parameters.
/// </summary>
/// <author> Lasse-Leander Hillen </author>
public static class BackupJobFactory
{

	/// <summary>
	/// Creates a new instance of <see cref="BackupJob"/> by validating the passed filepaths and collecting the needed files from the collections.
	/// </summary>
	/// <param name="workstationPaths"> A <see cref="CheckedItemCollection"/> that contains the paths of the target workstations. </param>
	/// <param name="filePaths"> A <see cref="CheckedItemCollection"/> that contains the selected files from the update directory. </param>
	/// <returns> A new <see cref="ActualizationJob"/> instance if all parameters were validated. </returns>
	/// <exception cref="ArgumentNullException">Throws an <see cref="ArgumentNullException"/> if any of the parameters couldn't be validated. </exception>
	public static BackupJob CreateJob (CheckedItemCollection workstationPaths, CheckedItemCollection filePaths)
	{
		List<string> workstationStrings = (from object inside in workstationPaths select inside.ToString()).ToList();
		List<string> fileStrings = (from object inside in filePaths select inside.ToString()).ToList();

		if (workstationStrings is null)
		{
			throw new ArgumentNullException(nameof(workstationStrings));
		}

		if (fileStrings is null)
		{
			throw new ArgumentNullException(nameof(fileStrings));
		}


		IList<DirectoryInfo> workstations = workstationStrings.Select(workstationPath => new DirectoryInfo(workstationPath)).ToList();
		IDictionary<DirectoryInfo, DirectoryInfo> backupFolders = GetBackupFolders(workstations);
		IDictionary<DirectoryInfo, List<FileInfo>> affectedFiles = GetAffectedFiles(workstations, fileStrings);
		return new BackupJob(workstations, backupFolders, affectedFiles);
	}



	/// <summary>
	/// Generates a <see cref="Dictionary{TKey, TValue}"/> of the workstations and their corresponding backup folder.
	/// </summary>
	/// <param name="workstations"> A <see cref="IList{T}"/> that contains the  target workstations. </param>
	/// <returns> A <see cref="Dictionary{TKey, TValue}"/> of the workstations and their corresponding backup folder.</returns>
	private static IDictionary<DirectoryInfo, DirectoryInfo> GetBackupFolders (IList<DirectoryInfo> workstations)
	{
		// Create generalized timeStamp for all Backup-Folders
		Dictionary<DirectoryInfo, DirectoryInfo> backupFolders = new Dictionary<DirectoryInfo, DirectoryInfo>();
		DateTime folderCreationDate = DateTime.Now;

		// Iterierung durch alle Workstations und Erstellung aller betroffenen Backup-Folder
		foreach (DirectoryInfo workstation in workstations)
		{
			string backupFolderPath = Path.Combine(workstation.FullName, $"Backup_{folderCreationDate:yyyyMMdd_HHmm_ss}");
			backupFolders.Add(workstation, new DirectoryInfo(backupFolderPath));
		}

		return backupFolders;
	}



	/// <summary>
	/// Generates a <see cref="Dictionary{TKey, TValue}"/> of the workstations and their affected files.
	/// </summary>
	/// <param name="workstations"> A <see cref="IList{T}"/> that contains the  target workstations. </param>
	/// <param name="fileStrings"> A <see cref="IList{T}"/> that contains the selected files as strings. </param>
	/// <returns> A <see cref="Dictionary{TKey, TValue}"/> of the workstations and their affected files. </returns>
	private static IDictionary<DirectoryInfo, List<FileInfo>> GetAffectedFiles (IList<DirectoryInfo> workstations, List<string> fileStrings)
	{
		Dictionary<DirectoryInfo, List<FileInfo>> affectedFiles = new Dictionary<DirectoryInfo, List<FileInfo>>();
		IList<FileInfo> updateFiles = fileStrings.Select(filePath => new FileInfo(filePath)).ToList();

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
### public static BackupJob CreateJob (CheckedItemCollection workstationPaths, CheckedItemCollection filePaths 


#### Summary:
```Creates a new instance of <see cref="BackupJob"/> by validating the passed filepaths and collecting the needed files from the collections.```

#### Parameters:
- workstationPaths: ```A <see cref="CheckedItemCollection"/> that contains the paths of the target workstations.```
- filePaths: ```A <see cref="CheckedItemCollection"/> that contains the selected files from the update directory.```

#### Returns:
 ```A new <see cref="ActualizationJob"/> instance if all parameters were validated.``` 


#### Code:
```cs
/// <summary>
/// Creates a new instance of <see cref="BackupJob"/> by validating the passed filepaths and collecting the needed files from the collections.
/// </summary>
/// <param name="workstationPaths"> A <see cref="CheckedItemCollection"/> that contains the paths of the target workstations. </param>
/// <param name="filePaths"> A <see cref="CheckedItemCollection"/> that contains the selected files from the update directory. </param>
/// <returns> A new <see cref="ActualizationJob"/> instance if all parameters were validated. </returns>
/// <exception cref="ArgumentNullException">Throws an <see cref="ArgumentNullException"/> if any of the parameters couldn't be validated. </exception>
public static BackupJob CreateJob (CheckedItemCollection workstationPaths, CheckedItemCollection filePaths)
{
	List<string> workstationStrings = (from object inside in workstationPaths select inside.ToString()).ToList();
	List<string> fileStrings = (from object inside in filePaths select inside.ToString()).ToList();

	if (workstationStrings is null)
	{
		throw new ArgumentNullException(nameof(workstationStrings));
	}

	if (fileStrings is null)
	{
		throw new ArgumentNullException(nameof(fileStrings));
	}


	IList<DirectoryInfo> workstations = workstationStrings.Select(workstationPath => new DirectoryInfo(workstationPath)).ToList();
	IDictionary<DirectoryInfo, DirectoryInfo> backupFolders = GetBackupFolders(workstations);
	IDictionary<DirectoryInfo, List<FileInfo>> affectedFiles = GetAffectedFiles(workstations, fileStrings);
	return new BackupJob(workstations, backupFolders, affectedFiles);
}
```

---
### private static IDictionary<DirectoryInfo, DirectoryInfo> GetBackupFolders (IList<DirectoryInfo> workstations 


#### Summary:
```Generates a <see cref="Dictionary{TKey, TValue}"/> of the workstations and their corresponding backup folder.```

#### Parameters:
- workstations: ```A <see cref="IList{T}"/> that contains the target workstations.```

#### Returns:
 ```A <see cref="Dictionary{TKey, TValue}"/> of the workstations and their corresponding backup folder.``` 


#### Code:
```cs
/// <summary>
/// Generates a <see cref="Dictionary{TKey, TValue}"/> of the workstations and their corresponding backup folder.
/// </summary>
/// <param name="workstations"> A <see cref="IList{T}"/> that contains the  target workstations. </param>
/// <returns> A <see cref="Dictionary{TKey, TValue}"/> of the workstations and their corresponding backup folder.</returns>
private static IDictionary<DirectoryInfo, DirectoryInfo> GetBackupFolders (IList<DirectoryInfo> workstations)
{
	// Create generalized timeStamp for all Backup-Folders
	Dictionary<DirectoryInfo, DirectoryInfo> backupFolders = new Dictionary<DirectoryInfo, DirectoryInfo>();
	DateTime folderCreationDate = DateTime.Now;

	// Iterierung durch alle Workstations und Erstellung aller betroffenen Backup-Folder
	foreach (DirectoryInfo workstation in workstations)
	{
		string backupFolderPath = Path.Combine(workstation.FullName, $"Backup_{folderCreationDate:yyyyMMdd_HHmm_ss}");
		backupFolders.Add(workstation, new DirectoryInfo(backupFolderPath));
	}

	return backupFolders;
}
```

---
### private static IDictionary<DirectoryInfo, List<FileInfo>> GetAffectedFiles (IList<DirectoryInfo> workstations, List<string> fileStrings 


#### Summary:
```Generates a <see cref="Dictionary{TKey, TValue}"/> of the workstations and their affected files.```

#### Parameters:
- workstations: ```A <see cref="IList{T}"/> that contains the target workstations.```
- fileStrings: ```A <see cref="IList{T}"/> that contains the selected files as strings.```

#### Returns:
 ```A <see cref="Dictionary{TKey, TValue}"/> of the workstations and their affected files.``` 


#### Code:
```cs
/// <summary>
/// Generates a <see cref="Dictionary{TKey, TValue}"/> of the workstations and their affected files.
/// </summary>
/// <param name="workstations"> A <see cref="IList{T}"/> that contains the  target workstations. </param>
/// <param name="fileStrings"> A <see cref="IList{T}"/> that contains the selected files as strings. </param>
/// <returns> A <see cref="Dictionary{TKey, TValue}"/> of the workstations and their affected files. </returns>
private static IDictionary<DirectoryInfo, List<FileInfo>> GetAffectedFiles (IList<DirectoryInfo> workstations, List<string> fileStrings)
{
	Dictionary<DirectoryInfo, List<FileInfo>> affectedFiles = new Dictionary<DirectoryInfo, List<FileInfo>>();
	IList<FileInfo> updateFiles = fileStrings.Select(filePath => new FileInfo(filePath)).ToList();

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
