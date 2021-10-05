package DP;

import java.util.*;

public class fibonacci {

	public static int fibItertive(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];

	}

	public static int fib(int n, int dp[]) {
		if (n == 0 || n == 1) {
			return n;
		}
		int fib1, fib2;
		if (dp[n - 1] == -1) {
			fib1 = fib(n - 1, dp);
			dp[n - 1] = fib1;
		} else {
			fib1 = dp[n - 1];
		}

		if (dp[n - 2] == -1) {
			fib2 = fib(n - 2, dp);
			dp[n - 2] = fib2;
		} else {
			fib2 = dp[n - 2];
		}

		int finalAns = fib1 + fib2;
		return finalAns;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int dp[] = new int[n + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
		System.out.println(fib(n, dp));

		System.out.println(fibItertive(n));
	}

}
