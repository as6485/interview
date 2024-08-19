package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class RomanToInteger {
    public static void main(String[] args) {
        String s = "III";
        System.out.println(romanToInt(s));
    }

    private static int romanToInt(String s) {
        int sum = 0;
        int len = s.length();
        if(len == 0 )
            return sum;

        HashMap<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        Stack<Integer> stk = new Stack<>();

        while(len-1 >= 0){
            Integer val = map.get(s.charAt(len-1));
            if(stk.isEmpty() || val >= stk.peek()){
                stk.push(val);
            }
            else if(val < stk.peek()){
                val = stk.pop() - val;
                stk.push(val);
            }
            len--;
        }

        while(!stk.isEmpty()){
            sum+=stk.pop();
        }

        return sum;
    }
}
