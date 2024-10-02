package project.docmaker.utility.argparser;


import org.jetbrains.annotations.NotNull;
import project.docmaker.utility.mlogger.MLoggerMode;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public enum JVMArgument
{
	/**
	 * The {@link JVMArgument} used to declare the logDepth of the program.
	 */
	LOG_DEPTH("-logDepth", new ArrayList<>()
	{{
		this.add("DEBUG");
		this.add("INFORMATION");
		this.add("WARNING");
		this.add("ERROR");
	}}),

	/**
	 * The {@link JVMArgument} used to enable the GUI of the application.
	 */
	ENABLE_GUI("-enableGUI", new ArrayList<>()
	{{
		this.add("true");
		this.add("false");
	}});


	/**
	 * {@link MessageFormat} pattern, which is used, when the {@link MLoggerMode#toString()} method gets called
	 */
	private static final String TEXT_FORMAT = "{0} @ {1} ({2}) [name={3}, possibleValues={4}]";


	private final String name;


	private final List<String> possibleValues;



	JVMArgument (final String name, final List<String> possibleValues)
	{
		this.name = name;
		this.possibleValues = possibleValues;
	}



	/**
	 * Returns the name of the {@link JVMArgument}.
	 *
	 * @return A String that represents the name of the {@link JVMArgument}.
	 */
	public String getName ()
	{
		return this.name;
	}



	/**
	 * Returns the {@link List} of possible values for the {@link JVMArgument}.
	 *
	 * @return A {@link List} that represents the possible values for the {@link JVMArgument}.
	 */
	public List<String> getPossibleValues ()
	{
		return this.possibleValues;
	}



	/**
	 * Generates and returns a formatted {@link String} which represents the instance in its current state.
	 *
	 * @return A formatted {@link String} which represents the object in its current state.
	 */
	@Override
	public @NotNull String toString ()
	{
		return MessageFormat.format(TEXT_FORMAT, this.getClass()
			                                         .getSimpleName(), Integer.toHexString(this.hashCode()), this.name(), this.name,
			Arrays.toString(this.possibleValues.toArray()));
	}

}
