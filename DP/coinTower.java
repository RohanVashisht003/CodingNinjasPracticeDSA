package DP;

import java.util.Scanner;

public class coinTower {

	public static boolean findWinner(int n, int x, int y) {
		boolean dp[] = new boolean[n + 1];
		dp[1] = true;
		for (int i = 2; i <= n; i++) {
			if (i - 1 >= 0 && dp[i - 1] == false)
				dp[i] = true;
			else if (i - x >= 0 && dp[i - x] == false)
				dp[i] = true;
			else if (i - y >= 0 && dp[i - y] == false)
				dp[i] = true;
			else
				dp[i] = false;
		}
		return dp[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int x = scn.nextInt();
		int y = scn.nextInt();
		if (findWinner(n, x, y)) {
			System.out.println("Beerus");
		} else {
			System.out.println("Whis");
		}

	}

}
