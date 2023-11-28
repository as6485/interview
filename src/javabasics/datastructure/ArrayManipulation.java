package javabasics.datastructure;

import java.util.Arrays;

//https://www.baeldung.com/java-util-arrays
public class ArrayManipulation {

	public static void main(String[] args) {
		String[] intro = new String[] { "once", "upon", "a", "time" };

		System.out.println("---- copyOfRange ------");
		
		String[] abridgement = Arrays.copyOfRange(intro, 0, 3); //from is inclusive but to is exclusive
		for(String str : abridgement) {
			System.out.println(str);
		}
				
		System.out.println("---- equals ------");
		System.out.println(Arrays.equals(new String[] { "once", "upon", "a", "time" }, intro));
		
		
				
		System.out.println("---- sort ------");
		Arrays.sort(intro);
		for(String str : intro) {
			System.out.println(str);
		}
		
		System.out.println("---- binarySearch ------");
		System.out.println(Arrays.binarySearch(intro, "time"));
		System.out.println(Arrays.binarySearch(intro, "TIME", String::compareToIgnoreCase));
		
		System.out.println("---- stream ------");		
		Arrays.stream(intro).map(v -> v.toUpperCase()).forEach(System.out::println);
		
	}
}
