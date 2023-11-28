package javabasics.datastructure;

import java.util.*;

public class ListExamples {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		LinkedList<String> ll = new LinkedList<>();
		Integer arr1[] = {1, 2, 3, 4, 5};
		int arr2[] = {6, 7, 8, 9, 10};
		List<Integer> list;
		
		al.add(3);
		al.add(1);
		al.add(2);
		
		ll.add("Mango");
		ll.add("Apple");
		ll.add("Grapes");
		ll.add("Orange");
		ll.add("Grapes");
		
		System.out.println("---- ArrayList supports dynamic arrays that can grow ------");
		al.forEach(v->System.out.println(v));
		System.out.println(al.contains(3));		
		
		
		System.out.println("---- Converting an Integer arr to list----------------------");
		list = Arrays.asList(arr1);
		list.forEach(v->System.out.println(v));
		
		//this does not work on primitive int
		list = Arrays.stream(arr2).boxed().toList();
		list.forEach(v->System.out.println(v));
		
		System.out.println("---- List.of method from Java 9 ----------------------");
		list = List.of(10, 20, 30);
		list.forEach(v->System.out.println(v));
		
		System.out.println("---- LinkedList provides a linked list data structure ------");
		//System.out.println(ll.peek());
		//ll.forEach(v->System.out.println(v));
		System.out.println(ll.toString());
		
		
		
	}
}
