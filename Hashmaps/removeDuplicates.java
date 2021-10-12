package Hashmaps;

import java.util.ArrayList;
import java.util.HashMap;

public class removeDuplicates {

	public static ArrayList<Integer> removeDuplicates(int arr[]) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		
		ArrayList<Integer> al = new ArrayList<>();
		for(int i=0; i<arr.length; i++) {
			if(map.containsKey(arr[i])) {
				continue;
			}
			else {
				map.put(arr[i], true);
				al.add(arr[i]);
			}
		}
		return al;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 2, 3, 4, 3, 6 };
		ArrayList<Integer> output = removeDuplicates(arr);
		System.out.println(output);
		
	}

}
