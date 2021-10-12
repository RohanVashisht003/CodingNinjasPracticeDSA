package Hashmaps;

import java.util.*;

public class longestSubsetZeroSum {

	public static int lengthOfLongestSubsetWithZeroSum(ArrayList<Integer> arr) {
		if (arr.size() == 0)
			return 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int maxlength = 0;
		int maxlength1 = 0;
		for (int i = 0; i < arr.size(); i++) {
			sum = sum + arr.get(i);
			if (map.containsKey(sum)) {
				int k = map.get(sum);
				int l = i - k;
				maxlength1 = l;
			}

			else
				map.put(sum, i);
			if (sum == 0) {
				maxlength1 = i + 1;
			}

			if (maxlength1 > maxlength)
				maxlength = maxlength1;
		}
		return maxlength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int no = scn.nextInt();
			al.add(no);
		}
	
		System.out.println(lengthOfLongestSubsetWithZeroSum(al));
	}

}
