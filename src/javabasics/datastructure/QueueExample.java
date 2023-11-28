package javabasics.datastructure;
import java.util.*;

public class QueueExample {

	public static void main(String[] args) {
		// Creating empty priority queue
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
		Deque<Integer> dq = new ArrayDeque<Integer>();

		// Adding items to the pQueue using add()
		pQueue.add(10);
		pQueue.add(20);
		pQueue.add(17);
		pQueue.add(15);

		System.out.println("Iterating with forEach");
		pQueue.forEach(v -> System.out.println(v));

		System.out.println("Printing the head element of PriorityQueue");
		System.out.println(pQueue.peek());


		System.out.println("Printing the head element and removing it from the PriorityQueue container");
		System.out.println(pQueue.poll());

		System.out.println("Printing the head element of PriorityQueue");
		System.out.println(pQueue.peek());
		
		System.out.println("Iterating with forEach doesn't guarantee order");
		pQueue.forEach(v -> System.out.println(v));

		System.out.println("peek/poll/remove guarantees to return least element");
		while (!pQueue.isEmpty())
			System.out.println(pQueue.remove());

		System.out.println("******************* ArrayDeque *************************");

		//add to tail
		dq.offer(20);
		dq.add(15);
		dq.offerLast(40);
		System.out.println("Iterating :");
		dq.forEach(v -> System.out.println(v));

		//add to head
		dq.offerFirst(30);
		System.out.println("Iterating :");
		dq.forEach(v -> System.out.println(v));

		System.out.println("Peek first element : ");
		System.out.println(dq.peek());
		System.out.println(dq.peekFirst());

		System.out.println("Peek last element : ");
		System.out.println(dq.peekLast());

		System.out.println("Iterating :");
		dq.forEach(v -> System.out.println(v));
	}

}
