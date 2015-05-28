/*  Mark Rassamni masc1530 */

package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OrderedVector<E> implements OrderedListADT<E> {
	
	private int currentSize, maxSize;
	private E[] storage;

	public OrderedVector() {
		currentSize = 0;
		maxSize = DEFAULT_MAX_CAPACITY;
		storage = (E[]) new Object[maxSize];
	}

	private int binSearchNoRecursion(E obj, int lo, int hi) {
		int mid;
		
		while (hi >= lo)
		{
			mid = (lo + hi) / 2;
			int comp = ((Comparable<E>) obj).compareTo(storage[mid]);
			
			if (comp < 0)
				hi = mid - 1;	// go left
			else if (comp > 0)
				lo = mid + 1; // go right
			else // comp must have been 0
				return mid;	// found
		}
		
		return -1; // not found
	}
	
	private int binSearchInsert(E obj, int lo, int hi) {
		System.out.println("Entering binSearchInsert with: hi " + hi + " and lo " + lo);
		if (hi < lo) {
			System.out.println("Returning lo " + lo);
			return lo; // if hi is less than lo return lo
		}

		System.out.println("lo plus hi is " + lo + hi);
		int mid = (lo + hi) >> 1;
		System.out.println("mid (shifted right) is " + mid);

		int comp = ((Comparable<E>) obj).compareTo(storage[mid]);
		System.out.println("comp is " + comp);
		
		if (comp < 0) {
			System.out.println("Go left - recurse with lo " + lo + " and hi " + (mid -1));
			return binSearchInsert(obj, lo, mid - 1);  // go left
		}
		System.out.println("Go right - recurse with lo " + lo + " and hi " + (mid -1));
		return binSearchInsert(obj, mid + 1, hi); // go right
	}

	private int binSearchRemove(E obj, int lo, int hi) {
		if (hi < lo) { // if hi is less than lo return -1
			return -1;
		}
		int mid = (lo + hi) >> 1;

		int comp = ((Comparable<E>) obj).compareTo(storage[mid]);
		if (comp == 0) {
			return mid;
		}
		if (comp < 0) {
			return binSearchRemove(obj, lo, mid - 1);
		}
		return binSearchRemove(obj, mid + 1, hi);
	}
	
	public void insert(E obj) {
		// Adds the Object obj to the list in the correct position as determined by
		// the Comparable interface.
		
//System.out.println("The actual class used is: " + obj.getClass().getName());		
		
		// Check to see if currentSize has gotten to our maximum size	
		if (currentSize >= maxSize) {

			// New memory 2 times the size of the current maxSize
			// being allocated
			E[] increasedStorage = (E[]) new Object[maxSize * 2];

			// Copy the current "storage" array into the new array
			for (int i = 0; i < currentSize; i++)
				increasedStorage[i] = storage[i];
			
			// Make our storage array now "point" at the new memory
			// the old memory will be garbage collected since it has
			// no references to it whenever java decides to do it
			storage = increasedStorage;
			
			
			// make maxSize double itself so we know our new max size of the array
			maxSize = maxSize * 2;
		}
		
		int idxPosition = binSearchInsert(obj, 0, currentSize - 1);
		for (int i = currentSize; i > idxPosition; i--) {
			// i starts at currentsize, as long as i is bigger than
			// idxPosition the loop executes then i goes down 1
			storage[i] = storage[i - 1];
		}
		System.out.println("After shifting storage: ");
		for (int i =0; i <= currentSize; i++)
		{
			System.out.print(storage[i] + " ");
		}
		System.out.println();

		storage[idxPosition] = obj;
		System.out.println("After putting into storage: ");
		for (int i =0; i <= currentSize; i++)
		{
			System.out.print(storage[i] + " ");
		}
		System.out.println();		
		currentSize++;				
}

	public E remove(int index) {
		// Removes the object located at the parameter index position (zero
		// based).
		// Throws IndexOutOfBoundsException if the index does not map to a valid
		// position within the list.

		
/*
		if (index < 0)
			throw new IndexOutOfBoundsException();

		if (index >= currentSize)
			throw new IndexOutOfBoundsException();

		// if the currentSize is less than maxSize / 4
		// we are assuming
		if (currentSize < maxSize / 4) {

			E[] decreasedStorage = (E[]) new Object[maxSize / 2];

			for (int i = 0; i < currentSize; i++)
				decreasedStorage[i] = storage[i];

			storage = decreasedStorage;
			maxSize = (maxSize / 2);
		}
		E temp = storage[index];

		for (int i = index; i < currentSize - 1; i++) {
			storage[i] = storage[i + 1];
		}
		currentSize--;
		return temp;
*/
		
		if ( (index < 0) || (index >= currentSize) )
			throw new IndexOutOfBoundsException();

		// if the currentSize is less than maxSize / 4
		// we are assuming
		if (currentSize < maxSize / 4) {

			E[] decreasedStorage = (E[]) new Object[maxSize / 2];

			for (int i = 0; i < currentSize; i++)
				decreasedStorage[i] = storage[i];

			storage = decreasedStorage;
			maxSize = (maxSize / 2);
		}
		E temp = storage[index];

		for (int i = index; i < currentSize - 1; i++) {
			storage[i] = storage[i + 1];
		}
		currentSize--;
		return temp;		

	}
	
	public E remove(E obj) {// Removes and returns the parameter object obj from the list if the list
		// contains it, null otherwise.
		
		int indexPos = binSearchRemove(obj, 0, currentSize - 1);
		if (indexPos == -1)					
			return null;
		return remove(indexPos);		
}
	public E get(int index) {
		//Returns the parameter object located at the parameter
		//index position (zero based).
		//Throws IndexOutOfBoundsException if the index does not 
		//map to a valid position within the underlying array
		
		if (index < 0)
			throw new IndexOutOfBoundsException();
		
		if (index >= currentSize)					
			throw new IndexOutOfBoundsException();
		
		return storage[index];
	}

	
	public E get(E obj) {
		// Returns the parameter object obj from the list if the list contains it,
		// null otherwise.
		
		int idxPosition = binSearchRemove(obj, 0, currentSize - 1);
		
		//int idxPosition = binSearchNoRecursion(obj, 0, currentSize - 1);
				
		if (idxPosition == -1)										
			return null;
		
		return get(idxPosition);
	}

	public boolean contains(E obj) {
		// Returns true if the parameter object obj is in the list, false otherwise.
		
		int indexpos = binSearchRemove(obj, 0, currentSize - 1);		
		
		if (indexpos == -1)
			return false;	
		
		return true;		
}

	
	@SuppressWarnings("unchecked")
	public void clear() {
		// The list is returned to an empty state.
		currentSize = 0;
		maxSize = DEFAULT_MAX_CAPACITY;			
		storage = (E[]) new Object[maxSize];

	}

	
	public boolean isEmpty() {	
		// Returns true if the list is empty, otherwise false
		return (currentSize == 0);

	}

	
	public int size() {		
		// Returns the number of Objects currently in the list.
		return currentSize;
	}

	public Iterator<E> iterator() {
		// Returns an Iterator of the values in the list, presented in
		// the same order as the list.
		return new IteratorHelper();
	}
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
