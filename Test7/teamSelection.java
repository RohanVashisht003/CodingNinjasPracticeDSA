package Test7;

import java.util.Scanner;

public class teamSelection {

	public static void combinationUtil(int arr[], int data[], int start, int end, int index, int r) {

		if (index == r) {
			for (int j = 0; j < r; j++)
				System.out.print(data[j] + " ");
			System.out.println();
			return;
		}

		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			data[index] = arr[i];
			combinationUtil(arr, data, i + 1, end, index + 1, r);
		}
	}

	public static void printCombination(int arr[], int n, int r) {

		int data[] = new int[r];

		combinationUtil(arr, data, 0, n - 1, 0, r);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int arr[] = new int[n];
		for (int j = 0; j < arr.length; j++) {
			arr[j] = scn.nextInt();
		}
		printCombination(arr, n, 12);
	}

}
