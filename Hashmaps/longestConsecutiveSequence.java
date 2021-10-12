package Hashmaps;

import java.util.*;

public class longestConsecutiveSequence {

	public static ArrayList<Integer> longestSequence(int arr[]) {
//		Arrays.sort(arr);
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++)
			map.put(arr[i], true);

		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i] - 1)) {
				map.put(arr[i], false);
			}
		}
		int msp = 0;
		int ml = 0;
		for (int val : arr) {
			if (map.get(val) == true) {
				int tsp = val;
				int tl = 1;
				while (map.containsKey(tsp + tl)) {
					tl++;
				}

				if (tl > ml) {
					msp = tsp;
					ml = tl;
				}
			}
		}
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(msp);
		al.add(msp + ml - 1);
		return al;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 15, 24, 23, 12, 19, 11, 16 };
		ArrayList<Integer> al = longestSequence(arr);
		for (int i = 0; i < al.size(); i++) {
			System.out.print(al.get(i) + " ");
		}

	}
}