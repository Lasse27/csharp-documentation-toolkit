package project.docmaker.model;

import org.jetbrains.annotations.NotNull;
import project.docmaker.model.tag.Tag;
import project.docmaker.model.tag.TagType;
import project.docmaker.utility.annotation.NoLogger;

import java.text.MessageFormat;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * {@inheritDoc}
 */
@NoLogger
public class DocumentationTagList implements Collection<Tag>
{

	private final List<Tag> tags;



	/**
	 * {@inheritDoc}
	 */
	public DocumentationTagList ()
	{
		this.tags = new ArrayList<>();
	}



	/**
	 * {@inheritDoc}
	 */
	public DocumentationTagList (final Tag... tags)
	{
		this.tags = new ArrayList<>();
		this.tags.addAll(List.of(tags));
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size ()
	{
		return this.tags.size();
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty ()
	{
		return this.tags.isEmpty();
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean contains (final Object o)
	{
		return this.tags.contains(o);
	}



	/**
	 * {@inheritDoc}
	 */
	@NotNull
	@Override
	public Iterator<Tag> iterator ()
	{
		return this.tags.iterator();
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object @NotNull [] toArray ()
	{
		return this.tags.toArray();
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T @NotNull [] toArray (final T @NotNull [] a)
	{
		return this.tags.toArray(a);
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T[] toArray (final IntFunction<T[]> generator)
	{
		return Collection.super.toArray(generator);
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean add (final Tag tag)
	{
		return this.tags.add(tag);
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean remove (final Object o)
	{
		return this.tags.remove(o);
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsAll (@NotNull final Collection<?> collection)
	{
		return new HashSet<>(this.tags).containsAll(collection);
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addAll (@NotNull final Collection<? extends Tag> collection)
	{
		return this.tags.addAll(collection);
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean removeAll (@NotNull final Collection<?> collection)
	{
		return this.tags.removeAll(collection);
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean removeIf (final Predicate<? super Tag> filter)
	{
		return Collection.super.removeIf(filter);
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean retainAll (@NotNull final Collection<?> collection)
	{
		return this.tags.retainAll(collection);
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clear ()
	{
		this.tags.clear();
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Spliterator<Tag> spliterator ()
	{
		return Collection.super.spliterator();
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Stream<Tag> stream ()
	{
		return Collection.super.stream();
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Stream<Tag> parallelStream ()
	{
		return Collection.super.parallelStream();
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void forEach (final Consumer<? super Tag> action)
	{
		Collection.super.forEach(action);
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format("DocumentationTagList'{'tags={0}'}'", this.tags);
	}



	public Tag[] getTagGroup (final TagType type)
	{
		final List<Tag> list = this.tags.stream().filter(tag -> tag.getType() == type).toList();
		return list.toArray(Tag[]::new);
	}
}
