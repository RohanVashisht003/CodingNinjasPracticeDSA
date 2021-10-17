package Queues;

import java.util.Stack;

public class queueUsingTwoStacks<T> {

	private Stack<T> s1;
	private Stack<T> s2;

	public queueUsingTwoStacks() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}

	public void enqueue(T item) {
		s1.add(item);
	}

	public T dequeue() {
		while (s1.size() != 1) {
			T item = s1.pop();
			s2.push(item);
		}
		T frontEle = s1.pop();
		while (!s2.empty()) {
			s1.push(s2.pop());
		}
		return frontEle;
	}

	public boolean isEmpty() {
		return s1.isEmpty();
	}

	public int size() {
		return s1.size();
	}

	public T front() {
		while (s1.size() != 1) {
			T item = s1.pop();
			s2.push(item);
		}
		T frontEle = s1.peek();
		while (!s2.isEmpty()) {
			s1.push(s2.pop());
		}
		return frontEle;
	}
}
