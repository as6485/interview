package ctci.chapter1;

import java.util.Arrays;
import java.util.Collection;

/**
1.2 Check Permutation: Given two strings, write a method to decide if one is a permutation of the
other.
 *
 */

public class CheckPermutation {

	public static void main(String[] args) {
		String str1 = "hello";
		String str2 = "flloh";
		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		boolean flag = false;
		Arrays.sort(c1);
		Arrays.sort(c2);
		
		if((str1.length() == str2.length()) && String.valueOf(c1).equals(String.valueOf(c2))) {
			flag = true;
		}
		System.out.print(flag);
	}

}
