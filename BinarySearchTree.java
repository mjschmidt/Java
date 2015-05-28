package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

import data_structures.OrderedList.Node;


public class BinarySearchTree<K,V> implements DictionaryADT<K,V> {

	private int currentSize;
	private int modifiedCount;
	private Node<K,V> root; // the root of the binary search tree
	

//Returns true if the dictionary has an object identified by
//key in it, otherwise false.
public boolean contains(K key)
{
	boolean status = false;
	K localKey = null;
	Iterator keyIterator = keys();
	int compareValue = 0;
	
	if (root == null)
		return status;
						
	while (keyIterator.hasNext())
	{
		localKey = (K) keyIterator.next();
		if (((Comparable<K>)key).compareTo(localKey) == 0)
		{
			status = true;
			break;
		}
	}
	
	return status;
}

//Adds the given key/value pair to the dictionary.  Returns 
//false if the dictionary is full, or if the key is a duplicate.
//Returns true if addition succeeded.
public boolean add(K key, V value)
{
	boolean status = false;
	Node<K,V> newNode = new Node<K,V>(key, value);
	int compareValue = 0;
		
	// if the tree is empty the key/value is the root node
	if (root == null)
	{
		root =  newNode;
		currentSize++;
		status = true;
	}
	else
		// insertRecursive(root, newNode);
		status = insertNotRecursive(root, newNode);
	
	return status;	
}

private boolean insertRecursive(Node<K,V> parent, Node<K,V> newNode)
{
	boolean status = false;
	int compareValue = 0;
	
//	System.out.println("newNode key: " + newNode.getKey() + " parent key: " + parent.getKey());
//	System.out.flush();
	compareValue = ((Comparable<K>)newNode.getKey()).compareTo((K)parent.getKey());
		
	// If the key of the new node is less than the root key
	// go left
	if (compareValue < 0)
	{
		if (parent.left != null)
			status = insertRecursive(parent.left, newNode);
		else
		{
			parent.left =  newNode;
			currentSize++;
			status = true;
		}
	}
	else if (compareValue > 0) // else go right
	{	
		if (parent.right != null)
			status = insertRecursive(parent.right, newNode);
		else
		{
			parent.right =  newNode;
			currentSize++;
			status = true;
		}
	} else
	{
		status = false;  // duplicate key
	}

	return status;
}
	
		

// Added insert method to handle going left or right until
// correct position is found to insert Node into the tree
private boolean insertNotRecursive(Node<K,V> root, Node<K,V> newNode)
{
	Node<K,V> currentNode;
	int compareValue = 0;
	boolean status = false;
	
	currentNode = root;
	
	while (currentNode != null)
	{		
		compareValue = ((Comparable<K>)newNode.getKey()).compareTo((K)currentNode.getKey());
		
		if (compareValue < 0)
		{
			if (currentNode.left != null)
			{
				currentNode = currentNode.left;
			}
			else
			{
				currentNode.left = newNode;
				currentSize++;
				status = true;
				currentNode = null;
			}
		}
		else if (compareValue > 0)
		{
			if (currentNode.right != null)
			{
				currentNode = currentNode.right;
			}
			else
			{
				currentNode.right = newNode;
				currentSize++;
				status = true;
				currentNode = null;
			}
		}
		else
		{
			status = false;  // duplicate key
			break;
		}
	}
	
	
	return status;
}


private Node<K,V> findParentNode(K key)
{
	Node<K,V> parentNode = null;
	Node<K,V> currentNode;
	Node<K,V> tempNode;
	int compareValue = 0;
	
	parentNode = root;
	currentNode = root;
	
	tempNode = new Node<K,V>(null, null);
	tempNode.left = parentNode;
	tempNode.right = currentNode;

	while (currentNode != null)
	{
		
		compareValue = ((Comparable<K>)currentNode.getKey()).compareTo((K)key);
		
		if (compareValue > 0)
		{
			if (currentNode.left != null)
			{
				parentNode = currentNode;
				currentNode = currentNode.left;
			}
			else
			{
				currentNode = null;	 // not found
				parentNode = null;	
			}
		}
		else if (compareValue < 0)
		{
			if (currentNode.right != null)
			{
				parentNode = currentNode;
				currentNode = currentNode.right;
			}
			else
			{
				currentNode = null;  // not found
				parentNode = null;	
			}
		}
		else
		{
			break;
		}	
	}
	
	return parentNode;
}


//Deletes the key/value pair identified by the key parameter.
//Returns true if the key/value pair was found and removed,
//otherwise false.
public boolean dddelete(K key)
{
	// NOTE stub
	boolean deleted = false;
	
	Node<K,V> parentNode = findParentNode(key);
	
	Node<K,V> tempNode = null;
	Node<K,V> deleteNode = null;
	int compareValue = 0;
	boolean leftChildOfParent = false;

	// Must have found node because we have the parent
	if (null != parentNode)
	{	
		compareValue = ((Comparable<K>)parentNode.getKey()).compareTo((K)key);
		if (compareValue == 0) // the node to delete is the parent itself
		{
			deleteNode = parentNode;	
		}
		else
		{
			// Check if node is left child of parent or right
			tempNode = parentNode.left;
			if (null != tempNode) 
			{
				compareValue = ((Comparable<K>)tempNode.getKey()).compareTo((K)key);
				if (compareValue == 0)  // this is the node to delete
				{
					deleteNode = tempNode;
					leftChildOfParent = true;
				}
				else // must be the right node
				{
					deleteNode = parentNode.right;
				}
			}
			else // child must be the right node or the parent itself
			{
				deleteNode = parentNode.right;
			}
		}
		
		if (null == deleteNode.right)  // if no children to right shift left side up
		{
			if (leftChildOfParent)
			{
				if ( (root == parentNode) && (parentNode == deleteNode) )
				{
					parentNode = deleteNode.left;
					root = parentNode;
				}
				else
				parentNode.left = deleteNode.left;  // no reference to deleteNode to java will garbage collect
			}
			else
			{
				if ( (root == parentNode) && (parentNode == deleteNode) )
				{
					parentNode = deleteNode.left;
					root = parentNode;
				}
				else
				parentNode.right = deleteNode.left;
			}
			deleteNode.left = null;
			deleteNode.right = null;
		}
		else if (null == deleteNode.left) // if no children to left shift right side up
		{
			
			if (leftChildOfParent)
			{
				if ( (root == parentNode) && (parentNode == deleteNode) )
				{
					parentNode = deleteNode.right;
					root = parentNode;
				}
				else
				parentNode.left = deleteNode.right;  // no reference to deleteNode to java will garbage collect
			}
			else
			{
				if ( (root == parentNode) && (parentNode == deleteNode) )
				{
					parentNode = deleteNode.right;
					root = parentNode;
				}
				else
				parentNode.right = deleteNode.right;
			}
			deleteNode.left = null;
			deleteNode.right = null;					
		}
		else // neither subtree is empty
		{
			// move right, then as far left as possible
			tempNode = deleteNode.right;
			
			while (null != tempNode.left)
			{
				tempNode = tempNode.left;
			}
			
			tempNode.left = deleteNode.left;
			
			// disconnect the deleteNode
			if ( (root == parentNode) && (parentNode == deleteNode) )
			{
				parentNode = deleteNode.right;
				root = parentNode;
			}
			else
				parentNode.left = deleteNode.right;
			
			
			deleteNode.left = null;
			deleteNode.right = null;
		}
		
		deleted = true;
		currentSize--;
	}

	if (false == deleted)
		System.out.println("Debug line");
	
	return deleted;	
}



