package Trees;

import java.util.Scanner;

public class heightOfTree extends binaryTreeUse {

	public static int heightTree(binaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int leftCount = heightTree(root.left);
		int rightCount = heightTree(root.right);
		int ans = Math.max(leftCount, rightCount) + 1;
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		binaryTreeNode<Integer> root = takeInputBetter(true, 0, false);
		System.out.println(heightTree(root));
	}

}
