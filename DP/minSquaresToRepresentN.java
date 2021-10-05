package DP;

import java.util.Scanner;

public class minSquaresToRepresentN {

	public static int minCountIterative(int n) {
		int dp[] = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			int ans = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; j++) {
				ans = Math.min(dp[i - j * j], ans);
				dp[i] = ans + 1;
			}
		}
		return dp[n];
	}

	public static int minCount(int n, int dp[]) {
		if (n == 0) {
			return n;
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i * i <= n; i++) {
			int currAns;
			if (dp[n - (i * i)] == -1) {
				currAns = minCount(n - (i * i), dp);
				dp[n - (i * i)] = currAns;
			} else {
				currAns = dp[n - (i * i)];
			}
			ans = Math.min(currAns, ans);
		}
		return ans + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int dp[] = new int[n + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
		System.out.println(minCount(n, dp));
//		System.out.println(minCountIterative(n));
	}

}
