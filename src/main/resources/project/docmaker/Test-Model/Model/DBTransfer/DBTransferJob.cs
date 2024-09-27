using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Windows.Forms;

using ProntoTool.Model.Tool;

namespace ProntoTool.Model.DBTransfer
{
	/// <summary>
	/// The <see cref="DBTransferJob"/> struct represents a job-dataclass that contains relevant information to start the DBTransfer process.
	/// </summary>
	[DebuggerDisplay("{" + nameof(GetDebuggerDisplay) + "(),nq}")]
	public struct DBTransferJob : IJob
	{

		/// <summary>
		/// The string path of the DBTransfer.exe file in the folder of the running application.
		/// </summary>
		public static readonly string DBTransferPath = Path.Combine(Path.GetDirectoryName(Application.ExecutablePath), "DBTransfer.exe");

		/// <summary>
		/// The string path of the DBTransfer.ini file in the folder of the running application.
		/// </summary>
		public static readonly string DBTransferConfiguration = Path.Combine(Path.GetDirectoryName(Application.ExecutablePath), "DBTransfer.ini");

		/// <summary>
		/// The <see cref="FileInfo"/> of the source configuration of the <see cref="DBTransferJob"/>.
		/// </summary>
		public readonly FileInfo SourceConfiguration;

		/// <summary>
		/// The <see cref="FileInfo"/> of the target configuration of the <see cref="DBTransferJob"/>.
		/// </summary>
		public readonly FileInfo TargetConfiguration;

		/// <summary>
		/// The <see cref="Dictionary{TKey, TValue}"/> that contains the ini-entries of the source configuration.
		/// </summary>
		public readonly Dictionary<string, string> SourceConfigurationEntries;

		/// <summary>
		/// The <see cref="Dictionary{TKey, TValue}"/> that contains the ini-entries of the target configuration.
		/// </summary>
		public readonly Dictionary<string, string> TargetConfigurationEntries;



		/// <summary>
		/// Standard constructor, which initalizes a new instance of <see cref="DBTransferJob"/> and sets all the necessary attributes. 
		/// </summary>
		/// <param name="sourceConfig"> The <see cref="FileInfo"/> of the source configuration of the <see cref="DBTransferJob"/>. </param>
		/// <param name="targetConfig"> The <see cref="FileInfo"/> of the target configuration of the <see cref="DBTransferJob"/>. </param>
		/// <param name="sourceEntries"> The <see cref="Dictionary{TKey, TValue}"/> that contains the ini-entries of the target configuration. </param>
		/// <param name="targetEntries"> The <see cref="Dictionary{TKey, TValue}"/> that contains the ini-entries of the source configuration. </param>
		public DBTransferJob (FileInfo sourceConfig, FileInfo targetConfig, Dictionary<string, string> sourceEntries, Dictionary<string, string> targetEntries)
		{
			this.SourceConfiguration = sourceConfig ?? throw new ArgumentNullException(nameof(sourceConfig));
			this.TargetConfiguration = targetConfig ?? throw new ArgumentNullException(nameof(targetConfig));
			this.TargetConfigurationEntries = targetEntries ?? throw new ArgumentNullException(nameof(targetEntries));
			this.SourceConfigurationEntries = sourceEntries ?? throw new ArgumentNullException(nameof(sourceEntries));
		}



		/// <inheritdoc/>
		public string GetJobOverview () => $"{this.GetType()}{this.GetHashCode()} [source=\"{this.SourceConfiguration}\", target=\"{this.TargetConfiguration}\"]";



		/// <inheritdoc/>
		public override bool Equals (object obj) => base.Equals(obj);



		/// <inheritdoc/>
		public override int GetHashCode () => base.GetHashCode();



		/// <inheritdoc/>
		public override string ToString () => base.ToString();



		/// <inheritdoc/>
		private string GetDebuggerDisplay () => this.ToString();
	}
}
