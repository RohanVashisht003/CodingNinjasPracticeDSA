package groupTest;

import java.util.Scanner;
import java.util.*;
public class armstrongOrNot {

	public static int order(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = n / 10;
		}
		return count;
	}

	public static boolean Armstrong(int n) {
		int count = order(n);
		int sum = 0;
		int original = n;
		while (original != 0) {
			int rem = original % 10;
			sum += (int) (Math.pow(rem, count));
			original /= 10;
		}
		if (sum == n) {
			return true;
		} else
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int x = scn.nextInt();
		if (Armstrong(x)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

}
