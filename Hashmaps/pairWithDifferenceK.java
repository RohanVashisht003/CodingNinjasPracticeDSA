package Hashmaps;

import java.util.*;

public class pairWithDifferenceK {

	public static int findPairsDifferenceK(int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int pairs = 0;
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}

		for (int i = 0; i < arr.length; i++) {
			int second = k + arr[i];
			if (map.containsKey(arr[i]) && map.containsKey(second)) {
				if (arr[i] == second)
					pairs += (map.get(arr[i]) * (map.get(arr[i]) - 1)) / 2;
				else
					pairs += map.get(arr[i]) * map.get(second);
				map.remove(arr[i]);
			}
		}
		return pairs;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 4, 4, 4, 4 };

		System.out.println(findPairsDifferenceK(arr, 0));
	}

}
