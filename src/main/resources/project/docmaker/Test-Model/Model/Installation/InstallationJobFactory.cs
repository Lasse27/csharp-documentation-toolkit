using System.Collections.Generic;
using System.IO;

using ProntoTool.Exceptions.Installation;

namespace ProntoTool.Model.Installation
{
	public static class InstallationJobFactory
	{

		public static InstallationJob CreateJob (InstallationPattern pattern)
		{
			ValidateJobParameters(pattern);
			return new InstallationJob(new List<InstallationPattern>() { pattern });
		}


		public static InstallationJob CreateJob (List<InstallationPattern> patterns)
		{
			ValidateJobParameters(patterns);
			return new InstallationJob(patterns);
		}


		private static void ValidateJobParameters (InstallationPattern pattern)
		{
			if (string.IsNullOrWhiteSpace(pattern.ScriptPath) || !new FileInfo(pattern.ScriptPath).Exists)
			{
				throw new InstallationJobFactoryException(nameof(pattern), pattern.ToString());
			}

			if (string.IsNullOrWhiteSpace(pattern.InstallFilePath) || !new FileInfo(pattern.InstallFilePath).Exists)
			{
				throw new InstallationJobFactoryException(nameof(pattern), pattern.ToString());
			}

			if (string.IsNullOrWhiteSpace(pattern.InstallDirPath) || !new DirectoryInfo(pattern.InstallDirPath).Exists)
			{
				throw new InstallationJobFactoryException(nameof(pattern), pattern.ToString());
			}
		}


		private static void ValidateJobParameters (List<InstallationPattern> patterns)
		{
			foreach (InstallationPattern pattern in patterns)
			{
				ValidateJobParameters(pattern);
			}
		}
	}
}
