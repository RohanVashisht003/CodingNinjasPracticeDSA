package Stack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class stockSpan {

	public static ArrayList<Integer> spanning(int arr[]) {
		Stack<Integer> s = new Stack<>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		s.push(0);
		al.add(1);
		for (int i = 1; i < arr.length; i++) {
			while (!s.isEmpty() && arr[i] > arr[s.peek()]) {
				s.pop();
			}
			if (s.size() == 0) {
				al.add(i + 1);
			} else {
				al.add(i - s.peek());
			}
			s.push(i);
		}
		return al;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		ArrayList<Integer> ans = spanning(arr);
		System.out.println(ans);
	}

}
