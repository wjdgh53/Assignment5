package support;

public interface UnboundedInterface<T> extends QueueInterface<T> 
{
	void enqueue(T element);
	//add item
}
