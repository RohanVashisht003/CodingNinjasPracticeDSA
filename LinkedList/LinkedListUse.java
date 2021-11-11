package LinkedList;

import java.util.Scanner;

class DoubleNode {
	Node<Integer> head;
	Node<Integer> tail;

	public DoubleNode() {
		
	}

	public DoubleNode(Node<Integer> head, Node<Integer> tail) {
		
		this.head = head;
		this.tail = tail;
	}
}

public class LinkedListUse {

	static Node<Integer> temp = null;

	public static Node<Integer> midPoint(Node<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node<Integer> slowPtr = head;
		Node<Integer> fastPtr = head;
		while (fastPtr.next != null && fastPtr.next.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		return slowPtr;

	}

	public static void printRecursive(Node<Integer> head) {
		if (head == null) {
			return;
		}

		System.out.print(head.data + " ");
		printRecursive(head.next);
	}

	public static int findNodeLLIterative(Node<Integer> head, int item) {
		if (head == null) {
			return -1;
		}
		int count = 0;
		Node<Integer> temp = head;
		while (temp != null) {
			if (temp.data != item) {
				temp = temp.next;
				count++;
			} else {
				return count;
			}
		}
		return -1;
	}

	public static int findNodeLLRecursive(Node<Integer> head, int item, int idx) {
		if (head == null) {
			return -1;
		}
		if (item == head.data) {
			return idx;
		}
		int index = findNodeLLRecursive(head.next, item, idx + 1);
		return index;
	}

	public static boolean isPalindrome(Node<Integer> head) {
		temp = head;
		return find(head);
	}

	public static boolean find(Node<Integer> head) {
		if (head == null) {
			return true;
		}
		boolean res = find(head.next);
		if (res == true) {
			if (head.data == temp.data) {
				temp = temp.next;
				return true;
			}
		}
		return false;
	}

	public static Node<Integer> reverseRecursive(Node<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		Node<Integer> reverseHead = reverseRecursive(head.next);
		head.next.next = head;	
		head.next = null;
		return reverseHead;
	}

	public static DoubleNode reverseBetter(Node<Integer> head) {
		DoubleNode ans;
		if (head == null || head.next == null) {
			ans = new DoubleNode();
			ans.head = head;
			ans.tail = head;
			return ans;
		}

		DoubleNode smallAns = reverseBetter(head.next);
		smallAns.tail.next = head;
		head.next = null;
		ans = new DoubleNode();
		ans.head = smallAns.head;
		ans.tail = head;
		return ans;
	}

	public static void printReverse(Node<Integer> head) {
		if (head == null) {
			return;
		}
		printReverse(head.next);
		System.out.print(head.data + " ");
	}

	public static Node<Integer> eliminateDuplicates(Node<Integer> head) {
		Node<Integer> temp = head;
		int data = 0;
		while (temp.next != null) {
			data = temp.data;
			if (data != temp.next.data) {
				temp = temp.next;
			} else {
				if (temp.next.next == null) {
					temp.next = null;
				} else {
					Node<Integer> temp3 = temp.next;
					while (data == temp3.data) {
						if (temp3.next == null) {
							temp.next = null;
							break;
						} else {
							temp3 = temp3.next;
						}
					}
					temp.next = temp3;
				}
			}
		}
		return head;
	}

	public static Node<Integer> appendLastNToFirst(Node<Integer> head, int n) {
		if (n == 0 || head == null) {
			return head;
		} else {
			int count = length(head) - n;
			Node<Integer> temp = head;
			for (int i = 0; i < count - 1; i++) {
				temp = temp.next;
			}
			Node<Integer> tempp1 = temp.next;
			while (tempp1.next != null) {
				tempp1 = tempp1.next;
			}

			tempp1.next = head;
			head = temp.next;
			temp.next = null;

			return head;
		}
	}

	public static int getNodeIndex(Node<Integer> head, int data) {
		Node<Integer> temp = head;
		int index = 0;
		while (temp != null) {
			if (temp.data != data) {
				index++;
				temp = temp.next;
			} else {
				return index;
			}
		}
		return -1;
	}

	public static Node<Integer> deleteLast(Node<Integer> head) {
		Node<Integer> rn = head;
		if (length(head) == 1) {
			return null;
		} else {
			Node<Integer> temp = head;
			int count = 0;
			while (count < length(head) - 2) {
				count++;
				temp = temp.next;
			}
			temp.next = null;
		}
		return head;
	}

	public static Node<Integer> deleteRecursive(Node<Integer> head, int pos) {
		if (head == null) {
			return head;
		}

		if (pos == 0) {
			return head.next;
		}

		Node<Integer> head2 = deleteRecursive(head.next, pos - 1);
		head.next = head2;
		return head;
	}

	public static Node<Integer> deleteFirst(Node<Integer> head) {
		Node<Integer> rn = head;
		if (length(head) == 1) {
			return null;
		} else {
			head = head.next;
		}
		return head;
	}

	public static Node<Integer> delete(Node<Integer> head, int pos) {
		if (isEmpty(head)) {
			return null;
		} else if (pos == length(head) - 1) {
			return deleteLast(head);
		} else if (pos == 0) {
			return deleteFirst(head);
		} else {
			Node<Integer> prev = head;
			int count = 0;
			while (count < pos - 1) {
				count++;
				prev = prev.next;
			}
			Node<Integer> rn = prev.next;
			Node<Integer> rnp1 = rn.next;
			prev.next = rnp1;
			return head;
		}
	}

	public static Node<Integer> insertRecursive(Node<Integer> head, int data, int pos) {

		if (head == null && pos > 0) {
			return head;
		}

		if (pos == 0) {
			Node<Integer> newNode = new Node<>(data);
			newNode.next = head;
			return newNode;
		} else {
			head.next = insertRecursive(head.next, data, pos - 1);
			return head;
		}
	}

	public static Node<Integer> insert(Node<Integer> head, int data, int pos) {
		Node<Integer> nn = new Node<>(data);
		if (pos == 0) {
			nn.next = head;
			head = nn;
		} else {
			int count = 0;
			Node<Integer> prev = head;
			while (count < pos - 1 && prev != null) {
				count++;
				prev = prev.next;
			}
			nn.next = prev.next;
			prev.next = nn;
		}
		return nn;
	}

	public static Node<Integer> takeInput() {
		Scanner scn = new Scanner(System.in);
		int data = scn.nextInt();
		Node<Integer> head = null;
		while (data != -1) {
			Node<Integer> currNode = new Node<>(data);
			if (head == null) {
//				its my first node
				head = currNode;
			} else {
				Node<Integer> tail = head;
				while (tail.next != null) {
					tail = tail.next;
				}
//				Now tail will refer to last node
//				Connect current node after last node	
				tail.next = currNode;
			}
			data = scn.nextInt();
		}
		return head;
	}

	public static boolean isEmpty(Node<Integer> head) {
		return length(head) == 0;
	}

	public static void printAtith(Node<Integer> head, int i) {
		Node<Integer> temp = head;
		int count = 0;
		while (temp != null && count != i) {
			temp = temp.next;
			count++;
		}
		if (temp != null && count == i) {
			System.out.println(temp.data);
		}
	}

	public static int length(Node<Integer> head) {
		Node<Integer> temp = head;
		int len = 0;
		while (temp != null) {
			len++;
			temp = temp.next;
		}
		return len;
	}

	public static void increment(Node<Integer> head) {
		Node<Integer> temp = head;
		while (temp != null) {
			temp.data++;
			temp = temp.next;
		}
	}

	public static void print2(Node<Integer> head) {
		Node<Integer> temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void print(Node<Integer> head) {
		System.out.println("Main" + head);
	}

//	public static Node<Integer> createLinkedList() {
//		Node<Integer> n1 = new Node<>(10);
//		Node<Integer> n2 = new Node<>(40);
//		Node<Integer> n3 = new Node<>(80);
//		n1.next = n2;
//		n2.next = n3;
//		n3.next = null;
//		return n1;
//	}

	public static void main(String[] args) {

//		System.out.println(createLinkedList().data);
//		Node<Integer> n = takeInput();
//		print2(n);
//		increment(n);
//		print2(n);
//		System.out.println(length(n));
//		printAtith(n, 2);
//		Node<Integer> n1 = insert(n, 80, 0);
//		print2(n1);
//
//		Node<Integer> rn = delete(n, 1);
//		print2(rn);

//		System.out.println(getNodeIndex(n, 50));

//		Node<Integer> nh = appendLastNToFirst(n, 1);
//		print2(nh);

//		Node<Integer> nh = eliminateDuplicates(n);
//		print2(nh);

//		printReverse(n);

//		boolean ans = isPalindrome(n);
//		System.out.println(ans);

//		printRecursive(n);
////		Node<Integer> head2 = insertRecursive(null, 100, 0);
//		System.out.println();
//
//		Node<Integer> head2 = deleteRecursive(n, 2);
//		printRecursive(head2);

//		Node<Integer> head2 = reverseRecursive(n);
//		printRecursive(head2);
//		DoubleNode head3 = reverseBetter(n);
//		printRecursive(head3.head);
//		Node<Integer> middleElement = midPoint(n);
//		System.out.println(middleElement.data);
//		Node<Integer> head1 = takeInput();
//		Node<Integer> head2 = takeInput();
//		Node<Integer> head = mergeLL();
		Node<Integer> head = takeInput();
//		System.out.println(findNodeLLIterative(head, 100));
		System.out.println(findNodeLLRecursive(head, 10, 0));
	}

}
