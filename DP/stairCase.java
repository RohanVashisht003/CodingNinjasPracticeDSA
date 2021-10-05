package DP;

import java.util.Scanner;

public class stairCase {

	public static long stairCaseIterative(int n) {
		long[] dp = new long[n+1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3; i<=n; i++) {
			dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
		}
		return dp[n];
	}
	public static long stairCase(int n, long dp[]) {
		if (n == 0 || n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		long ans1, ans2, ans3;
		if (dp[n - 1] == -1) {
			ans1 = stairCase(n - 1, dp);
			dp[n - 1] = ans1;
		} else {
			ans1 = dp[n - 1];
		}
		if (dp[n - 2] == -1) {
			ans2 = stairCase(n - 2, dp);
			dp[n - 2] = ans2;
		} else {
			ans2 = dp[n - 2];
		}
		if (dp[n - 3] == -1) {
			ans3 = stairCase(n - 3, dp);
			dp[n - 3] = ans3;
		} else {
			ans3 = dp[n - 3];
		}

		long ans = ans1 + ans2 + ans3;
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		long dp[] = new long[n + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
		System.out.println(stairCase(n, dp));
		System.out.println(stairCaseIterative(n));
	}

}
