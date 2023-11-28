package javabasics.datastructure;

public class StringExample {

	public static void main(String args[]) {
		String s1 = "javatpoint";

		System.out.println(s1.substring(2, 5));// returns vat. start index inclusive but end index is exclusive
		System.out.println(s1.substring(5));// returns point

		System.out.println("---------------- split ----------------");
		String s2 = "java string split by space";
		String[] words = s2.split("\\s");	// splits the string based on whitespace

		for (String w : words) {
			System.out.println(w);
		}

		System.out.println("---------------- stream ----------------");

		String hello = "Hello World";

		hello.chars()
		.mapToObj(c -> (char) c)  //convert the IntStream back to char
		.map(c -> c.toLowerCase(c))
		.filter(c -> c!=null)
		.forEach(c -> System.out.println(c));

	}
}
