package tree;

import dictionary.FoodInfo;
import support.BSTNode;
import support.LinkedUnbndQueue;

public class BinarySearchTree<T extends Comparable<T>> implements BSTInterface<T>
{
	
	protected BSTNode<T> root;
	boolean found;
	protected LinkedUnbndQueue<T> inorder;
	protected LinkedUnbndQueue<T> preorder;
	protected LinkedUnbndQueue<T> postorder;
	
	public BinarySearchTree()
	{
		root = null;
	}
	private int recSize(BSTNode<T> tree)
	// Returns the number of elements in tree.
	{
		if(tree == null)
			return 0;
		else
			return recSize(tree.getLeft())+recSize(tree.getRight())+1;		
	}
	@Override
	public boolean isEmpty() {
		// Returns true if this BST is empty; otherwise, returns false.
		return root == null;
	}
	@Override
	public int size() {
		
		return recSize(root);
	}
	 /*private boolean recContains(T element, BSTNode<T> tree)
	  // Returns true if tree contains an element e such that 
	  // e.compareTo(element) == 0; otherwise, returns false.
	  {
		 if(tree == null)
			 return false;
		 else if (element.compareTo(tree.getInfo())<0)
			 return recContains(element, tree.getLeft());
		 else if (element.compareTo(tree.getInfo())>0)
			 return recContains(element, tree.getLeft());
		 else 
			 return true;			 
	  }*/
	
	private boolean recContains(T element, BSTNode<T> tree)
	  // Returns true if tree contains an element e such that 
	  // e.compareTo(element) == 0; otherwise, returns false.
	  {
		if (tree == null)
		      return false;       // element is not found
		    else if (element.compareTo(tree.getInfo()) < 0)
		      return recContains(element, tree.getLeft());   // Search left subtree
		    else if (element.compareTo(tree.getInfo()) > 0)
		      return recContains(element, tree.getRight());  // Search right subtree
		    else
		      return true;  		
	  
	  }
	@Override
	public boolean contains(T element) {
		// Returns true if this BST contains an element e such that 
		// e.compareTo(element) == 0; otherwise, returns false.
		
		return recContains(element,root);
	}

	private T recGet(T element, BSTNode<T> tree)
	// Returns an element e from tree such that e.compareTo(element) == 0;
	// if no such element exists, returns null.
	{
		if (tree == null)
	      return null;             // element is not found
	    else if (element.compareTo(tree.getInfo()) < 0)
	      return recGet(element, tree.getLeft());          // get from left subtree
	    else if (element.compareTo(tree.getInfo()) > 0)
	      return recGet(element, tree.getRight());         // get from right subtree
	    else
	      return tree.getInfo();  // element is found
	}
	public T get(T element)
	  // Returns an element e from this BST such that e.compareTo(element) == 0;
	  // if no such element exists, returns null.
	  {
	    return recGet(element, root);
	  }
	
	private BSTNode<T> recAdd(T element, BSTNode<T> tree)
	// Adds element to tree; tree retains its BST property.
	{
		if(tree == null)
			tree = new BSTNode<T>(element);
		else if (element.compareTo(tree.getInfo())<= 0)
			tree.setLeft(recAdd(element, tree.getLeft()));
		else if (element.compareTo(tree.getInfo())> 0)
			tree.setRight(recAdd(element, tree.getRight()));
		return tree;		  
	}
	@Override
	public void add(T element) {
		// Adds element to this BST. The tree retains its BST property.
		root = recAdd(element, root);
	}
	private T getPredecessor(BSTNode<T> tree)
	// Returns the information held in the rightmost node in tree
	{
		while(tree.getRight() != null)
		{
			tree = tree.getRight();
		}
		return tree.getInfo();

	}
	private BSTNode<T> removeNode(BSTNode<T> tree)
	// Removes the information at the node referenced by tree.
	// The user's data in the node referenced by tree is no
	  // longer in the tree.  If tree is a leaf node or has only
	  // a non-null child pointer, the node pointed to by tree is
	  // removed; otherwise, the user's data is replaced by its
	  // logical predecessor and the predecessor's node is removed.
	 {
		T data;
		if(tree.getLeft() == null)
			return tree.getRight();
		else if(tree.getRight() == null)
			return tree.getLeft();
		else{
			data = getPredecessor(tree.getLeft());
			tree.setInfo(data);
			tree.setLeft(recRemove(data, tree.getLeft()));
			return tree;
		}		 
	 }
	private BSTNode<T> recRemove(T element, BSTNode<T> tree)
	  // Removes an element e from tree such that e.compareTo(element) == 0
	  // and returns true; if no such element exists, returns false. 
	{
		if(tree == null)
			found = false;
		else if(element.compareTo(tree.getInfo())<0)
			tree.setLeft(recRemove(element, tree.getLeft()));
		else if(element.compareTo(tree.getInfo())>0)
			tree.setRight(recRemove(element, tree.getRight()));
		else{
			tree = removeNode(tree);
			found = true;
		}
		return tree;		
	}
	@Override 
	public boolean remove (T element)
	  // Removes an element e from this BST such that e.compareTo(element) == 0
	  // and returns true; if no such element exists, returns false. 
	  {
		root = recRemove(element, root);
		return found;
		
	  }
	private void inOrder(BSTNode<T> tree)
	  // Initializes inOrderQueue with tree elements in inOrder order.
	{
		if(tree != null){
		inOrder(tree.getLeft());
		inorder.enqueue(tree.getInfo());
		inOrder(tree.getRight());
		}
	}
	private void postOrder(BSTNode<T> tree)
	{
		if(tree != null){
		inOrder(tree.getLeft());		
		inOrder(tree.getRight());
		postorder.enqueue(tree.getInfo());
		}
	}
	private void preOrder(BSTNode<T> tree)
	{
		if(tree != null){
		postorder.enqueue(tree.getInfo());
		inOrder(tree.getLeft());		
		inOrder(tree.getRight());		
		}
	}	
	@Override
	public void reset(String ordertype) {
		// TODO Auto-generated method stub
		if(ordertype.equals("INORDER")){
			inorder = new LinkedUnbndQueue<T>(); 
			inOrder(root);
		}
		if (ordertype.equals("PREORDER")){
			preorder = new LinkedUnbndQueue<T>();
			preOrder(root);
		}
		if (ordertype.equals("POSTORDER")){
			postorder = new LinkedUnbndQueue<T>();
			postOrder(root);
		}
			
	}
	
	public T getNext(String ordertype)
	 // Preconditions: The BST is not empty
	  //                The BST has been reset for orderType
	  //                The BST has not been modified since the most recent reset
	  //                The end of orderType iteration has not been reached
	  //
	  // Returns the element at the current position on this BST for orderType
	  // and advances the value of the current position based on the orderType. 
	{
		if(!isEmpty()){
		if (ordertype.equals("INORDER"))
			return inorder.dequeue();
		if (ordertype.equals("PREORDER"))
			return preorder.dequeue();
		if (ordertype.equals("POSTORDER"))
			return postorder.dequeue();
		else
			return null;
	}
		return null;
	}
	
	

}
