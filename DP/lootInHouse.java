package DP;

import java.util.Scanner;

public class lootInHouse {

	public static int maxLoot(int arr[], int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return arr[0];
		}
		if (n == 2) {
			return Math.max(arr[0], arr[1]);
		}
		int dp[] = new int[n];
		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);
		for (int i = 2; i < n; i++) {
			dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);
		}
		return dp[n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(maxLoot(arr, n));
	}

}
