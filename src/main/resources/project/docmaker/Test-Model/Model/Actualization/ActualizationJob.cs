using System.Collections.Generic;
using System.Diagnostics;
using System.IO;

using ProntoTool.Model.Tool;

namespace ProntoTool.Model.Actualization
{
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
}
