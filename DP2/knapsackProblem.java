package DP2;

public class knapsackProblem {

	public static int knapsackIterative(int[] val, int[] weights, int n, int maxWeight) {

		int dp[][] = new int[n + 1][maxWeight + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {

				dp[i][j] = dp[i - 1][j]; // excluding(doesn't bat)
				if (j >= weights[i - 1]) {
					int rWeight = j - weights[i - 1];
					if (dp[i - 1][rWeight] + val[i - 1] > dp[i - 1][j]) {
						dp[i][j] = dp[i - 1][rWeight] + val[i - 1];
					} else {
						dp[i][j] = dp[i - 1][j]; // excluding(doesn't bat)
					}
				} else {
					dp[i][j] = dp[i - 1][j]; // excluding(doesn't bat)
				}
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}

	public static int knapsackRecursive(int[] values, int[] weights, int n, int maxWeight, int vidx, int dp[][]) {
		if (maxWeight <= 0) {
			return Integer.MIN_VALUE;
		}
		if (vidx == weights.length) {
			return 0;
		}
		int ans = 0;
		if (dp[vidx][maxWeight] != 0) {
			return dp[vidx][maxWeight];
		}

		int f1 = knapsackRecursive(values, weights, n, maxWeight - weights[vidx], vidx + 1, dp) + values[vidx];
		int f2 = knapsackRecursive(values, weights, n, maxWeight, vidx + 1, dp);
		ans = Math.max(f1, f2);
		dp[vidx][maxWeight] = ans;
		return ans;

	}

	public static int knapsack(int[] values, int[] weights, int n, int maxWeight, int vidx) {
		if (maxWeight <= 0) {
			return Integer.MIN_VALUE;
		}
		if (vidx == weights.length) {
			return 0;
		}

		int ans;
		int f1 = knapsack(values, weights, n, maxWeight - weights[vidx], vidx + 1) + values[vidx];
		int f2 = knapsack(values, weights, n, maxWeight, vidx + 1);
		ans = Math.max(f1, f2);

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] val = { 200, 300, 100 };
		int[] wt = { 20, 25, 30 };
		int W = 50;
		int dp[][] = new int[wt.length + 1][W + 1];
		System.out.println(knapsack(val, wt, wt.length, W, 0));
		System.out.println(knapsackRecursive(val, wt, val.length, W, 0, dp));
		System.out.println(knapsackIterative(val, wt, val.length, 50));
	}

}
