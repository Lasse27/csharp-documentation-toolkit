package project.docmaker.model;

import org.jetbrains.annotations.NotNull;
import project.docmaker.model.tag.DocumentationTag;
import project.docmaker.model.tag.TagContentType;

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
public class DocumentationTagList implements Collection<DocumentationTag<?>>
{

	private final List<DocumentationTag<?>> tags;



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
	public DocumentationTagList (final DocumentationTag<?>... tags)
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
	public Iterator<DocumentationTag<?>> iterator ()
	{
		return this.tags.iterator();
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void forEach (final Consumer<? super DocumentationTag<?>> action)
	{
		Collection.super.forEach(action);
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
	public boolean add (final DocumentationTag<?> documentationTag)
	{
		return this.tags.add(documentationTag);
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
	public boolean addAll (@NotNull final Collection<? extends DocumentationTag<?>> collection)
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
	public boolean removeIf (final Predicate<? super DocumentationTag<?>> filter)
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
	public Spliterator<DocumentationTag<?>> spliterator ()
	{
		return Collection.super.spliterator();
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Stream<DocumentationTag<?>> stream ()
	{
		return Collection.super.stream();
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Stream<DocumentationTag<?>> parallelStream ()
	{
		return Collection.super.parallelStream();
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format("DocumentationTagList'{'tags={0}'}'", this.tags);
	}



	public DocumentationTag<?>[] getTagGroup (final TagContentType type)
	{
		final List<DocumentationTag<?>> list = this.tags.stream().filter(tag -> tag.getContentType() == type).toList();
		return list.toArray(DocumentationTag[]::new);
	}
}
