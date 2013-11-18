package tree;

public interface BSTInterface<T extends Comparable<T>>
{
	int size();
	boolean isEmpty();
	boolean remove(T element);
	boolean add(T element);
	T search(T element);
	boolean contains(T element);
	void set();
}