	public boolean delete(K key) {
		boolean deleted = false;

		try
		{
			root = delete(root, key);
			currentSize--;
			deleted = true;
		}
		catch (RuntimeException re)
		{
			deleted = false;
		}

		return deleted;
	}

	private Node<K, V> delete(Node<K, V> p, K key) {
		if (p == null)
			throw new RuntimeException("cannot delete.");
		else if (((Comparable<K>) p.getKey()).compareTo((K) key) > 0)
			p.left = delete(p.left, key);
		else if (((Comparable<K>) p.getKey()).compareTo((K) key) < 0)
			p.right = delete(p.right, key);
		else {
			if (p.left == null)
				return p.right;
			else if (p.right == null)
				return p.left;
			else {
				// get data from the rightmost node in the left subtree
				p.key = retrieveData(p.left);
				// delete the rightmost node in the left subtree
				p.left = delete(p.left, p.key);
			}
		}
		return p;
	}

	private K retrieveData(Node<K, V> p) {
		while (p.right != null)
			p = p.right;

		return p.getKey();
	}

//Returns the value associated with the parameter key.  Returns
//null if the key is not found or the dictionary is empty.
public V getValue(K key)
{
	V object = null;
	
	// start with the root of the tree
	// NOTE object = findValueForKeyRecursive(key, root);
	//object = findValueForKeyNonRecursive(key);
	
	Node<K,V> currentNode;
	int compareValue = 0;
	
	currentNode = root;
	
	while (currentNode != null)
	{
		
		compareValue = ((Comparable<K>)currentNode.getKey()).compareTo((K)key);
		
		if (compareValue > 0)
		{
			if (currentNode.left != null)
			{
				currentNode = currentNode.left;
			}
			else
			{
				currentNode = null;	 // not found
			}
		}
		else if (compareValue < 0)
		{
			if (currentNode.right != null)
			{
				currentNode = currentNode.right;
			}
			else
			{
				currentNode = null;  // note found
			}
		}
		else
		{			
			object = currentNode.getValue();  // found
			break;
		}	
	}
	
	
	return object;	
}

private V findValueForKeyRecursive(K key, Node<K,V> currentNode)
{
	int compareValue = 0;
	V returnValue = null;
	
	// We have searched the whole tree and not found the
	// key.
	if (null == currentNode)
		return null;
	
//	while (currentNode != null)
	while (returnValue == null)
	{		
		compareValue = ((Comparable<K>)key).compareTo((K)currentNode.getKey());
		
		if (compareValue < 0)
		{
			if (currentNode.left != null)
			{
				returnValue = findValueForKeyRecursive(key, currentNode.left);
			}
		}
		else if (compareValue > 0)
		{
			if (currentNode.right != null)
			{
				returnValue = findValueForKeyRecursive(key, currentNode.right);
			}
		} else
		{
			returnValue = (V) currentNode.getValue();
			break;
		}
	}
	
	return returnValue;
}

private V findValueForKeyNonRecursive(K key)
{
	Iterator keyIterator = keys();
	Iterator valueIterator = values();
	int compareValue = 0;
	V value = null;
	K localKey = null;
	V localValue = null;

//System.out.println("key: " + key);
	
	// Iterate through the values and the keys together because
	// the order of values must match the order of the keys
	while (keyIterator.hasNext())
	{
		localKey = (K) keyIterator.next();
		localValue = (V) valueIterator.next();
		
		if (((Comparable<K>)localKey).compareTo(key) == 0)
		{
			value = localValue;
//System.out.println("found: " + value + " for key: " + key);			
			break;
		}
	}
		
	return value;
}

//Returns the key associated with the parameter value.  Returns
//null if the value is not found in the dictionary.  If more 
//than one key exists that matches the given value, returns the
//first one found. 
public K getKey(V value)
{
	K key = null;
	
	// start with the root of the tree
	key = findKeyForValue(value);
	
	
	return key;	
}

private K findKeyForValue(V value)
{
	Iterator keyIterator = keys();
	Iterator valueIterator = values();
	int compareValue = 0;
	K key = null;
	K localKey = null;
	V localValue = null;
		
	
	// Iterate through the values and the keys together because
	// the order of values must match the order of the keys
	while (keyIterator.hasNext())
	{
		localKey = (K) keyIterator.next();
		localValue = (V) valueIterator.next();
		
		if (((Comparable<V>)localValue).compareTo(value) == 0)
		{
			key = localKey;
			break;
		}
	}
		
	return key;
}

//Returns the number of key/value pairs currently stored 
//in the dictionary
public int size()
{
	return currentSize;	
}

//Returns true if the dictionary is at max capacity
public boolean isFull()
{
	// Linked Tree so never full
	return false;	
}

//Returns true if the dictionary is empty
public boolean isEmpty()
{
	boolean empty = false;

	if (this.size() <= 0)
		empty = true;
	
	
	return empty;	
}

//Returns the Dictionary object to an empty state.
public void clear()
{
	root = null;  // Java will garbage collect
	currentSize = 0;	
}

//Returns an Iterator of the keys in the dictionary, in ascending
//sorted order.  The iterator must be fail-fast.
public Iterator<K> keys()
{
	return new KeyIteratorHelper();
}

//Returns an Iterator of the values in the dictionary.  The
//order of the values must match the order of the keys. 
//The iterator must be fail-fast. 
public Iterator<V> values()
{
	return new ValueIteratorHelper();
}


// Added this inner class to support the iterator method for the keys
private class KeyIteratorHelper implements Iterator<K> {
	UnorderedList<K> unorderedList;
	Iterator<K> unorderedListIterator;

