package leetcode;

import java.util.Arrays;
/* LeetCode 344. Reverse String 
 * #Top75
 */
public class ReverseString {

	public static void main(String[] args) {
		char[] s = new char[]{'H','a','n'};
		
        int low = 0;
        int high = s.length - 1;
        
        while (low < high) {
        	
        	char temp = s[low];
        	s[low] = s[high];
        	s[high] = temp;
        	
        	low++;
        	high--;
        }
		
		System.out.println(Arrays.toString(s));
	}

}
