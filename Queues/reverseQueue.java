package Queues;

import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class reverseQueue {

	public static void reversing(Queue<Integer> input) {

		if (input.isEmpty()) {
			return;
		}
		int frontEle = input.peek();
		input.remove();
		reversing(input);
		input.add(frontEle);

		while(input.size()!=0) {
			System.out.println(input.poll());
		}
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
		reversing(q);
	}

}
