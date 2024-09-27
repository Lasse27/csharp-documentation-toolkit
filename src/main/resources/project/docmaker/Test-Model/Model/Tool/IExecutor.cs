namespace ProntoTool.Model.Tool
{
	/// <summary> 
	/// Interface for an Executor that executes a certain type of <see cref="IJob"/>. 
	/// </summary>
	public interface IExecutor
	{

		/// <summary> 
		/// Starts the execution of the contained <see cref="IJob"/> instance in sync. 
		/// </summary>
		void ExecuteSynchronous ();


		/// <summary> 
		/// Starts the execution of the contained <see cref="IJob"/> instance in async. 
		/// </summary>
		void ExecuteAsynchronous ();
	}
}