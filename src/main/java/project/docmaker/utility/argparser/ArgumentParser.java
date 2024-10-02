package project.docmaker.utility.argparser;


import org.jetbrains.annotations.NotNull;
import project.docmaker.utility.mlogger.MLogger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static project.docmaker.utility.mlogger.MLoggerMode.JVM;


public final class ArgumentParser
{


	@NotNull
	public static Map<JVMArgument, String> parse (final String... args)
	{
		// Checking if JVM-Arguments exist and can be parsed.
		if (!jvmArgumentsExist(args))
		{
			MLogger.logLn(JVM, "No jvm-arguments found, skipping jvm-argument parsing and using standard configuration.");
			return new HashMap<>();
		}

		// Parsing the JVM-Arguments and retrieving them as a map
		MLogger.logLnf(JVM, "Beginning jvm-argument-parsing for args: {0}.", Arrays.toString(args));
		final Map<JVMArgument, String> recognizedArguments = new HashMap<>();
		for (int i = 0; i < args.length; i += 2)
		{
			final String currentArgument = args[i];
			final String currentArgumentValue = args[i + 1];
			for (final JVMArgument jvmArgument : JVMArgument.values())
			{
				// Matches the name of the argument to the respective enum value.
				if (jvmArgument.getName().equals(currentArgument))
				{
					// Checks if the argument value is inside the possible/accepted values.
					if (jvmArgument.getPossibleValues().contains(currentArgumentValue))
					{
						// Adding the argument and its value to the map.
						MLogger.logLnf(JVM, "Found jvm-argument: \"{0}\" with value \"{1}\".", currentArgument, currentArgumentValue);
						recognizedArguments.put(jvmArgument, currentArgumentValue);
						break;
					}
					MLogger.logLnf(JVM, "Could not recognize value: {0} for argument: {1}.", currentArgument, currentArgumentValue);
					return new HashMap<>();
				}
			}
		}

		// Returning the created map and logging the size.
		MLogger.logLnf(JVM, "Finished jvm-argument-parsing: {0} arguments found.", recognizedArguments.size());
		return recognizedArguments;
	}



	private static boolean jvmArgumentsExist (final String[] args)
	{
		if (args == null || args.length < 1)
		{
			MLogger.logLn(JVM, "No jvm-arguments found, skipping jvm-argument-parsing.");
			return false;
		}
		return true;
	}
}
