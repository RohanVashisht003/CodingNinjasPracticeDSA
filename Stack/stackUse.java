package Stack;

public class stackUse {

	public static void main(String[] args) throws StackFullException, StackEmptyException {
		// TODO Auto-generated method stub
//		stackUsingArray s = new stackUsingArray(4);
//		for (int i = 0; i < 8; i++) {
//			s.push(i + 10);
//		}
//		s.push(18);
//		s.push(19);
//		for (int i = 0; i < 8; i++) {
//			System.out.println(s.top());
//		}
//		System.out.println(s.size());
		
		stackUsingLinkedList<Integer> s2 = new stackUsingLinkedList<>();
		
		for(int i=0; i<4; i++) {
			s2.push(i+10);
		}
		
	System.out.println(s2.top());
		
		System.out.println(s2.size());
	}

}
