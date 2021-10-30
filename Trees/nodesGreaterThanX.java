package Trees;

import java.util.Scanner;

public class nodesGreaterThanX extends binaryTreeUse {

	public static int greaterNodes(binaryTreeNode<Integer> root, int x) {
		if (root == null) {
			return 0;
		}
		int count = 0;
		if (root.data > x) {
			count++;
		}
		count += greaterNodes(root.left, x);
		count += greaterNodes(root.right, x);
		return count;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		binaryTreeNode<Integer> root = takeInputBetter(true,0,false);
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter x");
		int x = scn.nextInt();
		System.out.println(greaterNodes(root, x));
	}

}
