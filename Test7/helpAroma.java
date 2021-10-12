package Test7;

import java.util.Scanner;

import java.util.*;

public class helpAroma {

	public static boolean checkAnagram(char a1[], char a2[]) {
		if (a1.length != a2.length) {
			return false;
		}
		for (int i = 0; i < a1.length; i++)
			if (a1[i] != a2[i])
				return false;
		return true;
	}

	public static void Aroma(String s, int w, int x, int y, int z) {
//		StringBuffer s1 = new StringBuffer();
//		StringBuffer s2 = new StringBuffer();
//		for (int i = w; i <= x; i++) {
//			s1.append(s.charAt(i - 1));
//		}
//		String str1 = s1.toString();\\
		String s1 = s.substring(w-1, x+1-1);
		char arr1[] = s1.toCharArray();

		String s2 = s.substring(y-1, z+1-1);
		char arr2[] = s2.toCharArray();

		Arrays.sort(arr1);
		Arrays.sort(arr2);
		System.out.println(arr1);
		System.out.println(arr2);
		if (checkAnagram(arr1, arr2)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		int tc = scn.nextInt();
		while (tc > 0) {
			int w = scn.nextInt();
			int x = scn.nextInt();
			int y = scn.nextInt();
			int z = scn.nextInt();
			Aroma(s, w, x, y, z);
			tc--;
		}
	}

}