	public KeyIteratorHelper() {
		unorderedList = new UnorderedList<K>();
		inOrderLoadOrderedList(root);
		unorderedListIterator = unorderedList.iterator();
	}
	
	private void inOrderLoadOrderedList(Node<K,V> currentNode)
	{
		try
		{
			if (currentNode == null)
			{
				return;
			}
			
			inOrderLoadOrderedList(currentNode.left);
			unorderedList.insert(currentNode.getKey());
			inOrderLoadOrderedList(currentNode.right);
		} catch (RuntimeException e)
		{
			System.out.println(currentNode.getKey());
			e.printStackTrace();
			System.exit(0);
		}
		
	}

	public boolean hasNext() {
		return unorderedListIterator.hasNext();
	}

	public K next() {

		if (!hasNext())
			throw new NoSuchElementException();
		
		// Fast-Fail if the search tree has changed
		if (unorderedList.size() != currentSize)
		{
			System.out.println("unorderList size: " + unorderedList.size() + " current Size: " + currentSize);
			throw new NoSuchElementException();
		}

		return (K) unorderedListIterator.next();
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}

//Added this inner class to support the iterator method for the values
private class ValueIteratorHelper implements Iterator<V> {
	UnorderedList<V> unorderedList;
	Iterator<V> unorderedListIterator;

