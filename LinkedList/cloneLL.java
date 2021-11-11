package LinkedList;

import java.util.*;

class Node3<T> {
	T data;
	Node3<T> next;
	Node3<T> arb;

	Node3(T data) {
		this.data = data;
		this.next = null;
		this.arb = null;
	}
}

public class cloneLL {
	public static Node3<Integer> clone(Node3<Integer> head) {
		HashMap<Node3<Integer>, Node3<Integer>> map = new HashMap<>();
		Node3<Integer> curr = head;
		Node3<Integer> nHead = new Node3<Integer>(-1);
		Node3<Integer> prev = nHead;

		while (curr != null) {
			Node3<Integer> nn = new Node3<Integer>(curr.data);
			prev.next = nn;
			map.put(curr, nn);

			prev = prev.next;
			curr = curr.next;
		}
		nHead = nHead.next;
		Node3<Integer> c1 = head;
		Node3<Integer> c2 = nHead;
		while (c1 != null) {
			c2.arb = (c1.arb != null ? map.get(c1.arb) : null);
			c1 = c1.next;
			c2 = c2.next;
		}
		return nHead;
	}

	private static Node3<Integer> takeInput(int n, Scanner s) {
		int count = 1;
		int data = s.nextInt();

		Node3<Integer> head = null;
		Node3<Integer> tail = null;

		Node3<Integer> newNode = new Node3<>(data);

		head = newNode;
		tail = newNode;

		while (count < n) {
			data = s.nextInt();
			newNode = new Node3<>(data);

			tail.next = newNode;
			tail = newNode;

			count += 1;
		}

		return head;
	}

	public static boolean validate(Node3<Integer> head, Node3<Integer> result) {
		if (head == result) {
			return false;
		}

		Node3<Integer> temp1 = head;
		Node3<Integer> temp2 = result;

		int length1 = 0, length2 = 0;

		while (temp1 != null) {
			length1++;
			temp1 = temp1.next;
		}
		while (temp2 != null) {
			length2++;
			temp2 = temp2.next;
		}
		if (length1 != length2) {
			return false;
		}

		temp1 = head;
		temp2 = result;
		while (temp1 != null) {
			if (temp1.data != temp2.data) {
				return false;
			}

			if (temp1.arb != null && temp2.arb != null) {
				if (temp1.arb.data != temp2.arb.data) {
					return false;
				}
			} else if (temp1.arb != null && temp2.arb == null) {
				return false;
			} else if (temp1.arb == null && temp2.arb != null) {
				return false;
			}

			temp1 = temp1.next;
			temp2 = temp2.next;
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int m = s.nextInt();

		Node3<Integer> head = takeInput(n, s);

		for (int i = 1; i <= m; i++) {
			int data1 = s.nextInt();
			int data2 = s.nextInt();

			Node3<Integer> tempa = head;
			int count = -1;
			while (tempa != null) {
				count++;
				if (count == data1 - 1) {
					break;
				}

				tempa = tempa.next;
			}

			Node3<Integer> tempb = head;
			count = -1;
			while (tempb != null) {
				count++;
				if (count == data2 - 1) {
					break;
				}

				tempb = tempb.next;
			}

			if (data1 <= n) {
				tempa.arb = tempb;
			}
		}

		Node3<Integer> result = clone(head);

		if (validate(head, result)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

		s.close();
	}

}
