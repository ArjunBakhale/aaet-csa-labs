import java.util.NoSuchElementException;

/**
 * LinkedList class
 * A implementation of a singly linked list data structure
 * with a head pointer.
 *
 * AP CS students: Implement all methods in this file
 */
public class doubleLinkedList<E> {

	/**
	 * Node class for the LinkedList
	 * Contains data and a reference to the next node
	 */
	private class Node {
		private E data;         // Data stored in this node
		private Node next;      // Reference to the next node in the list
		private Node prev;      // Reference to the previous node in the list

		/**
		 * Constructor for the Node class
		 * @param data The data to store in this node
		 */
		public Node(E data) {
			// Implement this constructor
			this.data = data;
			this.prev = null;
			this.next = null;
		}

		/**
		 * Constructor for the Node class
		 * @param data The data to store in this node
		 * @param next The reference to the next node
		 */
		public Node(E data, Node next) {
			// Implement this constructor
			this.data = data;
			this.next = next;
			this.prev = null;
		}

		public Node getNext (){
			return this.next;
		}

	}

	// Instance variables for the LinkedList
	private Node head;  // Reference to the first node in the list
	private Node tail;  // Reference to the last node in the list
	private int size;   // Number of elements in the list

	/**
	 * Default constructor for the LinkedList class
	 * Creates an empty list
	 */
	public doubleLinkedList() {
		// Implement this constructor
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	/**
	 * Returns the number of elements in the list
	 * @return The number of elements in the list
	 */
	public int size() {
		// Implement this method
		return this.size;
	}

	/**
	 * Checks if the list is empty
	 * @return true if the list is empty, false otherwise
	 */
	public boolean isEmpty() {
		// Implement this method
		if(this.size == 0){
			return true;
		}
		return false; // Placeholder return value
	}

	/**
	 * Returns the first element in the list without removing it
	 * @return The first element in the list
	 * @throws NoSuchElementException if the list is empty
	 */
	public E getFirst() {
		// Implement this method
		if(this.head == null){
			throw new NoSuchElementException("List is empty");
		}
		else {
			return this.head.data;
		}
	}

	/**
	 * Returns the last element in the list without removing it
	 * @return The last element in the list
	 * @throws NoSuchElementException if the list is empty
	 */
	public E getLast() {
		if(this.head == null){
			throw new NoSuchElementException("List is empty");
		}

		return this.tail.data;
	}

	/**
	 * Adds an element to the beginning of the list
	 * @param element The element to add
	 */
	public void addFirst(E element) {
		// Implement this method
		Node newNode = new Node(element);

		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			newNode.next = this.head;
			this.head.prev = newNode;
			this.head = newNode;
		}

		this.size += 1;
	}

	/**
	 * Adds an element to the end of the list
	 * @param element The element to add
	 */
	public void addLast(E element) {
		// Implement this method
		if(this.head == null){
			addFirst(element);
		}
		else {
			Node newNode = new Node(element);
			this.tail.next = newNode;
			newNode.prev = this.tail;
			this.tail = newNode;
			this.size++;
		}
	}

	/**
	 * Removes and returns the first element in the list
	 * @return The first element in the list
	 * @throws NoSuchElementException if the list is empty
	 */
	public E removeFirst() {
		// Implement this method
		if(this.head == null){
			throw new NoSuchElementException("List is empty");
		}

		E removedData = this.head.data;

		if (this.head == this.tail) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			this.head = this.head.next;
			this.head.prev = null;
			this.size--;
		}