	public ValueIteratorHelper() {
		unorderedList = new UnorderedList<V>();
		inOrderLoadOrderedList(root);
		unorderedListIterator = unorderedList.iterator();
	}
	
	private void inOrderLoadOrderedList(Node<K,V> currentNode)
	{
		if (currentNode == null)
		{
			return;
		}
		
		inOrderLoadOrderedList(currentNode.left);
		unorderedList.insert(currentNode.getValue());
		inOrderLoadOrderedList(currentNode.right);
		
	}

	public boolean hasNext() {
		return unorderedListIterator.hasNext();
	}

	public V next() {

		if (!hasNext())
			throw new NoSuchElementException();
		
		// Fast-Fail if the search tree has changed
		if (unorderedList.size() != currentSize)
			throw new NoSuchElementException();

		return (V) unorderedListIterator.next();
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}

// Modify node from OrderedList only we hold the
// key, value, and the left and right Nodes if there 
// are any.  Not just a simple next Node.
public class Node<K,V> {
	private K key;
	private V value;
	private Node<K,V> left;
	private Node<K,V> right;
	
	public Node(K key, V value) {
		this.key = key;
		this.value = value;
		left = null;
		right = null;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public Node<K, V> getLeft() {
		return left;
	}

	public void setLeft(Node<K, V> left) {
		this.left = left;
	}

	public Node<K, V> getRight() {
		return right;
	}

	public void setRight(Node<K, V> right) {
		this.right = right;
	}
}

}
