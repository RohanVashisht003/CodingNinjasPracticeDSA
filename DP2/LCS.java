package DP2;

import java.util.Scanner;

public class LCS {

	public static int LCSIterative(String s1, String s2) {
		int dp[][] = new int[s1.length() + 1][s2.length() + 1];
		for (int i = dp.length - 2; i >= 0; i--) {
			for (int j = dp[0].length - 2; j >= 0; j--) {
				if (s1.charAt(i) == s2.charAt(j)) {
					dp[i][j] = dp[i + 1][j + 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}
		return dp[0][0];
	}

	public static int LCSMemorisation(String s1, String s2, int i, int j, int dp[][]) {
		if (s1.length() == i || s2.length() == j) {
			return 0;
		}
		int ans;
		if (s1.charAt(i) == s2.charAt(j)) {
			int smallAns;
			if (dp[i][j] == -1) {
				smallAns = LCSMemorisation(s1, s2, i + 1, j + 1, dp);
				ans = 1 + smallAns;
				dp[i][j] = ans;
			} else {
				ans = dp[i][j];
			}

		} else {
			if (dp[i][j] == -1) {
				int smallAns1 = LCSMemorisation(s1, s2, i + 1, j, dp);
				int smallAns2 = LCSMemorisation(s1, s2, i, j + 1, dp);
				ans = Math.max(smallAns1, smallAns2);
				dp[i][j] = ans;
			} else {
				ans = dp[i][j];
			}
		}
		return ans;

	}

	public static int LCS(String s1, String s2, int i, int j) {
		if (s1.length() == i || s2.length() == j) {
			return 0;
		}
		int ans;
		if (s1.charAt(i) == s2.charAt(j)) {
			int smallAns = LCS(s1, s2, i + 1, j + 1);
			ans = 1 + smallAns;
		} else {
			int smallAns1 = LCS(s1, s2, i + 1, j);
			int smallAns2 = LCS(s1, s2, i, j + 1);
			ans = Math.max(smallAns1, smallAns2);
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s1 = scn.nextLine();
		String s2 = scn.nextLine();

		int dp[][] = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println(LCS(s1, s2, 0, 0));
		System.out.println(LCSMemorisation(s1, s2, 0, 0, dp));
		System.out.println(LCSIterative(s1, s2));
	}

}
