package Trees;

public class numberOfLeafNodes extends binaryTreeUse {

	public static int leafNodes(binaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		}
		int left = leafNodes(root.left);
		int right = leafNodes(root.right);
		return left + right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		binaryTreeNode<Integer> root = takeInputBetter(true, 0, false);
		System.out.println(leafNodes(root));
	}

}
