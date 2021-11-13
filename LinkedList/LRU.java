package LinkedList;

import java.util.HashMap;
import java.util.Scanner;

class LRUCache {

class Node {
		int key, value;
		Node prev;
		Node next;
	}

	HashMap<Integer, Node> cache;
	int cap;
	Node head, tail;

	LRUCache(int capacity) {
		cap = capacity;
		cache = new HashMap<>();
		head = new Node();
		tail = new Node();

		head.next = tail;
		tail.prev = head;
	}

	private void addNodeFirst(Node node) {
		Node forwardNode = head.next;

		node.next = forwardNode;
		node.prev = head;

		forwardNode.prev = node;
		head.next = node;
	}

	private void removeNode(Node node) {
		Node backwardNode = node.prev;
		Node forwardNode = node.next;

		backwardNode.next = forwardNode;
		forwardNode.prev = backwardNode;

		node.next = null;
		node.prev = null;

	}

	private void moveToFront(Node node) {
		removeNode(node);
		addNodeFirst(node);
	}

	public int get(int key) {
		Node node = cache.get(key);
		if (node == null) {
			return -1;
		} else {
			int v1 = node.value;
			moveToFront(node);
			return v1;
		}
	}

	// app name, app state
	public void put(int key, int value) {
		Node node = cache.get(key);
		if (node == null) {
			Node newNode = new Node();
			newNode.key = key;
			newNode.value = value;
			if (cache.size() == cap) {
				Node LRU_Node = tail.prev;
				cache.remove(LRU_Node.key);
				removeNode(LRU_Node);
			} else {
				cache.put(key, newNode);
				addNodeFirst(newNode);
			}
		} else {
			node.value = value;
			moveToFront(node);
		}
	}

}

//main
public class LRU {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt(); // no of operations
		// 0 stand for put, 1 stand for get
		int size = scn.nextInt();
		LRUCache lru = new LRUCache(size);

		while (n-- > 0) {
			int op = scn.nextInt();
			if (op == 0)
				lru.put(scn.nextInt(), scn.nextInt());
			else
				System.out.println(lru.get(scn.nextInt()));
		}
	}

}
