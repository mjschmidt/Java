package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnorderedArrayPriorityQueue<E> implements PriorityQueue<E> {

	private int currentSize, maxSize;
	private E[] storage;

	// Default constructor. Creates storage for DEFAULT_MAX_CAPACITY
	// objects.
	public UnorderedArrayPriorityQueue() {
		currentSize = 0;
		maxSize = DEFAULT_MAX_CAPACITY;
		storage = (E[]) new Object[maxSize];
	}

	// Constructor where user of this class may pass in the
	// number of objects to be stored
	public UnorderedArrayPriorityQueue(int maxSize) {
		currentSize = 0;
		this.maxSize = maxSize;
		storage = (E[]) new Object[this.maxSize];
	}
	
	private void debug()
	{
		System.out.println("currentSize: " + currentSize);
		for (int i = 0; i <= currentSize - 1; i++) {
			System.out.print(storage[i] + " ");
		}
		System.out.println();	
	}

	// Inserts a new object into the priority queue. Returns true if
	// the insertion is successful. If the PQ is full, the insertion
	// is aborted, and the method returns false.
	public boolean insert(E object) {
		boolean inserted = false;

		if (currentSize < maxSize)
		{
			storage[currentSize++] = object;
			inserted = true;
		}
		else
		{
			inserted = false;
		}

//System.out.println("After insert: ");
//debug();		
		return inserted;
	}

	@SuppressWarnings("unchecked")	
	// Removes the object of highest priority that has been in the
	// PQ the longest, and returns it. Returns null if the PQ is empty.
	public E remove() {
		E object = null;

		if (currentSize > 0) {
			object = storage[0];
			if (currentSize != 1) {
				int idxPosition = 0;
				for (int i = 1; i < currentSize; i++) {
					int comp = ((Comparable<E>) object).compareTo(storage[i]);

					if (comp > 0) {
						object = storage[i];
						idxPosition = i;
					}
				}

				for (int i = idxPosition; i < currentSize - 1; i++) {
					storage[i] = storage[i + 1];
				}
				storage[currentSize--] = null;
			} else {
				storage[0] = null;
				currentSize--;
			}
		}

//System.out.println("After removal: ");
//debug();
		
		return object;
	}

	// Returns the object of highest priority that has been in the
	// PQ the longest, but does NOT remove it.
	// Returns null if the PQ is empty.
	public E peek() {
		E object = null;
		
		if (currentSize > 0) {
			object = storage[0];
			if (currentSize != 1) {
				int idxPosition = 0;
				for (int i = 1; i < currentSize; i++) {
					int comp = ((Comparable<E>) object).compareTo(storage[i]);

					if (comp > 0) {
						object = storage[i];
						idxPosition = i;
					}
				}
			} 
		}

//System.out.println("After removal: ");
//debug();
		
		return object;
	}

	// Returns true if the priority queue contains the specified element
	public boolean contains(E obj) {
		boolean found = false;
		
		for (int i = 0; i < currentSize - 1; i++)
		{
			int comp = ((Comparable<E>) obj).compareTo(storage[i]);
			
			if (comp == 0) {
				found = true;
				break;
			}			
		}

		return found;
	}

	// Returns the number of objects currently in the PQ.
	public int size() {
		// Returns the number of Objects currently in the list.
		return currentSize;
	}

	// Returns the PQ to an empty state.
	public void clear() {
		
		for (int i = currentSize-1; i >=0; i--)
		{
			storage[i] = null;
			currentSize--;
		}
	}

	// Returns true if the PQ is empty, otherwise false
	public boolean isEmpty() {
		// Returns true if the list is empty, otherwise false
		return (currentSize == 0);
	}

	// Returns true if the PQ is full, otherwise false. List based
	// implementations should always return false.
	public boolean isFull() {
		return (currentSize == maxSize);
	}

	// Returns an iterator of the objects in the PQ, in no particular
	// order.
	public Iterator<E> iterator() {
		return new IteratorHelper();
	}

	// Added this inner class to support the iterator method+
	private class IteratorHelper implements Iterator<E> {
		int iterIndex;

		public IteratorHelper() {
			iterIndex = 0;
		}

		public boolean hasNext() {
			return iterIndex < currentSize;
		}

		public E next() {

			if (!hasNext())
				throw new NoSuchElementException();

			return storage[iterIndex++];
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
