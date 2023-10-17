package javabasics;

import java.util.*;

public class SubstringExample {

	public static void main(String args[]) {
		String s1 = "javatpoint";

		System.out.println(s1.substring(0, 4));// returns va
		System.out.println(s1.substring(2));// returns vatpoint

		System.out.println("---------------- split ----------------");
		String s2 = "java string split method by javatpoint";
		String[] words = s2.split("\\s");
		// splits the string based on whitespace

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
