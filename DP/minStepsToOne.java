package DP;

import java.util.Scanner;

public class minStepsToOne {

	public static int minStepsIterative(int n) {
		int dp[] = new int[n + 1];
		dp[0] = 0;
		dp[1] = 0;
		for (int i = 2; i <= n; i++) {
			int minSteps = dp[i-1];
			if (i % 2 == 0) {
				minSteps = Math.min(minSteps, dp[i/2]);
			}
			if (i % 3 == 0) {
				minSteps = Math.min(minSteps, dp[i/3]);
			}
			dp[i] = 1 + minSteps;
		}
		return dp[n];
	}

	public static int minSteps(int n, int dp[]) {
		if (n == 1) {
			return 0;
		}
		int ans1;
		if (dp[n - 1] == -1) {
			ans1 = minSteps(n - 1, dp);
			dp[n - 1] = ans1;
		} else {
			ans1 = dp[n - 1];
		}
		int ans2 = Integer.MAX_VALUE;
		if (n % 2 == 0) {
			if (dp[n / 2] == -1) {
				ans2 = minSteps(n / 2, dp);
				dp[n / 2] = ans2;
			} else {
				ans2 = dp[n / 2];
			}
		}
		int ans3 = Integer.MAX_VALUE;
		if (n % 3 == 0) {
			if (dp[n / 3] == -1) {
				ans3 = minSteps(n / 3, dp);
				dp[n / 3] = ans3;
			} else {
				ans3 = dp[n / 3];
			}
		}
		int finalAns = Math.min(ans1, Math.min(ans2, ans3)) + 1;
		return finalAns;
	}

	public static int minStepsRecursive(int n) {
		if (n == 1) {
			return 0;
		}
		int ans3 = Integer.MAX_VALUE;
		int ans2 = Integer.MAX_VALUE;
		int ans1 = Integer.MAX_VALUE;
		ans1 = minStepsRecursive(n - 1);

		if (n % 2 == 0) {
			ans2 = minStepsRecursive(n / 2);
		}

		if (n % 3 == 0) {
			ans3 = minStepsRecursive(n / 3);
		}
		int ans = Math.min(ans1, Math.min(ans2, ans3)) + 1;
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int dp[] = new int[n + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
		System.out.println(minStepsIterative(n));
		System.out.println(minStepsRecursive(n));
		System.out.println(minSteps(n, dp));
	}

}
