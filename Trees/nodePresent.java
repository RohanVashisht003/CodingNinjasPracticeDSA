package Trees;

import java.util.Scanner;

public class nodePresent  extends binaryTreeUse {

	public static boolean present(binaryTreeNode<Integer> root, int x) {
		if(root==null) {
			return false;
		}
		if(root.data==x) {
			return true;
		}
		boolean left = present(root.left, x);
		boolean right = present(root.right, x);
		return left || right;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		binaryTreeNode<Integer> root = takeInputBetter(true, 0, false);
		int x = scn.nextInt();
		if(present(root,x)) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
	}

}
