package Arrays;

import java.util.ArrayList;

public class removeConsecutiveDuplicates {

	
	public static ArrayList<Integer> removeduplicates(int arr[]) {
		ArrayList<Integer> list = new ArrayList<>(arr.length);
		list.add(arr[0]);
		for(int i=1; i<arr.length; i++) {
			if(arr[i]!=arr[i-1]) {
				list.add(arr[i]);
			}
		}
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {11,11,2,67,67};
		ArrayList<Integer> list = removeduplicates(arr);
		for(int i:list) {
			System.out.println(i);
		}
	}

}
