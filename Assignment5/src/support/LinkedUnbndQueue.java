
package support;

public class LinkedUnbndQueue<T> implements UnboundedInterface<T> 
{
	protected Node<T> front;
	protected Node<T> rear;
	
	public LinkedUnbndQueue()
	{
		front = null;
		rear = null;
	}
	public void enqueue(T element)
	{
		// Adds element to the rear of this queue.
		Node<T> newNode = new Node<T>(element);
		if(isEmpty())
		{
			front = newNode;
		}else{
		rear.setLink(newNode);
		}
		rear = newNode;
		
	}

	@Override
	public boolean isEmpty() {
		// Returns true if this queue is empty; otherwise, returns false.
		if(rear == null)
		{
			return true;
		}else{
		return false;
		}
	}

	@Override
	public T dequeue(){
		// Throws QueueUnderflowException if this queue is empty;
		// otherwise, removes front element from this queue and returns it.
		if(isEmpty())
		{
			throw new QueueUnderFlowException("Queue is Empty It is unable to remove ");
		}else{
			T element;
			element = front.getInfo();
			front = front.getLink();
			if(front == null)
			{
				rear = null;
			}
			return element;			
		}
		
	}
	
}
