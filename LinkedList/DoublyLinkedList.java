package LinkedList;

import java.util.Scanner;

import Hashmaps.removeDuplicates;

class DoublyLinkedList {

	private class DoublyLinkedListNode<T> {

		T data;
		DoublyLinkedListNode<T> prev;
		DoublyLinkedListNode<T> next;

		public DoublyLinkedListNode(T data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	private DoublyLinkedListNode<Integer> head;
	private DoublyLinkedListNode<Integer> tail;
	private int size;

	public int size() {
		return this.size;
	}

//	*********************************Adding Data****************************
	public void takeInput() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter data for Node");
		int data = s.nextInt();

		while (data != -1) {
			DoublyLinkedListNode<Integer> newNode = new DoublyLinkedListNode<>(data);
			this.size++;
			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
			}
			System.out.println("Enter data for Node");
			data = s.nextInt();
		}
	}

	private void addFirstWorking(int data) {
		DoublyLinkedListNode<Integer> newNode = new DoublyLinkedListNode<Integer>(data);
		if (size() == 0) {
			head=tail= newNode;
		} else {
			
			newNode.next = head;
			head.prev = newNode;
			head = head.prev;
			size++;
		}
	}

	public void addFirst(int data) {
		addFirstWorking(data);
	}

	private void addAtWorking(int pos, int data) {
		if (pos != -1) {
			DoublyLinkedListNode<Integer> newNode = new DoublyLinkedListNode<Integer>(data);
			int count = 0;
			DoublyLinkedListNode<Integer> forwardNode = head;
			DoublyLinkedListNode<Integer> backwardNode = head.prev;
			while (count != pos) {
				forwardNode = forwardNode.next;
				count++;
			}
//		linking with backward
			backwardNode.next = newNode;
			newNode.prev = backwardNode;
//		linking with forward
			newNode.next = forwardNode;
			forwardNode.prev = newNode;
			size++;
		}
	}

	public void addAt(int pos, int data) {
		if (pos == 0) {
			addFirst(data);
		} else if (pos < 0 || size() == 0 || pos > size()) {
			LinkedListInvalidIndex();
		} else if (pos == size()) {
			addLast(data);
		} else {
			addAtWorking(pos, data);
		}

	}

	private void addLastWorking(int data) {
		if (size() == 0) {
			LinkedListInvalidIndex();
		} else {
			DoublyLinkedListNode<Integer> newNode = new DoublyLinkedListNode<Integer>(data);
			tail.next = newNode;
			newNode.prev = tail;
			tail = tail.next;
			size++;
		}
	}

	public void addLast(int data) {
		addLastWorking(data);
	}

	// *********************************Printing****************************
	private void printing() {
		DoublyLinkedListNode<Integer> temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public void print() {
		printing();
	}

//	*********************************Removing Data****************************
	private int removeFirstWorking() {
		int removedData = head.data;
		if (size == 1) {
			tail = head = null;
		} else {
			head = head.next;
			head.prev = null;
		}
		size--;
		return removedData;
	}

	public int removedFirst() {
		if (size == 0) {
			LinkedListEmptyException();
			return -1;
		}
		return removeFirstWorking();
	}

	private int removingAtWorking(int pos) {
		DoublyLinkedListNode<Integer> gotNode = getAtWorking(pos);
		DoublyLinkedListNode<Integer> backwardNode = gotNode.prev;
		DoublyLinkedListNode<Integer> forwardNode = gotNode.next;
		backwardNode.next = forwardNode;
		forwardNode.prev = backwardNode;
		gotNode.prev = null;
		gotNode.prev = null;
		return gotNode.data;
	}

	public int removingAt(int pos) {
		if (size() == 0) {
			LinkedListEmptyException();
			return -1;
		} else if (pos == 0) {
			return removedFirst();
		} else if (pos == size() - 1) {
			return removedLast();
		} else {
			return removingAtWorking(pos);
		}
	}

	private int removingLast() {
		int removedData = tail.data;
		if (size == 1) {
			head = tail = null;
		} else {
			tail = tail.prev;
			tail.next.prev = null;
			tail.next = null;
		}
		size--;
		return removedData;
	}

	public int removedLast() {
		if (size == 0) {
			LinkedListEmptyException();
			return -1;
		}
		return removingLast();
	}

//	********************************* Get Functions ****************************

	private DoublyLinkedListNode<Integer> getFirstWorking() {
		return head;
	}

	public int getFirst() {
		if (size == 0) {
			LinkedListEmptyException();
			return -1;
		}
		DoublyLinkedListNode<Integer> getData = getFirstWorking();
		return getData.data;
	}

	private DoublyLinkedListNode<Integer> getLastWorking() {
		return tail;
	}

	public int getLast() {
		if (size == 0) {
			LinkedListEmptyException();
			return -1;
		}
		DoublyLinkedListNode<Integer> getData = getLastWorking();
		return getData.data;
	}

	private DoublyLinkedListNode<Integer> getAtWorking(int pos) {
		if (pos == 0) {
			return getFirstWorking();
		} else if (pos == size - 1) {
			return getLastWorking();
		} else {
			DoublyLinkedListNode<Integer> currentPos = head;
			int count = 0;
			while (count < pos) {
				currentPos = currentPos.next;
				count++;
			}
			return currentPos;
		}
	}

	public int getAt(int pos) {
		if (size() == 0) {
			LinkedListEmptyException();
			return -1;
		} else if (pos > size() - 1 || pos < 0) {
			LinkedListInvalidIndex();
			return -1;
		} else {
			DoublyLinkedListNode<Integer> removedData = getAtWorking(pos);
			return removedData.data;
		}
	}
//	********************************* Exceptions****************************

	private void LinkedListEmptyException() {
		System.out.println("LinkedList Is Empty");
	}

	private void LinkedListInvalidIndex() {
		System.out.println("Invalid Index");
	}
}
