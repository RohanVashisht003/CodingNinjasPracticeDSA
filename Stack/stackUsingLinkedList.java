package Stack;

import LinkedList.Node;

public class stackUsingLinkedList<T> {

	private Node<T> head;
	private int size = 0;

	public void push(T item) {
		Node<T> nn = new Node<T>(item);
		nn.next = head;
		head = nn;
		size++;
	}

	public T pop() throws StackEmptyException {
		if (head == null) {
			throw new StackEmptyException();
		}
		T poppedElement = head.data;
		head = head.next;
		size--;
		return poppedElement;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public T top() throws StackEmptyException {
//		stack empty exception
		if (head == null) {
			throw new StackEmptyException();
		}
		return head.data;
	}

	public int size() {
		return size;
	}

}
