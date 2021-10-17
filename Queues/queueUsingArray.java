package Queues;

public class queueUsingArray {

	private int data[];
	private int frontIndex;
	private int rearIndex;
	private int size;

	public queueUsingArray() {
		data = new int[5];
		frontIndex = -1;
		rearIndex = -1;
	}

	public queueUsingArray(int capacity) {
		data = new int[capacity];
		frontIndex = -1;
		rearIndex = -1;
	}

//	Functions

	public void doubleQueueSize() {
		int[] temp = new int[2 * data.length];
		for (int i = 0; i < data.length; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void enqueue(int item) {
		if (rearIndex == data.length - 1) {
			doubleQueueSize();
		}
		if (size == 0) {
			frontIndex++;
			rearIndex++;
		} else {
			rearIndex++;
		}
		data[rearIndex] = item;
		size++;
	}

	public void enqueueCircular(int item) {
		if (size == 0) {
			frontIndex++;
			rearIndex++;
		} else {
			rearIndex++;
		}
//		if (rearIndex == data.length) {
//			rearIndex = 0;
//		}
		rearIndex = (rearIndex + 1) % data.length;
		data[rearIndex] = item;
		size++;
	}

	public int front() throws queueEmptyException {
//		queue empty exception
		if (size == 0) {
			throw new queueEmptyException();
		}
		return data[frontIndex];
	}

	public int dequeue() throws queueEmptyException {
		if (frontIndex == -1) {
			throw new queueEmptyException();
		}
		int deletedData = data[frontIndex];
		frontIndex++;
//		if (frontIndex == data.length) {
//			frontIndex = 0;
//		}
		frontIndex = (frontIndex + 1) % data.length;
		size--;
		return deletedData;
	}

}
