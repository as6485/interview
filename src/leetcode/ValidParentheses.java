package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "(){}}{";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for(int i =0; i<s.length(); i++){
            if(map.get(s.charAt(i))!=null){
                stack.push(map.get(s.charAt(i)));
            }
            else if(!stack.empty() && stack.peek().equals(s.charAt(i))){
                stack.pop();
            }
            else {
                return false;
            }

        }

        if(stack.empty())
            return true;
        else
            return false;
    }
}
