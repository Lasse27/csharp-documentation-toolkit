using System.Diagnostics;
using System.IO;

namespace ProntoTool.Model.Installation
{
	[DebuggerDisplay("{" + nameof(GetDebuggerDisplay) + "(),nq}")]
	public class InstallationPattern
	{
		public string Name { get; set; }


		public string ScriptPath { get; set; }


		public string InstallFilePath { get; set; }


		public string InstallDirPath { get; set; }


		public string CustomOneParam { get; set; }


		public string CustomTwoParam { get; set; }


		public string CustomThreeParam { get; set; }


		public string CustomFourParam { get; set; }

		public InstallationPattern (string name, string scriptPath, string installFilePath, string installDirPath, params string[] customs)
		{
			this.Name = name;
			this.ScriptPath = scriptPath;
			this.InstallFilePath = installFilePath;
			this.InstallDirPath = installDirPath;
			this.CustomOneParam = customs.Length > 0 ? customs[0] : string.Empty;
			this.CustomTwoParam = customs.Length > 1 ? customs[1] : string.Empty;
			this.CustomThreeParam = customs.Length > 2 ? customs[2] : string.Empty;
			this.CustomFourParam = customs.Length > 3 ? customs[3] : string.Empty;
		}

		public InstallationPattern (string name)
		{
			this.Name = name;
			this.ScriptPath = string.Empty;
			this.InstallFilePath = string.Empty;
			this.InstallDirPath = string.Empty;
			this.CustomOneParam = string.Empty;
			this.CustomTwoParam = string.Empty;
			this.CustomThreeParam = string.Empty;
			this.CustomFourParam = string.Empty;
		}



		/// <inheritdoc/>
		public override bool Equals (object obj) => base.Equals(obj);

		/// <inheritdoc/>
		public override int GetHashCode () => base.GetHashCode();

		/// <inheritdoc/>
		public override string ToString () => $"{this.Name} [{Path.GetFileName(this.ScriptPath)}]";

		/// <inheritdoc/>
		private string GetDebuggerDisplay () => base.ToString();
	}
}
