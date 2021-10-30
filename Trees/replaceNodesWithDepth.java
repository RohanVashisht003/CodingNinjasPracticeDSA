package Trees;

import java.util.Scanner;

public class replaceNodesWithDepth extends binaryTreeUse {

	public static void replaceWithDepth(binaryTreeNode<Integer> root, int level) {

		if (root == null) {
			return;
		}
		root.data = level;
		replaceWithDepth(root.left, level + 1);
		replaceWithDepth(root.right, level + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		binaryTreeNode<Integer> root = takeInputBetter(true, 0, false);
		replaceWithDepth(root, 0);
		printingDetailed(root);
	}

}
