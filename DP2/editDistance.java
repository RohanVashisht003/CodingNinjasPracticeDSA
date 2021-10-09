package DP2;

import java.util.Scanner;

public class editDistance {

	public static int editDistanceIterative(String s, String t) {
		int dp[][] = new int[s.length() + 1][t.length() + 1];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else {
					if (s.charAt(i - 1) == t.charAt(j - 1)) {
						dp[i][j] = dp[i - 1][j - 1];
					} else {
//						insert
						int ans1 = dp[i][j - 1];
//					remove
						int ans2 = dp[i - 1][j];
//					replace
						int ans3 = dp[i - 1][j - 1];
						dp[i][j] = Math.min(ans1, Math.min(ans2, ans3)) + 1;
					}
				}
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}

	public static int editDistanceRecursive(String s, String t, int i, int j, int arr[][]) {
		if (i == 0) {
			return t.length() - j;
		}
		if (j == 0) {
			return s.length() - i;
		}

		int ans = 0;
		if (s.charAt(i) == t.charAt(j)) {
			return editDistanceRecursive(s, t, i + 1, j + 1, arr);

		} else {
//			replace
			int ans1, ans2, ans3;
			if (arr[i + 1][j + 1] == -1) {
				ans1 = editDistanceRecursive(s, t, i + 1, j + 1, arr);
				arr[i + 1][j + 1] = ans1;
			} else {
				ans1 = arr[i + 1][j + 1];
			}
//			remove
			if (arr[i + 1][j] == -1) {
				ans2 = editDistanceRecursive(s, t, i + 1, j, arr);
				arr[i + 1][j] = ans2;
			} else {
				ans2 = arr[i + 1][j];
			}
			if (arr[i][j + 1] == -1) {
//			insert
				ans3 = editDistanceRecursive(s, t, i, j + 1, arr);
				arr[i][j + 1] = ans3;
			} else {
				ans3 = arr[i][j + 1];
			}

			return Math.min(ans1, Math.min(ans2, ans3)) + 1;

		}
	}

	public static int editDistance(String s, String t, int i, int j) {
		if (i == 0) {
			return j;
		}
		if (j == 0) {
			return i;
		}

		int ans = 0;
		if (s.charAt(i - 1) == t.charAt(j - 1)) {
			return editDistance(s, t, i - 1, j - 1);

		} else {
//			replace
			int ans1 = editDistance(s, t, i - 1, j - 1);
//			remove
			int ans2 = editDistance(s, t, i - 1, j);
//			insert
			int ans3 = editDistance(s, t, i, j - 1);

			return Math.min(ans1, Math.min(ans2, ans3)) + 1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String row = scn.nextLine();
		String col = scn.nextLine();
		int arr[][] = new int[row.length() + 1][col.length() + 1];

		System.out.println(editDistance(row, col, row.length(), col.length()));
//		System.out.println(editDistanceRecursive(row, col, 0, 0, arr));
//		System.out.println(editDistanceIterative(row, col));
	}

}
