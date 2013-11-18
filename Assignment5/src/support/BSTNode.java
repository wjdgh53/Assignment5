package support;



public class BSTNode<T extends Comparable<T>> 
{
	protected T info;                // The info in a BST node
	protected BSTNode<T> left;       // A link to the left child node	
	protected BSTNode<T> right;      // A link to the right child node

	public BSTNode(T info) 
	{

		this.info = info;
		left = null;
		right = null;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public void setLeft(BSTNode<T> link) {
		left = link;
	}
	public void setRight(BSTNode<T> link) {
		right = link;
	}
	public BSTNode<T> getRight() {
		return right;
	}
	public BSTNode<T> getLeft() {
		return left;
	}
	
}
