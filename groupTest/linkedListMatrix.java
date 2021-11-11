package groupTest;

import java.util.*;

class Node {
	int data;
	Node right, down;

	Node(int data) {
		this.data = data;
		right = null;
		down = null;
	}
}

class Solution {
	public static Node working(int arr[][], int i, int j, int m, int n) {
		if (i > n - 1 || j > m - 1)
			return null;
		Node temp = new Node(arr[i][j]);
		temp.right = working(arr, i, j + 1, m, n);
		temp.down = working(arr, i + 1, j, m, n);
		return temp;
	}

	static Node construct(int arr[][], int n) {
		int m = n;
		return working(arr, 0, 0, m, n);
	}
}

public class linkedListMatrix {
	static void display(Node head) {
		Node rp;
		Node dp = head;
		while (dp != null) {
			rp = dp;
			while (rp != null) {
				System.out.print(rp.data + " ");
				rp = rp.right;
			}
			dp = dp.down;
			System.out.println();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				arr[i][j] = s.nextInt();
		}
		Node head = Solution.construct(arr, n);
		display(head);
	}

}
