package groupTest;

import java.util.ArrayList;

public class warNinjaLand {

	public static int dfs() {
		if(root==null) {
			return 1;
		}
		if(root.children.size()==0) {
			return 0;
		}
		ArrayList<Integer> arr;
		for(int i=0; i<root.children.size(); i++) {
			int left = dfs(root.children.,sum);
			arr.add(left);
		}
		for(int i=0; i<arr.size(); i++) {
			if(arr[i]==0) {
				sum++;
				return 2;
			}
		}
		for(int i=0; i<arr.size(); i++) {
			if(arr[i]==2) {
				return 1;
			}
		}
		for(inti=0; i<arr.size(); i++) {
			if(arr[i]==1) {
				return 0;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
