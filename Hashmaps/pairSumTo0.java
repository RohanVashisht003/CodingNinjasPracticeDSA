package Hashmaps;

import java.util.*;

public class pairSumTo0 {
	public static int PairSum(int[] input, int size) {
			HashMap<Integer, Integer> map = new HashMap<>();
	
			for (int i = 0; i < size; i++) {
	
				if (!map.containsKey(input[i]))
					map.put(input[i], 0);
	
				map.put(input[i], map.get(input[i]) + 1);
			}
			int twice_count = 0;
	
			for (int i = 0; i < size; i++) {
				if (map.get(-input[i]) != null)
					twice_count += map.get(-input[i]);
	
				if (-input[i] == input[i])
					twice_count--;
			}
	
			return twice_count / 2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[] = { 2, 1, -2, 2, 3 };
		
		System.out.println(PairSum(input, 5));
	}

}
