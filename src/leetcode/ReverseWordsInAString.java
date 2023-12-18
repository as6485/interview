package leetcode;

import java.util.Stack;

public class ReverseWordsInAString {

    public static void main(String[] args) {
        String s = "  a good   example  ";
        //System.out.println(reverseWords(s));
        System.out.println(reverseWordsWithRegex(s));
    }

    public static String reverseWords(String s) {
        Stack<String> stk = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        int start = -1, end = 0;
        for(end = 0; end < s.length(); end++)
        {
            if(s.charAt(end) == ' '){
                if(s.charAt(start+1) != ' '){
                    String word = s.substring(start+1, end);
                    stk.push(word);
                }
                start = end;
            }
        }

        if(end == s.length()){
            String word = s.substring(start+1, end);
            stk.push(word);
        }

        while(!stk.empty()){
            sb.append(stk.pop() + ' ');
        }

        return sb.toString().trim();
    }


    public static String reverseWordsWithRegex(String s) {
        /* Trim the input string to remove leading and trailing spaces
        regular expression "\s+" matches one or more whitespace characters,
        effectively separating the words. */
        String[] str = s.trim().split("\\s+");

        // Initialize the output string
        String out = "";

        // Iterate through the words in reverse order
        for (int i = str.length - 1; i > 0; i--) {
            // Append the current word and a space to the output
            out += str[i] + " ";
        }

        // Append the first word to the output (without trailing space)
        return out + str[0];
    }

}
