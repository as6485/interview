package ctci.chapter1;

/**
 * 1.1 Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
	cannot use additional data structures?
 */
public class IsUnique {

	public static void main(String []args) {
		String str = "Hello World!";
		boolean isUniqueStr = true;
		for(int i = 0; i< str.length(); i++) {
			System.out.print(str.charAt(i));
		}
		
	}
	
}