		return removedData;
	}

	/**
	 * Removes and returns the last element in the list
	 * @return The last element in the list
	 * @throws NoSuchElementException if the list is empty
	 */
	public E removeLast() {
		// Implement this method
		if(this.head == null){
			throw new NoSuchElementException("List is empty");
		}

		E removedData = this.tail.data;

		if (this.head == this.tail) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			this.tail = this.tail.prev;
			this.tail.next = null;
			this.size--;
		}

		return removedData;
	}

	/**
	 * Adds an element at the specified index
	 * @param index The index at which to add the element
	 * @param element The element to add
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public void add(int index, E element) {
		// Implement this method
		if(index == 0){
			addFirst(element);
		}
		else if (this.size == index){
			addLast(element);
		}
		else if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		else {
			Node newNode = new Node(element);
			Node current;

			// Determine if it's faster to traverse from head or tail
			if (index < size / 2) {
				current = this.head;
				for (int i = 0; i < index; i++) {
					current = current.next;
				}
				newNode.next = current;
				newNode.prev = current.prev;
				current.prev.next = newNode;
				current.prev = newNode;
			} else {
				current = this.tail;
				for (int i = size - 1; i > index; i--) {
					current = current.prev;
				}
				newNode.next = current;
				newNode.prev = current.prev;
				current.prev.next = newNode;
				current.prev = newNode;
			}

			this.size++;
		}
	}

	/**
	 * Returns the element at the specified index without removing it
	 * @param index The index of the element to return
	 * @return The element at the specified index
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public E get(int index) {
		// Implement this method
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}

		Node current;

		// Determine if it's faster to traverse from head or tail
		if (index < size / 2) {
			current = this.head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
		} else {
			current = this.tail;
			for (int i = size - 1; i > index; i--) {
				current = current.prev;
			}
		}

		return current.data;
	}

	/**
	 * Removes and returns the element at the specified index
	 * @param index The index of the element to remove
	 * @return The element at the specified index
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}

		if (index == 0) {
			return removeFirst();
		}

		if (index == size - 1) {
			return removeLast();
		}

		Node current;

		// Determine if it's faster to traverse from head or tail
		if (index < size / 2) {
			current = this.head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
		} else {
			current = this.tail;
			for (int i = size - 1; i > index; i--) {
				current = current.prev;
			}
		}

		E removedData = current.data;
		current.prev.next = current.next;
		current.next.prev = current.prev;
		size--;

		return removedData;
	}

	/**
	 * Returns the index of the first occurrence of the specified element
	 * @param element The element to search for
	 * @return The index of the first occurrence of the element, or -1 if not found
	 */
	public int indexOf(E element) {
		// Check if the list is empty
		if (head == null) {
			return -1;
		}

		int currentIndex = 0;
		Node currentNode = this.head;

		// Loop until we reach the end of the list
		while (currentNode != null) {
			// Use equals() for content comparison (handles null element case)
			if (element == null ? currentNode.data == null : element.equals(currentNode.data)) {
				return currentIndex;
			}
			currentIndex++;
			currentNode = currentNode.next;
		}

		// Element not found
		return -1;
	}

	/**
	 * Checks if the list contains the specified element
	 * @param element The element to search for
	 * @return true if the list contains the element, false otherwise
	 */
	public boolean contains(E element) {
		if (head == null) {
			return false;
		}

		Node currentNode = this.head;
		while (currentNode != null) {
			if (element == null ? currentNode.data == null : element.equals(currentNode.data)) {
				return true;
			}
			currentNode = currentNode.next;
		}
		return false;
	}
	/**
	 * Returns a string representation of the list
	 * @return A string representation of the list
	 */
	@Override
	public String toString() {
		String output = "[";
		if (head == null) {
			output += "]";
		} else {
			Node currentNode = this.head;
			while (currentNode != null) {
				output += currentNode.data;
				if (currentNode.next != null) {
					output += ", ";
				} else {
					output += "]";
				}
				currentNode = currentNode.next;
			}
		}
		return output;
	}

	/**
	 * Clears the list, removing all elements
	 */
	public void clear() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	/**
	 * Extra challenge: Reverses the list in place
	 */
	public void reverse() {
		// Implement this method (optional challenge)
		if (head == null || head == tail) {
			return;
		}

		Node current = head;
		Node temp = null;

		// Swap next and prev for all nodes
		while (current != null) {
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}

		// Swap head and tail
		temp = head;
		head = tail;
		tail = temp;
	}
}