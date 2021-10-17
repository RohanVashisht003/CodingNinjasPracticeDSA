package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class stackUsingTwoQueues<T> {

	private Queue<T> q1;
	private Queue<T> q2;

	public stackUsingTwoQueues() {
		q1 = new LinkedList<T>();
		q2 = new LinkedList<T>();
	}

	public void enqueue(T item) {
		q2.add(item);

		while (!q1.isEmpty()) {
			q2.add(q1.poll());
		}

//		swap names of two queues
		Queue<T> q = q1;
		q1 = q2;
		q2 = q;
	}

	public int size() {
		return q1.size();
	}

	public T dequeue() {
		T deletedItem = q1.poll();
		return deletedItem;
	}

	public boolean isEmpty() {
		return q1.isEmpty();
	}

	public T front() {
		T poppedItem = q1.peek();
		return poppedItem;
	}
}
