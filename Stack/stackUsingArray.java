package Stack;

public class stackUsingArray {

	private int data[];
	private int topIndex;

	public stackUsingArray() {
		data = new int[10];
		topIndex = -1;
	}

	public void push(int i) throws StackFullException {
//		stack full exception
		if (topIndex == data.length - 1) {
			StackFullException e = new StackFullException();
			throw e;
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
