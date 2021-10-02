package Trees;

import java.util.ArrayList;

public class GTreeNode<T> {
	T data;
	ArrayList<GTreeNode<T>> children;
	
	public GTreeNode(T data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.children = new ArrayList<>();
	}
}
