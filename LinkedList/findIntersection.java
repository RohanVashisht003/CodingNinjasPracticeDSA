package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class findIntersection {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static int length(LinkedListNode<Integer> node) {
		LinkedListNode<Integer> temp = node;
		int count = 0;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}

	public static int findIntersection2(LinkedListNode<Integer> firstHead, LinkedListNode<Integer> secondHead) {
		int len1 = length(firstHead);
		int len2 = length(secondHead);
		int diff = 0;
		LinkedListNode<Integer> temp1;
		LinkedListNode<Integer> temp2;
		if (len1 > len2) {
			diff = len1 - len2;
			temp1 = firstHead;
			temp2 = secondHead;
		} else {
			diff = len2 - len1;
			temp1 = secondHead;
			temp2 = firstHead;
		}

		int count = 0;
		while (count != diff) {
			temp1 = temp1.next;
			count++;
		}
		int data = 0;
		while (temp1 != null) {
			if (temp1 == temp2) {
				data = temp1.data;
				return data;
			}
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		return -1;
	}

	public static LinkedListNode<Integer> takeInput() throws IOException {
		LinkedListNode<Integer> head = null, tail = null;

		String[] datas = br.readLine().trim().split("\\s");

		int i = 0;
		while (i < datas.length && !datas[i].equals("-1")) {
			int data = Integer.parseInt(datas[i]);
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = newNode;
			}
			i += 1;
		}

		return head;
	}

	public static void attach(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {

		LinkedListNode<Integer> temp1 = head1;
		while (temp1 != null && temp1.next != null) {
			temp1 = temp1.next;
		}
		LinkedListNode<Integer> temp2 = head2;
		LinkedListNode<Integer> prev = null;

		while (temp2.next != null) {
			prev = temp2;
			temp2 = temp2.next;
		}
		if (prev == null) {
			if (temp1.data.equals(head2.data))
				temp1.next = head2;
		} else {
			if (temp2.data.equals(temp1.data))
				prev.next = temp1;
		}
	}

	public static void main(String[] args) throws IOException {

		LinkedListNode<Integer> head1 = takeInput();
		LinkedListNode<Integer> head2 = takeInput();
		LinkedListNode<Integer> head3 = takeInput();

		LinkedListNode<Integer> temp = head1;
		while (temp != null) {
			temp = temp.next;
		}

		if (head1 != null && head2 != null)
			attach(head1, head2);

		// Create Intersection
		LinkedListNode<Integer> temp1 = head1;
		while (temp1 != null && temp1.next != null) {
			temp1 = temp1.next;
		}

		if (temp1 != null)
			temp1.next = head3;

		int ans = findIntersection2(head1, head2);

		System.out.println(ans);

	}

}
