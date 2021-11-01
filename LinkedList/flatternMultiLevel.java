package LinkedList;

import java.util.*;

class Node2 {
	int data;
	Node2 next;
	Node2 down;

	public Node2(int data, Node2 next, Node2 down) {
		this.data = data;
		this.next = next;
		this.down = down;
	}
}

public class flatternMultiLevel {

	static Node2 head;
	static Node2 tail;
	static int size;

	public static void flattenListCorrect(Node2 hp) {

		if (hp == null) {
			return;
		}
		Node2 temp = hp;

		Node2 tail = hp;
		while (tail.next != null) {
			tail = tail.next;
		}
		Node2 curr = hp;
		while (curr != tail) {
			if (curr.down != null) {
				tail.next = curr.down;
				temp = curr.down;
				tail = temp;
				while (tail.next != null) {
					tail = tail.next;
				}
			}
			curr = curr.next;
		}
	}

	private static Node2 insertbelow(Scanner scn) {
		Node2 np = null;
		np = new Node2(scn.nextInt(), null, null);
		// Do you have down child
		char choice = scn.next().charAt(0);
		if (choice == 'Y' || choice == 'y') {
			// create a Node2 and then call

			np.down = insertbelow(scn);
		}
		// do you have right child
		choice = scn.next().charAt(0);
		if (choice == 'Y' || choice == 'y') {
			// create a Node2 and then call
			np.next = insertbelow(scn);

		}
		return np;
	}

	private static Node2 insert(int data) {
		Node2 nn = new Node2(data, null, null);
		if (head == null) {
			head = nn;
			tail = nn;
		} else {
			tail.next = nn;
			tail = nn;
		}
		return nn;

	}

	public static void display(Node2 n) {
		for (Node2 Node2 = n; Node2 != null; Node2 = Node2.next) {
			System.out.print(Node2.data + " ");
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		// This is for the main linked list of size n
		for (int i = 0; i < n; i++) {
			int a = scn.nextInt();
			Node2 np = insert(a);
			// do you have down child
			char choice = scn.next().charAt(0);
			if (choice == 'Y' || choice == 'y') {
				// make recursive calls with np
				np.down = insertbelow(scn);
			} else {
				continue;
			}
		}
		flattenListCorrect(head);
		display(head);

	}
}
