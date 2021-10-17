package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class quequeUse {

	public static void main(String[] args) throws queueEmptyException {
		// TODO Auto-generated method stub
//		queueUsingArray q = new queueUsingArray();
//		for(int i=0; i<6; i++)
//			q.enqueue(i+10);
//		System.out.println(q.size());
//		System.out.println(q.dequeue());
//		System.out.println(q.size());

//		queueUsingArray q = new queueUsingArray(3);
//		q.enqueueCircular(10);
//		q.enqueueCircular(20);
//		q.enqueueCircular(30);
//	
//		System.out.println(q.dequeue());
//		q.enqueueCircular(80);

//		queueUsingLinkedList<Integer> q = new queueUsingLinkedList<>();
//		for (int i = 0; i < 5; i++) {
//			q.enqueue(i);
//		}
//		System.out.println(q.front());
//		System.out.println(q.dequeue());
//		System.out.println(q.front());
//		System.out.println(q.size());

//		Queue<Integer> q = new LinkedList<>();
//		q.add(10);
//		q.size();
//		System.out.println(q.peek());
//		System.out.println(q.poll());
//		q.size();
		
		queueUsingTwoStacks<Integer> qs = new queueUsingTwoStacks<>();
		qs.enqueue(10);
		qs.enqueue(20);
		qs.enqueue(30);
		qs.enqueue(40);
		
		System.out.println(qs.front());
		System.out.println(qs.dequeue());
		System.out.println(qs.size());
		System.out.println(qs.dequeue());
	}
}
