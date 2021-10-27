package TriesAndHuffman;

import java.util.Scanner;

public class TrieUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		Trie T = new Trie();
		for (int i = 1; i <= 4; i++) {
			String word = scn.next();
			T.add(word);
		}
System.out.println(T.search("no"));
	}

}
