package project.docmaker.utility.mlogger;


import java.util.ArrayList;
import java.util.Collection;

public interface MLoggable
{
	/**
	 * Generates and returns a {@link Collection} of {@link String} which represents the instance in its current state.
	 *
	 * @return A {@link Collection} of {@link String} which represents the object in its current state.
	 */
	default Collection<String> toStringCollection ()
	{
		final Collection<String> stringCollection = new ArrayList<>();
		stringCollection.add(this.toString());
		return stringCollection;
	}
}
