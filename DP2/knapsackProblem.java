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

	public static int knapsack(int[] values, int[] weights, int n, int maxWeight, int vidx) {
		if (vidx == values.length) {
			return 0;
		}

		int ans;
		if (weights[vidx] <= maxWeight) {
//			include
			int an1 = values[vidx] + knapsack(values, weights, n, maxWeight - weights[vidx], vidx + 1);
//			exclude
			int an2 = knapsack(values, weights, an1, maxWeight, vidx + 1);
			ans = Math.max(an1, an2);
		} else {
			ans = knapsack(values, weights, n, maxWeight, vidx + 1);
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] val = { 200, 300, 100 };
		int[] wt = { 20, 25, 30 };
//		System.out.println(knapsack(val, wt, wt.length, 50, 0));
		System.out.println(knapsackIterative(val, wt, val.length, 50));
	}

}
