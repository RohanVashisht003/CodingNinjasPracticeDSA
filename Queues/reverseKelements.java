package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class reverseKelements {

	public static Queue<Integer> reverseK(Queue<Integer> input, int k) {
		Stack<Integer> s = new Stack<>();
		for (int i = 1; i <= k; i++) {
			s.push(input.poll());
		}
		for (int i = 1; i <= k; i++) {
			input.add(s.pop());
		}
		for (int i = 1; i <= input.size() - k; i++) {
			input.add(input.poll());
		}
		return input;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<>();
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for (int i = 0; i < n; i++) {
			int no = scn.nextInt();
			q.add(no);
		}
		int k = scn.nextInt();

		System.out.println(reverseK(q, k));
	}

}
