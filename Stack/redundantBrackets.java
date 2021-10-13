package Stack;

import java.util.Scanner;
import java.util.Stack;

public class redundantBrackets {

	public static boolean checkRedundancy(String expression) {
		boolean flag = false;
		Stack<Character> s = new Stack<>();
		int count = 0;
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == ')') {
				if (s.peek() == '(') {
					flag = true;
					return flag;
				} else {
					while (s.peek() != '(') {
						s.pop();
					}
					s.pop();
				}
			} else {
				s.push(expression.charAt(i));
			}
	}
		return flag;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String expression = scn.next();
		if (checkRedundancy(expression)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

}
