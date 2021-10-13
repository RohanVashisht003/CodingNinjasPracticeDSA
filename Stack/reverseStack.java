package Stack;

import java.util.Stack;

public class reverseStack {

	public static Stack<Integer> reverseStack(Stack<Integer> s1, Stack<Integer> helper) {
		Stack<Integer> ans = new Stack<Integer>();
		if (s1.isEmpty()) {
			return ans;
		}
		int temp = s1.pop();
		reverseStack(s1, helper);
		int j;
		while (!s1.isEmpty()) {
			j = s1.pop();
			helper.push(j);
		}
		helper.push(temp);
		while (!helper.isEmpty()) {
			j = helper.pop();
			s1.push(j);
		}
		return s1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> helper = new Stack<>();
		int arr[] = { 1, 2, 3, 4, 5 };
		for (int i = 0; i < arr.length; i++) {
			s1.push(arr[i]);
		}
		reverseStack(s1, helper);
		while (!s1.isEmpty()) {
			System.out.print(s1.pop()+" ");
		}

	}
}
