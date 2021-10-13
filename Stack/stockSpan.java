package Stack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class stockSpan {

	public static ArrayList<Integer> spanning(int arr[]){
		Stack<Integer> s = new Stack<>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		s.push(1);
		for(int i=1; i<arr.length; i++) {
			int count=1;
			for(int j=0; j<i; j++) {
				if(arr[j]<arr[i]) {
					count++;
				}
			}
			s.push(count);
		}
		
		for(int i=0; i<arr.length; i++) {
			int data = s.pop();
			al.add(data);
		}
		return al;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		ArrayList<Integer> ans = spanning(arr);
		System.out.println(ans);
	}

}
