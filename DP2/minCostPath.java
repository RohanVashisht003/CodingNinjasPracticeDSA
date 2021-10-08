package DP2;

import java.util.Scanner;

public class minCostPath {

	public static int minCostMemory(int input[][], int dp[][], int i, int j) {

		if (i == input.length - 1 && j == input[0].length - 1) {
			return input[i][j];
		}
		if (i >= input.length || j >= input[0].length) {
			return Integer.MAX_VALUE;
		}
		int a1, a2, a3;
		if (dp[i + 1][j] == Integer.MIN_VALUE) {
			a1 = minCostPath(input, i + 1, j);
			dp[i + 1][j] = a1;
		} else {
			a1 = dp[i + 1][j];
		}
		if (dp[i][j + 1] == Integer.MIN_VALUE) {
			a2 = minCostPath(input, i, j + 1);
			dp[i][j + 1] = a2;
		} else {
			a2 = dp[i][j + 1];
		}
		if (dp[i + 1][j + 1] == Integer.MIN_VALUE) {
			a3 = minCostPath(input, i + 1, j + 1);
			dp[i + 1][j + 1] = a3;
		} else {
			a3 = dp[i + 1][j + 1];
		}
		int ans = Math.min(a1, Math.min(a2, a3)) + input[i][j];
		return ans;
	}

	public static int minCostPath(int[][] input, int i, int j) {
		if (i == input.length - 1 && j == input[0].length - 1) {
			return input[i][j];
		}
		if (i >= input.length || j >= input[0].length) {
			return Integer.MAX_VALUE;
		}
		int a1 = minCostPath(input, i + 1, j);
		int a2 = minCostPath(input, i, j + 1);
		int a3 = minCostPath(input, i + 1, j + 1);

		int ans = Math.min(a1, Math.min(a2, a3)) + input[i][j];
		return ans;
	}

	public static int minCostPathIterative(int[][] input) {
		int m = input.length;
		int n = input[0].length;

		int dp[][] = new int[m + 1][n + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i == m - 1 && j == n - 1) {
					dp[i][j] = input[i][j];
					continue;
				}
				int ans1 = dp[i][j + 1];
				int ans2 = dp[i + 1][j];
				int ans3 = dp[i + 1][j + 1];
				dp[i][j] = input[i][j] + Math.min(ans1, Math.min(ans2, ans3));
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int row = scn.nextInt();
		int col = scn.nextInt();
		int arr[][] = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		int dp[][] = new int[arr.length + 1][arr[0].length + 1];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				dp[i][j] = Integer.MIN_VALUE;
			}
		}
		System.out.println(minCostPathIterative(arr));
		System.out.println(minCostPath(arr, 0, 0));
		System.out.println(minCostMemory(arr, dp, 0, 0));
	}

}
