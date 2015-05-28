package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class HashTable<K,V> implements  DictionaryADT<K,V> {
	private int currentSize;
	private int maxSize;
	public OrderedList<Node<K,V>> list[];  // our Node<K,V> is our E.  An array of ordered lists.


	public HashTable(int maxSize)  // example DICTIONARY_SIZE=10000 from tester program
	{
		currentSize = 0;
		this.maxSize = maxSize;

		// Create the array of ordered lists.
		// The ordered lists allow us to chain values (linked list)
		// that go to the same index in the array
		list = new OrderedList[maxSize];			
	}

	// hash the key into an index into our array
	private int hash(Object key)
	{
		int result = 42;
		
		String inputString = key.toString().toLowerCase();
		char[] characters = inputString.toCharArray();
		
		for (int i = 0; i < characters.length; i++)
		{
			char currentChar = characters[i];
			
			if (currentChar == 'a' || currentChar == 'b' || currentChar == 'c' ||
					currentChar == 'd' || currentChar == 'e' || currentChar == 'f')
			{
				result += Integer.parseInt(""+currentChar, 16);
			}
			
			int j = (int) currentChar;
			result += j;
		}
		
		// use modulo of the result with the maxSize to get an index
		return (result % this.maxSize);
	}
	
	public void print()
	{
		for (int i = 0; i < currentSize; i++)
		{
			if (null != list[i])
			{
				Iterator<Node<K,V>> iterator = list[i].iterator();
				if (iterator.hasNext())
					System.out.println("***** Index: " + i);
				for(; iterator.hasNext(); )
				{
					System.out.println("\t" + iterator.next().toString());
				}
			}
		}	
	}
	
	//Returns true if the dictionary has an object identified by
	//key in it, otherwise false.
	public boolean contains(K key)
	{
		boolean status = false;
		int index = hash(key);
			
		// if the list is not null at the index location
		// it must have some nodes in it.  The hash for the
		// key does not guarantee a node with the key is in
		// the chain at the index location so we have to 
		// see if the ordered list chain (list) contains it
		if (null != list[index])
		{
			// Our node uses a comparable based on the key so
			// create a Node with just the key and no value
			// to use to search the ordered list.
			Node<K,V> searchNodeByKey = new Node<K,V>(key, null);
			
			// See if the ordered list contains the actual key
			status = list[index].contains(searchNodeByKey);
		}
		
		return status;
	}
	
	//Adds the given key/value pair to the dictionary.  Returns 
	//false if the dictionary is full, or if the key is a duplicate.
	//Returns true if addition succeeded.
	public boolean add(K key, V value)
	{
		boolean status = false;
		int index = hash(key);
		Node<K,V> newNode = new Node<K,V>(key, value);
		
		if (!this.contains(key))
		{
			
			// Create an empty list (chain) for each array location
			if (null == list[index])
			{
				list[index] = new OrderedList<Node<K,V>>();
			}
	
			status = list[index].insert(newNode);
			currentSize++;
			status = true;
		}
		
		return status;	
	}
	
	//Deletes the key/value pair identified by the key parameter.
	//Returns true if the key/value pair was found and removed,
	//otherwise false.
	public boolean delete(K key)
	{
		boolean status = false;
		int index = hash(key);
			
		// if the list is not null at the index location
		// it must have some nodes in it.  The hash for the
		// key does not guarantee a node with the key is in
		// the chain at the index location so we have to 
		// see if the ordered list chain (list) contains it
		// and it is removed
		if (null != list[index])
		{
			// Our node uses a comparable based on the key so
			// create a Node with just the key and no value
			// to use to search the ordered list.
			Node<K,V> searchNodeByKey = new Node<K,V>(key, null);
			
			// See if the ordered list contains the actual key
			Node<K,V> removedNodeByKey = list[index].remove(searchNodeByKey);
			if (null != removedNodeByKey)
			{
				currentSize--;
				status = true;
			}
		}
		
		return status;
	}
	
	//Returns the value associated with the parameter key.  Returns
	//null if the key is not found or the dictionary is empty.
	public V getValue(K key)
	{
		V value = null;
		
		int index = hash(key);
		
		// if the list is not null at the index location
		// it must have some nodes in it.  The hash for the
		// key does not guarantee a node with the key is in
		// the chain at the index location so we have to 
		// see if the ordered list chain (list) contains it
		// and it is removed
		if (null != list[index])
		{
			// Our node uses a comparable based on the key so
			// create a Node with just the key and no value
			// to use to search the ordered list.
			Node<K,V> searchNodeByKey = new Node<K,V>(key, null);
			
			// See if the ordered list contains the actual key
			Node<K,V> foundNodeByKey = list[index].find(searchNodeByKey);
			if (null != foundNodeByKey)
			{
				value = foundNodeByKey.getValue();
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
		
		// NOTE Stub
		
		for (int i = 0; i < currentSize; i++)
		{
			if (null != list[i])
			{
				Iterator<Node<K,V>> iterator = list[i].iterator();
				for(; iterator.hasNext(); )
				{
					Node<K,V> currentNode = iterator.next();
					if (currentNode.getValue().equals(value))
					{
						key = currentNode.getKey();
					}
				}
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
		// Using an array of ordered lists so can
		// never be full unless we run out of memory
		return false;	
	}
	
	//Returns true if the dictionary is empty
	public boolean isEmpty()
	{
		return size() < 1;	
	}
	
	//Returns the Dictionary object to an empty state.
	public void clear()
	{
		currentSize = 0;
		
		// Just create a new array of ordered lists
		// Java will garbage collect the old one
		list = new OrderedList[maxSize];
		
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
		OrderedList<Node<K,V>> orderedList;
		int listSize = 0;
		int iterIndex = 0;

		public KeyIteratorHelper() {
			orderedList = new OrderedList();
						
			// Load up the ordered list
			for (int i = 0; i < currentSize; i++)
			{
				if (null != list[i])
				{
					Iterator<Node<K,V>> iterator = list[i].iterator();
					for(; iterator.hasNext(); )
					{
						orderedList.insert(iterator.next());
					}
				}
			}
			
			listSize = orderedList.size();
		}

		public boolean hasNext() {
			return iterIndex < listSize;
		}

		public K next() {

			if (!hasNext())
				throw new NoSuchElementException();
			
			// Fast-Fail if the HashTable has changed
			if (orderedList.size() != currentSize)
				throw new NoSuchElementException();

			iterIndex++;
			return (K) orderedList.remove().getKey();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	//Added this inner class to support the iterator method for the values
	// The values must match the order of the keys so just get the keys
	// iterator and return the value for each next() key
	private class ValueIteratorHelper implements Iterator<V> {
		private Iterator<K> k;

		public ValueIteratorHelper() {
			k = keys();
		}

		@Override
		public boolean hasNext()
		{
			return k.hasNext();
		}

		public V next()
		{
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return getValue(k.next());
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}	

	private class Node<K,V> implements Comparable<Node<K,V>> {
		private K key;
		private V value;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
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
		public int compareTo(Node<K, V> node)
		{
			return ((Comparable<K>) key).compareTo(node.key);
		}
		public String toString()
		{
			return "key: " + key + " value: " + value;
		}
	}
}
