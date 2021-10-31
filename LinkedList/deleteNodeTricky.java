package LinkedList;

import java.util.*;

//class LinkedListNode<T> {
//	T data;
//	LinkedListNode<T> next;
//
//	public LinkedListNode(T data) {
//		this.data = data;
//		this.next = null;
//	}
//}

public class deleteNodeTricky {

	public static void deleteNode(LinkedListNode<Integer> node) {
		node.data = node.next.data;
		node.next = node.next.next;
	}

	public static void printList(LinkedListNode<Integer> head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}

		System.out.println();
		return;
	}

	public static LinkedListNode<Integer> takeInput(Scanner s) {
		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> tail = null;

		int data = s.nextInt();

		while (data != -1) {
			LinkedListNode<Integer> newNode = new LinkedListNode<>(data);

			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = newNode;
			}
			data = s.nextInt();
		}
		return head;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		LinkedListNode<Integer> head = takeInput(s);
		int k = s.nextInt();

		LinkedListNode<Integer> temp = head;

		int count = 1;

		while (count < k) {
			temp = temp.next;
			count += 1;
		}

		deleteNode(temp);
		printList(head);

	}

}
