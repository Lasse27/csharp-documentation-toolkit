using System.Collections.Generic;
using System.Diagnostics;


namespace ProntoTool.Model.Powershell
{
	/// <summary> The class PowershellJob represents a configuration for PowerShell instances. </summary>
	[DebuggerDisplay("{" + nameof(GetDebuggerDisplay) + "(),nq}")]
	public class PowershellJob
	{
		/// <summary> Arguments of the powershell command </summary>
		public PowershellArgument[] Arguments { get; set; }


		/// <summary> Command at the beginning of the powershell call </summary>
		public PowershellCommand Command { get; set; }


		/// <summary> Parameters of the powershell command </summary>
		public Dictionary<string, string> Parameters { get; set; }

		/// <summary> </summary>
		public bool SingleEventLog { get; set; } = false;


		/// <summary> Initializes a new instance of the PowershellJob class. </summary>
		public PowershellJob (PowershellCommand command, Dictionary<string, string> parameters, params PowershellArgument[] powerShellArguments)
		{
			this.Command = command;
			this.Parameters = parameters;
			this.Arguments = powerShellArguments;
		}



		/// <summary> Initializes a new instance of the PowershellJob class. </summary>
		public PowershellJob (PowershellCommand command, params PowershellArgument[] powerShellArguments)
		{
			this.Command = command;
			this.Parameters = new Dictionary<string, string>();
			this.Arguments = powerShellArguments;
		}



		/// <summary> Returns a string that represents the object in its current state. </summary>
		public override string ToString ()
		{
			return $"{this.Command.Value}";
		}



		/// <summary> Get the debugger display of the instance </summary>
		private string GetDebuggerDisplay ()
		{
			return this.ToString();
		}
	}


	/// <summary> Record which encapsulates the command of an PowerShell-instance </summary>
	public struct PowershellCommand
	{
		public string Value { get; }



		public PowershellCommand (string value)
		{
			this.Value = value;
		}
	}


	/// <summary> Record which encapsulates the argument of an PowerShell-instance </summary>
	public struct PowershellArgument
	{
		public string Value { get; }



		public PowershellArgument (string value)
		{
			this.Value = value;
		}
	}


	/// <summary> Record which encapsulates the parameter of an PowerShell-instance </summary>
	public struct PowershellParameter
	{
		public string Value { get; }


		public string Key { get; }



		public PowershellParameter (string key, string value)
		{
			this.Key = key;
			this.Value = value;
		}
	}
}