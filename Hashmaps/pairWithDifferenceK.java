package Hashmaps;

import java.util.*;

public class pairWithDifferenceK {

	public static int findPairsDifferenceK(int[] input, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int pairs = 0;
		for (int i = 0; i < input.length; i++) {
			if (map.containsKey(input[i])) {
				map.put(input[i], map.get(input[i]) + 1);
			} else {
				map.put(input[i], 1);
			}
		}

		for (Integer key : map.keySet()) {
			if (map.get(key) > 0) {
				if ((map.containsKey(key - k) && map.containsKey(key)) && map.get(key - k) > 0) {
					map.put(key, map.get(key) - 1);
					pairs++;
				}
				if (map.containsKey(key + k) && map.containsKey(key + k) && map.get(key + k) > 0) {
					map.put(key, map.get(key) - 1);
					pairs++;
				}
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
