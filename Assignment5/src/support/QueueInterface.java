package support;

public interface QueueInterface<T>
{
	boolean isEmpty();
	// check its empty or not
	T dequeue() throws QueueUnderFlowException;
	//remove and but return error if it is empty
}
