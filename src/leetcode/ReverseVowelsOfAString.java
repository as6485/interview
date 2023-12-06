package leetcode;

import java.util.List;

public class ReverseVowelsOfAString {

    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(reverseVowels(s));

    }
    public static String reverseVowels(String s) {
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] str = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (vowels.contains(str[left]) && vowels.contains(str[right])) {
                char temp = str[left];
                str[left] = str[right];
                str[right] = temp;
                left++;
                right--;
            } else if (!vowels.contains(str[left]) && !vowels.contains(str[right])) {
                left++;
                right--;
            } else if (!vowels.contains(str[left]) && vowels.contains(str[right])) {
                left++;
            } else if (vowels.contains(str[left]) && !vowels.contains(str[right])) {
                right--;
            }
        }
        return new String(str);
    }
}
