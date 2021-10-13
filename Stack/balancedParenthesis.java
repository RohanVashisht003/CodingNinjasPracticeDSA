package Stack;

import java.util.Scanner;
import java.util.Stack;

public class balancedParenthesis {

	public static boolean isBalanced(String expression, Stack<Character> s) {
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (ch == '(' || ch == '[' || ch == '{') {
				s.push(ch);
			}
			if (ch == ')' || ch == ']' || ch == '}') {
				if (s.isEmpty()) {
					return false;
				}
				char last = s.peek();
				if (last == '(' && ch == ')' || last == '{' && ch == '}' || last == '[' && ch == ']') {
					s.pop();
				} else {
					return false;
				}
			}
		}
		return s.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String expression = scn.next();
		Stack<Character> s = new Stack<>();
		if (isBalanced(expression, s)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

}
