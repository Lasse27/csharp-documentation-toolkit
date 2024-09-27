using System.Collections.Generic;
using System.IO;

using IniParser;
using IniParser.Model;

using ProntoTool.Exceptions.DBTransfer;

namespace ProntoTool.Model.DBTransfer
{
	/// <summary>
	/// The <see cref="DBTransferJobFactory"/> class works as part of the factory pattern and provides generation methods for instances 
	/// of the <see cref="DBTransferJob"/> struct. Class is mainly used to hide the validation of the generation parameters.
	/// </summary>
	/// <author> Lasse-Leander Hillen </author>
	public static class DBTransferJobFactory
	{

		/// <summary>
		/// Creates a new instance of <see cref="DBTransferJob"/> by validating the passed filepaths and collecting the ini-entries from the files.
		/// </summary>
		/// <param name="sourceConfigPath"> The path of the ini-File, that is being used as source configuration. </param>
		/// <param name="targetConfigPath"> The path of the ini-File, that is being used as target configuration. </param>
		/// <returns> A new instance of  <see cref="DBTransferJob"/> if the generation parameters were vailidated. </returns>
		/// <exception cref="DBTransferJobFactoryException"> Throws an exception if the generation parameters couldn't be vailidated. </exception>
		public static DBTransferJob CreateJob (string sourceConfigPath, string targetConfigPath)
		{
			// Validation of the path
			FileInfo sourceFileInfo = null;
			if (!string.IsNullOrWhiteSpace(sourceConfigPath))
			{
				sourceFileInfo = new FileInfo(sourceConfigPath);
				if (!sourceFileInfo.Exists || sourceFileInfo.Extension != DBTransferResources.IniFileExtension)
				{
					throw new DBTransferJobFactoryException(nameof(sourceConfigPath), sourceConfigPath);
				}
			}
			else
			{
				throw new DBTransferJobFactoryException(nameof(targetConfigPath), targetConfigPath);
			}

			// Validation of the targetConfigPath
			FileInfo targetFileInfo = null;
			if (!string.IsNullOrWhiteSpace(targetConfigPath))
			{
				targetFileInfo = new FileInfo(targetConfigPath);
				if (!targetFileInfo.Exists || targetFileInfo.Extension != DBTransferResources.IniFileExtension)
				{
					throw new DBTransferJobFactoryException(nameof(targetConfigPath), targetConfigPath);
				}
			}
			else
			{
				throw new DBTransferJobFactoryException(nameof(targetConfigPath), targetConfigPath);
			}

			// Creating the dictionary for the sourceConfigurationEntries and targetConfigurationEntries
			Dictionary<string, string> sourceConfigurationEntries = CollectSourceEntries(sourceConfigPath);
			Dictionary<string, string> targetConfigurationEntries = CollectTargetEntries(targetConfigPath);

			// Creating the job instance
			return new DBTransferJob(sourceFileInfo, targetFileInfo, sourceConfigurationEntries, targetConfigurationEntries);
		}



		/// <summary>
		/// Collects the necessary ini-entries for the dbtransfer from the source config.
		/// </summary>
		/// <param name="path"> The path of the ini-File, that is being used as source configuration. </param>
		/// <returns> A <see cref="Dictionary{TKey, TValue}"/> that contains the entries as <see cref="KeyValuePair{TKey, TValue}"/>. </returns>
		private static Dictionary<string, string> CollectSourceEntries (string path)
		{
			// Getting the keycollections from the ini file.
			KeyDataCollection sourcekeyCollection = new FileIniDataParser().ReadFile(path).Sections[DBTransferResources.DatabaseSectionKeyPronto];
			string provider = sourcekeyCollection.ContainsKey(DBTransferResources.DatabaseNameKeyPronto) ? DBTransferResources.RadiobuttonSqlServer : DBTransferResources.RadiobuttonOracle;
			string instance = sourcekeyCollection.ContainsKey(DBTransferResources.DatabaseNameKeyPronto) ? DBTransferResources.InstanceNamePronto : string.Empty;

			// Creating and returning the dictionary for the source entries.
			return new Dictionary<string, string>()
			{
				{ DBTransferResources.ProviderKeyDBTransfer,    provider },
				{ DBTransferResources.InstanceKeyDBTransfer,    instance },
				{ DBTransferResources.ServerNameKeyDBTransfer,  sourcekeyCollection[DBTransferResources.ServerNameKeyPronto] },
				{ DBTransferResources.DatabaseKeyDBTransfer,    sourcekeyCollection[DBTransferResources.DatabaseNameKeyPronto] },
				{ DBTransferResources.UserNameKeyDBTransfer,    sourcekeyCollection[DBTransferResources.UserNameKeyPronto] },
				{ DBTransferResources.PasswordKeyDBTransfer,    DBTransferResources.PasswordPronto },
				{ DBTransferResources.ClientKeyDBTransfer,      DBTransferResources.ClientTypePronto },
				{ DBTransferResources.ModeKeyDBTransfer,        DBTransferResources.ModePronto }
			};
		}



		/// <summary>
		/// Collects the necessary ini-entries for the dbtransfer from the target config.
		/// </summary>
		/// <param name="path"> The path of the ini-File, that is being used as target configuration. </param>
		/// <returns> A <see cref="Dictionary{TKey, TValue}"/> that contains the entries as <see cref="KeyValuePair{TKey, TValue}"/>. </returns>
		private static Dictionary<string, string> CollectTargetEntries (string path)
		{
			// Getting the keycollections from the ini file.
			KeyDataCollection targetkeyCollection = new FileIniDataParser().ReadFile(path).Sections[DBTransferResources.DatabaseSectionKeyPronto];
			string provider = targetkeyCollection.ContainsKey(DBTransferResources.DatabaseNameKeyPronto) ? DBTransferResources.RadiobuttonSqlServer : DBTransferResources.RadiobuttonOracle;
			string instance = targetkeyCollection.ContainsKey(DBTransferResources.DatabaseNameKeyPronto) ? DBTransferResources.InstanceNamePronto : string.Empty;

			// Creating and returning the dictionary for the target entries.
			return new Dictionary<string, string>
			{
				{ DBTransferResources.ProviderKeyDBTransfer,    provider },
				{ DBTransferResources.InstanceKeyDBTransfer,    instance },
				{ DBTransferResources.ServerNameKeyDBTransfer,  targetkeyCollection[DBTransferResources.ServerNameKeyPronto] },
				{ DBTransferResources.DatabaseKeyDBTransfer,    targetkeyCollection[DBTransferResources.DatabaseNameKeyPronto] },
				{ DBTransferResources.UserNameKeyDBTransfer,    targetkeyCollection[DBTransferResources.UserNameKeyPronto] },
				{ DBTransferResources.PasswordKeyDBTransfer,    DBTransferResources.PasswordPronto },
				{ DBTransferResources.ClientKeyDBTransfer,      DBTransferResources.ClientTypePronto }
			};
		}
	}
}
