using System.Collections.Generic;
using System.IO;
using System.Linq;


namespace ProntoTool.Model.Powershell
{
	/// <inheritdoc />
	public class RobocopyJob : PowershellJob
	{
		public DirectoryInfo SourceDirectoryInfo { get; }


		public DirectoryInfo TargetDirectoryInfo { get; }


		public IList<FileInfo> JobFiles { get; }


		public IList<PowershellArgument> CopyArguments { get; }



		public RobocopyJob (DirectoryInfo sourceDirectory, DirectoryInfo targetDirectory, IList<FileInfo> files, IList<PowershellArgument> arguments)
			: base(new PowershellCommand(ImplementationRessources.RobocopyCommand), GetArgumentList(sourceDirectory, targetDirectory, files, arguments))
		{
			this.SourceDirectoryInfo = sourceDirectory;
			this.TargetDirectoryInfo = targetDirectory;
			this.JobFiles = files;
			this.CopyArguments = arguments;
		}



		private static PowershellArgument[] GetArgumentList (DirectoryInfo sourceDirectoryInfo, DirectoryInfo targetDirectoryInfo, IList<FileInfo> jobFiles,
															IList<PowershellArgument> copyArguments)
		{
			List<PowershellArgument> result = new List<PowershellArgument>
			{
				new PowershellArgument(sourceDirectoryInfo.FullName),
				new PowershellArgument(targetDirectoryInfo.FullName)
			};
			result.AddRange(jobFiles.Select(fileInfo => new PowershellArgument(fileInfo.Name)));
			result.AddRange(copyArguments);
			return result.ToArray();
		}
	}
}