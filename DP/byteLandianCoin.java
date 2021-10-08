package DP;

import java.util.HashMap;
import java.util.HashMap;
import java.util.Scanner;

public class byteLandianCoin {

	public static long byteland(long n, HashMap<Long, Long> map) {
		if (map.containsKey(map)) {
			return map.get(n);
		}

		if (n <= 3) {
			return n;
		}
		
		long ans1 = byteland(n / 2, map);
		long ans2 = byteland(n / 3, map);
		long ans3 = byteland(n / 4, map);
		long ans = Math.max(n, (ans1+ans2+ans3));
		map.put(n, ans);
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		long n = scn.nextLong();
		HashMap<Long, Long> map = new HashMap<>();
		System.out.println(byteland(n, map));
	}

}
