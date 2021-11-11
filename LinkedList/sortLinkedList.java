package LinkedList;

import java.util.*;

public class sortLinkedList {

	public static DoublyLinkedListNode<Integer> merging(DoublyLinkedListNode<Integer> head1, DoublyLinkedListNode<Integer> head2) {
	
		}

	public static DoublyLinkedListNode<Integer> sorting(DoublyLinkedListNode<Integer> head) {
		
	}

	public static DoublyLinkedListNode<Integer> takeInput() {
		Scanner s = new Scanner(System.in);

		DoublyLinkedListNode<Integer> head = null;
		DoublyLinkedListNode<Integer> tail = null;

		int data = s.nextInt();

		while (data != -1) {
			DoublyLinkedListNode<Integer> newNode = new DoublyLinkedListNode<>(data);
			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
			}

			data = s.nextInt();
		}

		return head;
	}

	public static void printList(DoublyLinkedListNode<Integer> head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		DoublyLinkedListNode<Integer> head = takeInput();
		printList(sorting(head));
	}

}
