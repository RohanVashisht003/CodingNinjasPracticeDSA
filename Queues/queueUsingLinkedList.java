package Queues;

import LinkedList.Node;

public class queueUsingLinkedList<T> {

	private int size;
	private Node<T> head;
	private Node<T> front;
	private Node<T> rear;

	public void enqueue(T item) {
		Node<T> nn = new Node<>(item);
		if (size == 0) {
			head = nn;
			front = head;
			rear = head;
		} else {
			rear.next = nn;
			rear = nn;
		}
		size++;
	}

	public T dequeue() {
		T deletedData = front.data;
		head = head.next;
		front = head;
		if (front == null) {
			rear = null;
		}
		size--;
		return deletedData;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public T front() throws queueEmptyException {
		if (size == 0) {
			throw new queueEmptyException();
		}
		return front.data;
	}
}
