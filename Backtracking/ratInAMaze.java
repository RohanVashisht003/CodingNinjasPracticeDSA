package Backtracking;

import java.util.Scanner;
public class ratInAMaze {

	public static boolean safeToPlaceQueen(int arr[][], int row, int col) {
		int r = 0;
		int c = 0;
//		top
		r = row - 1;
		c = col;
		while (r >= 0) {
			if (arr[r][c] == 1) {
				return false;
			}
			r--;
		}
//		down
//		r = row + 1;
//		c = col;
//		while (r < arr.length) {
//			if (arr[r][c] == 1) {
//				return false;
//			}
//			r++;
//		}
//		diagonal left upward
		r = row - 1;
		c = col - 1;
		while (r >= 0 && c >= 0) {
			if (arr[r][c] == 1) {
				return false;
			}
			r--;
			c--;
		}
//		diagonal right upward
		r = row - 1;
		c = col + 1;
		while (r >= 0 && c < arr[0].length) {
			if (arr[r][c] == 1) {
				return false;
			}
			r--;
			c++;
		}
//		diagonal left downward
		r = row + 1;
		c = col - 1;
		while (r < arr.length && c >= 0) {
			if (arr[r][c] == 1) {
				return false;
			}
			r++;
			c--;
		}
//		diagonal right downward
		r = row + 1;
		c = col + 1;
		while (r < arr.length && c < arr[0].length) {
			if (arr[r][c] == 1) {
				return false;
			}
			r++;
			c++;
		}
		return true;
	}

	public static void placeNQueens(int arr[][], int row, int n) {
		if (row == arr.length) {
//			printing
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}

		for (int col = 0; col < n; col++) {
			if (safeToPlaceQueen(arr, row, col)) {
				arr[row][col] = 1;
				placeNQueens(arr, row + 1, n);
				arr[row][col]=0;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int arr[][] = new int[n][n];
		
		placeNQueens(arr, 0, n);
	}
}
