package Trees;

import java.util.Scanner;

public class binaryTreeUse {

	public static int greatestNode(binaryTreeNode<Integer> root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int leftMax = greatestNode(root.left);
		int rightMax = greatestNode(root.right);
		return Math.max(root.data, Math.max(leftMax, rightMax));
	}

	public static void preOrder(binaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);

	}

	public static void postOrder(binaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}

	public static void inOrder(binaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);

	}

	public static int sumOfNode(binaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int leftsum = sumOfNode(root.left);
		int rightsum = sumOfNode(root.right);
		return root.data + leftsum + rightsum;
	}

	public static int countNodes(binaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int leftCount = countNodes(root.left);
		int rightCount = countNodes(root.right);
		return 1 + leftCount + rightCount;
	}

	public static binaryTreeNode<Integer> takeInputBetter(boolean isRoot, int data, boolean isLeft) {
		if (isRoot) {
			System.out.println("Enter root data ");
		} else {
			if (isLeft) {
				System.out.println("Enter leftChildData of" + data);
			} else {
				System.out.println("Enter rightChild of" + data);
			}
		}
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		if (n == -1) {
			return null;
		}

		binaryTreeNode<Integer> root = new binaryTreeNode<Integer>(n);
		binaryTreeNode<Integer> leftChild = takeInputBetter(false, n, true);
		binaryTreeNode<Integer> rightChild = takeInputBetter(false, n, false);
		root.left = leftChild;
		root.right = rightChild;
		return root;
	}

	public static binaryTreeNode<Integer> takeInput() {
		System.out.println("Enter root data");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		if (n == -1) {
			return null;
		}
		binaryTreeNode<Integer> root = new binaryTreeNode<Integer>(n);
		binaryTreeNode<Integer> leftChild = takeInput();
		binaryTreeNode<Integer> rightChild = takeInput();
		root.left = leftChild;
		root.right = rightChild;
		return root;
	}

	public static void printingDetailed(binaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + ":->");
		if (root.left != null) {
			System.out.print("L(" + root.left.data + ")" + ",");
		}
		if (root.right != null) {
			System.out.print("R(" + root.right.data + ")");
		}
		System.out.println();
		printingDetailed(root.left);
		printingDetailed(root.right);
	}

	public static void printTree(binaryTreeNode<Integer> root) {
//		System.out.println(root.data);
//		if(root.left!=null) {
//		printTree(root.left);
//		}
//		if(root.right!=null) {
//		printTree(root.right);
//		}

//-------------------------OR-----------------------------------
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		printTree(root.left);
		printTree(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		binaryTreeNode<Integer> root = new binaryTreeNode<>(10);
//		binaryTreeNode<Integer> rootLeft = new binaryTreeNode<>(20);
//		binaryTreeNode<Integer> rootRight = new binaryTreeNode<>(30);
//		root.left = rootLeft;
//		root.right = rootRight;
//
//		binaryTreeNode<Integer> rootLeftRight = new binaryTreeNode<Integer>(40);
//		binaryTreeNode<Integer> rootRightLeft = new binaryTreeNode<Integer>(50);
//		rootLeft.right = rootLeftRight;
//		rootRight.left = rootRightLeft;
////		printTree(root);
//		printingDetailed(root);
		binaryTreeNode<Integer> root = takeInputBetter(true, 0, false);
//		printingDetailed(root);
//		System.out.println(countNodes(root));
//		System.out.println(sumOfNode(root));
		preOrder(root);
		System.out.println();
//		postOrder(root);
//		System.out.println();
//		inOrder(root);
		System.out.print(greatestNode(root));
	}

}
