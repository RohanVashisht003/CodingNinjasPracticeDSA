package Trees;

import java.util.Scanner;

public class printNodesDepthK extends binaryTreeUse {

	
	public static void printing(binaryTreeNode<Integer> root, int k) {
		if (root == null) {
			return;
		}

		if (k == 0) {
			System.out.println(root.data);
			return;
		}
		printing(root.left, k - 1);
		printing(root.right, k - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		binaryTreeNode<Integer> root = takeInputBetter(true, 0, false);
		int k = scn.nextInt();
		printing(root, k);
	}

}
