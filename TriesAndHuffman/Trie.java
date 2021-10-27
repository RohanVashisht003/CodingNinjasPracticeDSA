package TriesAndHuffman;

import java.util.ArrayList;

public class Trie {

	private TrieNode root;
	public int count;
	public Trie() {

		root = new TrieNode('\0');
	}

	private void addHelper(TrieNode root, String word) {
		if (word.length() == 0) {
			root.isTerminal = true;
			return;
		}
		int childIndex = word.charAt(0) - 'A';
		TrieNode child = root.children[childIndex];
		if (child == null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		addHelper(child, word.substring(1));
	}

	public void add(String word) {
		addHelper(root, word);
	}

	public boolean searchHelper(TrieNode root, String word) {
		if (word.length() == 0) {
			return root.isTerminal;
		}
		int childIndex = word.charAt(0) - 'A';
		TrieNode child = root.children[childIndex];
		if (child == null) {
			return false;
		}
		return searchHelper(child, word.substring(1));
	}

	public boolean search(String word) {
		return searchHelper(root, word);
	}

	private void removeHelper(TrieNode root, String word) {
		if (word.length() == 0) {
			root.isTerminal = false;
			return;
		}
		int childIndex = word.charAt(0) - 'A';
		TrieNode child = root.children[childIndex];
		if (child == null) {
			return;
		}
		removeHelper(child, word.substring(1));
		if (!child.isTerminal && child.childCount == 0) {
			root.children[childIndex] = null;
			root.childCount--;
		}
	}

	public void remove(String word) {
		removeHelper(root, word);
	}

	public TrieNode findRoot(TrieNode root, String word) {
		if(word.length()==0) {
			return root;
		}
		int childIndex = word.charAt(0)-'a';
		TrieNode child = root.children[childIndex];
		if(child==null) {
			return null;
		}
		return findRoot(child,word.substring(1));
	}
	
	public void autoComplete(ArrayList<String> input,String word) {
		for(String w:input) {
			add(w);
		}
		TrieNode node = findRoot(root,word);
		if(node==null || node.childCount==0) {
			return;
		}
		String output="";
		allRootToLeafPaths(node,output, word);
			

	}
	
	private void allRootToLeafPaths(TrieNode node, String output, String word) {
		
		if(node.childCount==0) {
			if(output.length()>0) {
				System.out.println(word+output);
			}
			return;
		}
		
		if(node.isTerminal==true) {
			System.out.println(word+output);
		}
		for(int i=0; i<node.children.length; i++) {
			if(node.children[i]!=null) {
				String ans = output+node.children[i].data;
				allRootToLeafPaths(node.children[i], ans, word);
			}
		}
		
	}
}
