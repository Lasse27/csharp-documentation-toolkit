using System;
using System.Collections.Generic;
using System.Diagnostics;

using ProntoTool.Model.Tool;


namespace ProntoTool.Model.Installation
{
	[DebuggerDisplay("{" + nameof(GetDebuggerDisplay) + "(),nq}")]
	public struct InstallationJob : IJob
	{

		/// <summary> 
		/// The <see cref="InstallationPattern"/> instances which will be used in the powershell console. 
		/// </summary>
		public readonly List<InstallationPattern> Patterns;



		/// <summary>
		/// Standard constructor, which initalizes a new instance of <see cref="InstallationJob"/> and sets all the necessary attributes. 
		/// </summary>
		/// <param name="patterns"> The <see cref="InstallationPattern"/> instances which will be used in the powershell console. </param>
		/// <exception cref="ArgumentNullException"> Throws if any parameter was null. </exception>
		public InstallationJob (List<InstallationPattern> patterns) => this.Patterns = patterns ?? throw new ArgumentNullException(nameof(patterns));



		/// <inheritdoc/>
		public string GetJobOverview () => $"{this.GetType()}{this.GetHashCode()} [patterns=\"{this.Patterns}\"]";



		/// <inheritdoc/>
		public override string ToString () => base.ToString();



		/// <inheritdoc/>
		public override bool Equals (object obj) => base.Equals(obj);



		/// <inheritdoc/>
		public override int GetHashCode () => base.GetHashCode();



		/// <inheritdoc/>
		private string GetDebuggerDisplay () => this.ToString();
	}
}