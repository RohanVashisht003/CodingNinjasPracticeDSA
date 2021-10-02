package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GtreeTest {

	public static void printLevelWise(GTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		Queue<GTreeNode<Integer>> nodes = new LinkedList<>();
		nodes.add(root);

		while (!nodes.isEmpty()) {
			GTreeNode<Integer> rn = nodes.remove();

			System.out.print(rn.data + " ");

			for (GTreeNode<Integer> child : rn.children) {
				nodes.add(child);
			}
		}
		System.out.println();
	}

	public static GTreeNode<Integer> takingInput() {
		Scanner scn = new Scanner(System.in);
		Queue<GTreeNode<Integer>> remainingNodes = new LinkedList<>();
		System.out.println("Enter the root data");
		int rootData = scn.nextInt();
		if (rootData == -1) {
			return null;
		}
		GTreeNode<Integer> root = new GTreeNode<Integer>(rootData);
		remainingNodes.add(root);
		while (!remainingNodes.isEmpty()) {
			GTreeNode<Integer> front = remainingNodes.remove();
			System.out.println("Enter the number of child for" + front.data);
			int numChild = scn.nextInt();
			for (int i = 0; i < numChild; i++) {
				System.out.println("Enter the" + i + "th child for" + front.data);
				int childData = scn.nextInt();
				GTreeNode<Integer> childNode = new GTreeNode<>(childData);
				front.children.add(childNode);
				remainingNodes.add(childNode);
			}
		}

		return root;
	}

	public static int numberOfNodes(GTreeNode<Integer> root) {
		int count = 1;
		for (int i = 0; i < root.children.size(); i++) {
			int childCount = numberOfNodes(root.children.get(i));
			count += childCount;
		}
		return count;
	}

	public static void printingBetter(GTreeNode<Integer> root) {
		System.out.print(root.data + ": ");
		for (int i = 0; i < root.children.size(); i++) {
			System.out.print(root.children.get(i).data + ", ");
		}
		System.out.println();
		for (int i = 0; i < root.children.size(); i++) {
			GTreeNode<Integer> child = root.children.get(i);
			printingBetter(child);
		}
	}

	public static void printing(GTreeNode<Integer> root) {
		if (root == null) {
			return;
		}

		System.out.print(root.data + " ");
		for (int i = 0; i < root.children.size(); i++) {
			GTreeNode<Integer> child = root.children.get(i);
			printing(child);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		GTreeNode<Integer> gt = new GTreeNode<>(4);
//		GTreeNode<Integer> gt2 = new GTreeNode<>(2);
//		GTreeNode<Integer> gt3 = new GTreeNode<>(3);
//		GTreeNode<Integer> gt4 = new GTreeNode<>(1);
//		GTreeNode<Integer> gt5 = new GTreeNode<>(5);
//		GTreeNode<Integer> gt6 = new GTreeNode<>(6);
//
//		gt.children.add(gt2);
//		gt.children.add(gt3);
//		gt.children.add(gt4);
//
//		gt3.children.add(gt5);
//		gt3.children.add(gt6);

//		printingBetter(gt);
//		System.out.println();
//		System.out.println("Size:- " + numberOfNodes(gt));

		GTreeNode<Integer> root = takingInput();
		printLevelWise(root);
	}

}
