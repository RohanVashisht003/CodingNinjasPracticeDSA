package TriesAndHuffman;

public class TrieNode {
	char data;
	boolean isTerminal;
	TrieNode children[];
	int childCount=0;
	public TrieNode(char data) {
		this.data = data;
		this.isTerminal = false;
		this.children = new TrieNode[26];
	}	
}
