package LinkedList;

public class mergeTwoSortedLL extends LinkedListUse {

	public static Node<Integer> mergeSort(Node<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node<Integer> midNode = midPoint(head);
		
		Node<Integer> list2 = midNode.next;
		midNode.next = null;

		Node<Integer> part1 = mergeSort(head);
		Node<Integer> part2 = mergeSort(list2);

		Node<Integer> mergedList = mergeLL(part1, part2);
		return mergedList;
	}

	public static Node<Integer> mergeLL(Node<Integer> head1, Node<Integer> head2) {
		if (head1 == null) {
			return head1;
		}
		if (head2 == null) {
			return head2;
		}
		Node<Integer> temp1 = head1;
		Node<Integer> temp2 = head2;
		Node<Integer> head = null;
		Node<Integer> tail = null;
		if (temp1.data <= temp2.data) {
			head = temp1;
			tail = temp1;
			temp1 = temp1.next;
		} else {
			head = temp2;
			tail = temp2;
			temp2 = temp2.next;
		}

		while (temp1 != null && temp2 != null) {
			if (temp1.data <= temp2.data) {
				tail.next = temp1;
				tail = temp1;
				temp1 = temp1.next;
			} else {
				tail.next = temp2;
				tail = temp2;
				temp2 = temp2.next;
			}
		}
		if (temp1 == null) {
			tail.next = temp2;
		}
		if (temp2 == null) {
			tail.next = temp1;
		}
		return head;
	}

	public static void main(String[] args) {
//		Node<Integer> inputHead1 = takeInput();
//		Node<Integer> inputHead2 = takeInput();

//		Node<Integer> head = mergeLL(inputHead1, inputHead2);

		Node<Integer> head = takeInput();
		Node<Integer> mergedHead = mergeSort(head);
		printRecursive(mergedHead);
	}

}
