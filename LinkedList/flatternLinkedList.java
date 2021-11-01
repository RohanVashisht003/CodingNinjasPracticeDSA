package LinkedList;

import java.util.*;

class LinkedListNodeModi<T> {
	T data;
	LinkedListNodeModi<T> right;
	LinkedListNodeModi<T> down;

	LinkedListNodeModi(T data) {
		this.data = data;
		this.right = null;
		this.down = null;
	}
}

public class flatternLinkedList {

	public static LinkedListNodeModi<Integer> merging(LinkedListNodeModi<Integer> a, LinkedListNodeModi<Integer> b) {
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}

		LinkedListNodeModi<Integer> temp;
		if (a.data < b.data) {
			temp = a;
			temp.down = merging(a.down, b);
		} else {
			temp = b;
			temp.down = merging(a, b.down);
		}
		temp.right = null;
		return temp;
	}

	public static LinkedListNodeModi<Integer> flat(LinkedListNodeModi<Integer> head) {
		if (head == null || head.right == null) {
			return head;
		}

//		recur towards right
		head.right = flat(head.right);

//		merging
		LinkedListNodeModi<Integer> root = merging(head, head.right);
		return root;
	}

	public static void printList(LinkedListNodeModi<Integer> head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.down;
		}

		System.out.println();
		return;
	}

	public static LinkedListNodeModi<Integer> takeInput(Scanner s) {
		int data = s.nextInt();

		LinkedListNodeModi<Integer> head = null;
		LinkedListNodeModi<Integer> tail = null;
		LinkedListNodeModi<Integer> headd = null;
		LinkedListNodeModi<Integer> taild = tail;

		while (data != -1) {
			LinkedListNodeModi<Integer> newNode = new LinkedListNodeModi<>(data);
			headd = null;
			if (head == null) {
				head = newNode;
				tail = newNode;
				taild = tail;
			} else {
				tail.right = newNode;
				tail = tail.right;
				taild = tail;
			}

			while (data != -1) {
				if (headd == null) {
					headd = newNode;
				} else {
					newNode = new LinkedListNodeModi<>(data);
					taild.down = newNode;
					taild = taild.down;
				}
				data = s.nextInt();
			}
			data = s.nextInt();
		}
		return head;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		LinkedListNodeModi<Integer> head = takeInput(s);
		head = flat(head);
		printList(head);
	}
}
