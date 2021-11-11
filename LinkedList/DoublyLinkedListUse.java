package LinkedList;

public class DoublyLinkedListUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.takeInput();
		dll.print();
		System.out.println();
//	System.out.println(dll.getFirst());
//	System.out.println(dll.getLast());
//		System.out.println(dll.getAt(0));
//		System.out.println(dll.getAt(4));
//		System.out.println(dll.getAt(2));
		
//		dll.addAt(0,10);
//		dll.print();
//		System.out.println();
//		System.out.println(dll.size());
//		System.out.println(dll.getFirst());
//		System.out.println(dll.getLast());
		
		dll.removingAt(2);
		dll.print();
	}

}
