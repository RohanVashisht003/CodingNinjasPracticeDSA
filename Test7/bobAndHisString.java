package Test7;

import java.util.*;

public class bobAndHisString {

	public static int bobWorking(String s) {
		int maxAns = 0;

		int charArr[] = new int[26];
		for (int i = 0; i < charArr.length; i++) {
			charArr[i] = -1;
		}
		for(int i=0; i<s.length(); i++) {
			if (charArr[s.charAt(i) - 'a'] == -1) {
				charArr[s.charAt(i) - 'a'] = i;
			} else {
				charArr[s.charAt(i) - 'a'] = i - charArr[s.charAt(i) - 'a'];
				if (maxAns < charArr[s.charAt(i) - 'a']) {
					maxAns = charArr[s.charAt(i) - 'a'];
				}
			}
		}
		
		return maxAns-1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int tc = scn.nextInt();
		while (tc > 0) {
			String s = scn.next();
			System.out.println(bobWorking(s));
			tc--;
		}
	}

}
