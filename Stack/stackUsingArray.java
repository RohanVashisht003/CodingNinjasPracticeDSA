package Stack;



public class stackUsingArray {

	private int data[];
	private int topIndex;

	public stackUsingArray() {
		data = new int[10];
		topIndex = -1;
	}

	public stackUsingArray(int size) {
		data = new int[size];
		topIndex = -1;
	}

//	doubling stack capacity
	public void doubleCapacity() {
		int doubleData[] = new int[2 * data.length];
		for (int i = 0; i < data.length; i++) {
			doubleData[i] = data[i];
		}
		data = doubleData;
	}

	public void push(int i) {
//		stack full exception
		if (topIndex == data.length - 1) {
			doubleCapacity();
		}
		topIndex++;
		data[topIndex] = i;
	}

	public int top() throws StackEmptyException {
//		stack empty exception
		if (topIndex == -1) {
//			StackEmptyException e = new StackEmptyException();
//			throw e;

//			or

			throw new StackEmptyException();
		}
		return data[topIndex];
	}

	public int size() {
		return topIndex + 1;
	}

	public boolean isEmpty() {
		return topIndex == -1;
	}

	public int pop() throws StackEmptyException {
		// TODO Auto-generated method stub
//		stack empty exception
		if (topIndex == -1) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		int removedElement = data[topIndex];
		topIndex--;
		return removedElement;

	}

}
