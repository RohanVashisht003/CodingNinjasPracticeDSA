package Trees;

public class nodesWithoutSiblings extends binaryTreeUse {

	public static void printSiblings(binaryTreeNode<Integer> root) {
		if(root==null) {
			return ;
		}
		
		if (root.left != null && root.right != null) {
			printSiblings(root.left);
			printSiblings(root.right);
		} else if (root.left != null) {
			System.out.print(root.left.data);
			printSiblings(root.left);
		} else if (root.right != null) {
			System.out.print(root.right.data);
			printSiblings(root.right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		binaryTreeNode<Integer> root = takeInputBetter(true, 0, false);
		printSiblings(root);
	}

}
