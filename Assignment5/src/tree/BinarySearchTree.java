package tree;

import support.BSTNode;
import support.LinkedUnbndQueue;

public class BinarySearchTree<T extends Comparable<T>> implements BSTInterface<T>
{
	protected BSTNode<T> root;
	boolean found;
	protected LinkedUnbndQueue<T> inorder;
	
	public BinarySearchTree()
	{
		root = null;
	}
	 private int recSize(BSTNode<T> tree)
	  // Returns the number of elements in tree.
	 {
		return 0;
		 
	 }
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean isEmpty() {
		// Returns true if this BST is empty; otherwise, returns false.
		return root == null;
	}


	  private BSTNode<T> recAdd(T element, BSTNode<T> tree)
	  // Adds element to tree; tree retains its BST property.
	  {
		return tree;
		  
	  }
	@Override
	public boolean add(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T search(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T element) {
		// TODO Auto-generated method stub
		return false;
	}
	 private T getPredecessor(BSTNode<T> tree)
	  // Returns the information held in the rightmost node in tree
	 {
		return null;
		 
	 }
	 private BSTNode<T> removeNode(BSTNode<T> tree)
	  // Removes the information at the node referenced by tree.
	  // The user's data in the node referenced by tree is no
	  // longer in the tree.  If tree is a leaf node or has only
	  // a non-null child pointer, the node pointed to by tree is
	  // removed; otherwise, the user's data is replaced by its
	  // logical predecessor and the predecessor's node is removed.
	 {
		return tree;
		 
	 }
	private BSTNode<T> recRemove(T element, BSTNode<T> tree)
	  // Removes an element e from tree such that e.compareTo(element) == 0
	  // and returns true; if no such element exists, returns false. 
	{
		return tree;
		
	}
	@Override 
	public boolean remove (T element)
	  // Removes an element e from this BST such that e.compareTo(element) == 0
	  // and returns true; if no such element exists, returns false. 
	  {
		return found;
		
	  }

	private void inOrder(BSTNode<T> tree)
	  // Initializes inOrderQueue with tree elements in inOrder order.
	{
		
	}
	@Override
	public void set() {
		// TODO Auto-generated method stub
		
	}

}
