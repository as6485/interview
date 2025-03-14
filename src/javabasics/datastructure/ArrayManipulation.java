package javabasics.datastructure;

import java.util.Arrays;
import java.util.List;

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

		System.out.println("---- array <---> list ------");
		List<String> list = Arrays.asList(intro);
		list.forEach(System.out::println);

		Object[] objArr = list.toArray();
		System.out.println(Arrays.toString(objArr));
				
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


		System.out.println("---- 2D Array ------");
		int[][] arr = new int[][] {{10,16},{2,8},{1,6},{7,12}};
		System.out.println(Arrays.deepToString(arr));

		Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
		System.out.println(Arrays.deepToString(arr));
	}
}
