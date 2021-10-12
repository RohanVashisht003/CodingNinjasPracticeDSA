package Hashmaps;

import java.util.HashMap;
import java.util.Scanner;

import java.util.Arrays;

public class printIntersection {

//	public static void intersection(int[] arr1, int[] arr2) {
//		if (arr1.length == 0 || arr2.length == 0)
//			return;
//		HashMap<Integer, Integer> map = new HashMap<>();
//		for (int i = 0; i < arr1.length; i++) {
//			if (map.containsKey(arr1[i])) {
//				int value = map.get(arr1[i]);
//				map.put(arr1[i], value + 1);
//			} else
//				map.put(arr1[i], 1);
//		}
//
//		for (int i = 0; i < arr2.length; i++) {
//			if (map.containsKey(arr2[i])) {
//				if (map.get(arr2[i]) != 0) {
//					int freq = 0;
//					if (freq > 0) {
//						System.out.print(arr2[i] + " ");
//						map.put(arr2[i], freq - 1);
//					}
//				}
//			}
//		}
//	}

	public static void arrayIntersection(int arr1[], int arr2[]) {
		int i = 0, j = 0;
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				i++;
			} else if (arr1[i] > arr2[j]) {
				j++;
			} else {
				System.out.print(arr1[i]+" ");
				i++;
				j++;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		while (n > 0) {
			int n1 = scn.nextInt();
			int arr1[] = new int[n1];
			for (int i = 0; i < arr1.length; i++) {
				arr1[i] = scn.nextInt();
			}
			int n2 = scn.nextInt();
			int arr2[] = new int[n2];
			for (int i = 0; i < arr2.length; i++) {
				arr2[i] = scn.nextInt();
			}
			arrayIntersection(arr1, arr2);
			System.out.println();
			n--;
		}
	}

}
