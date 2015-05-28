package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OrderedList<E> implements Iterable<E> {
	private int currentSize;
	private Node<E> head;
	private Node<E> tail;

	
	// Inserts a new object into the priority queue. Returns true if
	// the insertion is successful. If the PQ is full, the insertion
	// is aborted, and the method returns false.
	public boolean insert(E object) {
		boolean inserted = false;

		
		Node<E> current = head;
		Node<E> previous = head;
		Node<E> newNode = new Node<E>(object);
		boolean insertBefore = false;
		boolean insertBetween = false;
		int comparisons = 0;
		
		while (current != null)
		{				
			if (((Comparable<E>)object).compareTo(current.getData()) >= 0)
			{	
				previous = current;
				current = current.getNext();
				comparisons++;
			}
			else
			{
				if (comparisons == 0)
					insertBefore = true;
				else
					insertBetween = true;
				break;
			}
		}
		
		if (head == null)
		{
			head = newNode;
			tail = head;
			inserted = true;
			currentSize++;
		}
		else if (insertBefore)
		{
			newNode.setNext(current);
			head =newNode;
			inserted = true;
			currentSize++;
		} else if (insertBetween)
		{
			previous.setNext(newNode);
			newNode.setNext(current);
			currentSize++;
		} else if (previous == tail)
		{
			tail.setNext(newNode);
			tail = newNode;
			currentSize++;
		} else
		{
			head.setNext(newNode);
			currentSize++;
		}
		
				
		return inserted;
	}

	public E getFirst() {
		if (head != null)
			return head.getData();
		else
			return null;
	}

	public E removeLast() {
		E object = null;

		if (!isEmpty()) {
			Node<E> current = head;
			Node<E> previous = head;
			while (current.getNext() != null) {
				current = current.getNext();
				if (current.getNext() != null) {
					previous = current;
				}
			}
			previous.setNext(null);
			object = current.getData();
			currentSize--;
			if (current == head) {
				head = null;
				tail = null;
			}
		}

		return object;
	}

	public void debug() {
		System.out.println("Size: " + currentSize);

		Node<E> current = head;
		while (current != null) {
			System.out.print(current.getData());
			current = current.getNext();
		}
		System.out.println();
	}

	@SuppressWarnings("unchecked")
	// Removes the object of highest priority that has been in the
	// PQ the longest, and returns it. Returns null if the PQ is empty.
	public E remove() {
		E min = null;
		Node<E> current = head;

		if (!isEmpty()) {
			min = head.getData();
			head = head.getNext();
			current.setNext(null);
			if (head == null)
				tail = null;
		}

		return min;
	}

	// Removes the object of highest priority that has been in the
	// PQ the longest, and returns it. Returns null if the PQ is empty.
	public E remove(E obj) {
		E min = null;

		if (!isEmpty()) {
			Node<E> current = head;
			Node<E> previous = head;

			while (current != null) {
				if (((Comparable<E>) current.getData()).compareTo(obj) != 0) {
					previous = current;
					current = current.getNext();
				} else
					break;
			}

			if (current != null) {
				if (current == head)
					head = current.getNext();

				previous.setNext(current.getNext());
				current.setNext(null);
				min = current.getData();

				currentSize--;
				if (currentSize == 0) {
					head = null;
					tail = null;
				}
			}
		}

		return min;
	}

	public E find(E obj) {
		E min = null;

		if (!isEmpty()) {
			Node<E> current = head;

			while (current != null) {
				if (((Comparable<E>) obj).compareTo(current.getData()) == 0) {
					min = current.getData();
					break;
				}
				current = current.getNext();
			}
		}

		return min;
	}

	// Returns the object of highest priority that has been in the
	// PQ the longest, but does NOT remove it.
	// Returns null if the PQ is empty.
	public E peek() {
		E min = this.getFirst();
		for (E data : this) {
			if (((Comparable<E>) data).compareTo(min) < 0) {
				min = data;
			}
		}

		return min;
	}

	// Returns true if the priority queue contains the specified element
	public boolean contains(E obj) {
		boolean found = false;

		if (!isEmpty()) {
			Node<E> current = head;

			while (current != null) {
				if (((Comparable<E>) obj).compareTo(current.getData()) == 0) {
					found = true;
					break;
				}
				current = current.getNext();
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
		head = null;
	}

	// Returns true if the PQ is empty, otherwise false
	public boolean isEmpty() {
		// Returns true if the list is empty, otherwise false
		return (head == null);
	}

	// Returns true if the PQ is full, otherwise false. List based
	// implementations should always return false.
	public boolean isFull() {
		return false;
	}

	// Returns an iterator of the objects in the PQ, in no particular
	// order.
	public Iterator<E> iterator() {
		return new IteratorHelper();
	}

	// Added this inner class to support the iterator method+
	private class IteratorHelper implements Iterator<E> {
		Node<E> iterNode;

		public IteratorHelper() {
			iterNode = head;
		}

		public boolean hasNext() {
			boolean foundOne = false;

			if (iterNode != null) {
				foundOne = true;
			}

			return foundOne;
		}

		public E next() {
			Node<E> object;

			if (!hasNext())
				throw new NoSuchElementException();

			object = iterNode;
			iterNode = iterNode.getNext();

			return (E) (object.getData());
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	public class Node<E> {
		private E data;
		private Node<E> next;
		
		public Node(E data) {
			this.data = data;
			next = null;
		}
		
		public E getData() {
			return data;
		}

		public void setData(E data) {
			this.data = data;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}	
	}	
}
