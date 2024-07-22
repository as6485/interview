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

		System.out.println("---------------- char array to String ----------------");
		char[] chArr = {'a', 'b', 'c'};
		String strFromCharArr = new String(chArr);
		System.out.println(strFromCharArr);

		System.out.println("---------------- String to char array ----------------");
		String s3 = "ThisIsAString";

		//get the whole string as a char array
		char[] charArrFromStr = s3.toCharArray();
		System.out.println(charArrFromStr);

		//more flexibility on from/to index for partial read
		charArrFromStr = new char[s3.length()];
		s3.getChars(0,
				s3.length(),
				charArrFromStr,
				0
				);
		System.out.println(charArrFromStr);

		System.out.println("---------------- int/Integer <---> String ----------------");
		int i1 = 5;
		Integer i2 = 10;

		System.out.println(String.valueOf(i1));
		System.out.println(String.valueOf(i2));

		System.out.println("---------------- String <---> int/Integer ----------------");
		String strInteger = "12345";
		int i3 = Integer.parseInt(strInteger);
		Integer i4 = Integer.valueOf(strInteger);

		System.out.println(i3 + " " + i4);

		System.out.println("---------------- stream ----------------");

		String hello = "Hello World";

		hello.chars()
		.mapToObj(c -> (char) c)  //convert the IntStream back to char
		.map(c -> c.toLowerCase(c))
		.filter(c -> c!=null)
		.forEach(c -> System.out.println(c));

	}
}
