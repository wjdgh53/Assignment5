package tree;

public interface BSTInterface<T extends Comparable<T>>
{
	int size();
	boolean isEmpty();
	boolean remove(T element);
	void add(T element);
	T get(T element);
	boolean contains(T element);
	void reset(String ordertype);
	
}
