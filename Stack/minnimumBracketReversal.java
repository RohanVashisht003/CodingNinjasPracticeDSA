package Stack;

import java.util.Scanner;
import java.util.Stack;

public class minnimumBracketReversal {

	public static int countBracketReversals(String input) {
		if (input.length() % 2 != 0) {
			return -1;
		}
		Stack<Character> s = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch == '{') {
				s.push(ch);
			} else if (ch == '}') {
				if (!s.isEmpty() && s.peek() == '{') {
					s.pop();
				} else if (!s.isEmpty() && s.peek() == '}') {
					s.push(ch);
				} else if (s.isEmpty()) {
					s.push(ch);
				}
			}
		}

		int count = 0;
		while (!s.isEmpty()) {
			char c1 = s.pop();
			char c2 = s.pop();
			if (c1 == c2) {
				count++;
			} else {
				count += 2;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(countBracketReversals(str));
	}

}
