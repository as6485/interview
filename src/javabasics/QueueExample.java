package javabasics;
import java.util.*;

public class QueueExample {

	public static void main(String[] args) {
		// Creating empty priority queue
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

		// Adding items to the pQueue using add()
		pQueue.add(10);
		pQueue.add(20);
		pQueue.add(17);
		pQueue.add(15);

		System.out.println("Printing the top element of PriorityQueue");
		System.out.println(pQueue.peek());

		System.out.println("Printing the top element and removing it from the PriorityQueue container");
		System.out.println(pQueue.poll());

		System.out.println("Printing the top element of PriorityQueue");
		System.out.println(pQueue.peek());
		
		System.out.println("Iterating with forEach");
		pQueue.forEach(v -> System.out.println(v));
	}

}
