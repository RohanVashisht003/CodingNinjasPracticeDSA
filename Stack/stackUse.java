package Stack;

public class stackUse {

	public static void main(String[] args) throws StackFullException, StackEmptyException {
		// TODO Auto-generated method stub
		stackUsingArray s = new stackUsingArray();
//		s.push(10);
//		s.push(20);
//		s.push(30);
//		s.push(40);
//		int topElement = s.top();
//		System.out.println(topElement);
		int poppedElement = s.pop();
		System.out.println(poppedElement);
		int size = s.size();
		System.out.println(size);
		boolean ans = s.isEmpty();
		System.out.println(ans);
	}

}
