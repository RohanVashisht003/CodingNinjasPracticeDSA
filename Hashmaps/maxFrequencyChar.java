package Hashmaps;

import java.util.HashMap;

public class maxFrequencyChar {

	public static int maxFrequencyNumber(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
			
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				int freq = map.get(arr[i]);
				freq++;
				map.put(arr[i], freq);
			} else {
				map.put(arr[i], 1);
			}
		}
		int maxFreq = 0;
		int num=Integer.MIN_VALUE;	

		for(int i=0;i<arr.length;i++)
		       
        {
            if(map.get(arr[i])>maxFreq){
                maxFreq=map.get(arr[i]);
                num=arr[i];}
        }
     
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 2, 12, 2, 11, 12, 2, 1, 2, 2, 11, 12, 2, 6 };

		System.out.println(maxFrequencyNumber(arr));
	}

}
