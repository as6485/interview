package javabasics.datastructure;

import java.util.*;

public class SetExamples {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		TreeSet<String> ts = new TreeSet<String>();
		
		hs.add("Banana");
		hs.add("Apple");
		hs.add("Cucumber");
		hs.add("Fig");
		
		lhs.add("Banana");
		lhs.add("Apple");
		lhs.add("Cucumber");
		
		ts.add("Banana");
		ts.add("Apple");
		ts.add("Cucumber");
		
		
		System.out.println("---------------- HashSet uses hashing-----------------------");
		hs.forEach(v -> System.out.println(v));
		
		System.out.println("------ LinkedHashSet maintains order of insertion ---------");
		lhs.forEach(v -> System.out.println(v));
		
		System.out.println("------- TreeSet gives a sorted tree -----------------------");
		ts.forEach(v -> System.out.println(v));
		
		System.out.println("------- set operations -----------------------");
		System.out.println(ts.contains("Apple"));
		SortedSet ss = ts.headSet("Cucumber");
		ss.forEach(v -> System.out.println(v));

		System.out.println("------- Union-----------");
		hs.addAll(lhs);
		hs.forEach(v -> System.out.println(v));

		System.out.println("------- Intersection -----------");
		hs.retainAll(lhs);
		hs.forEach(v -> System.out.println(v));

		System.out.println("------- Difference -----------");
		hs.add("Fig"); //adding back Fig removed by Intersection
		hs.removeAll(lhs);
		hs.forEach(v -> System.out.println(v));
	}
}
