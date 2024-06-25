package leetcode;

import java.util.HashMap;

public class IsomorphicString {

    public static void main(String[] args) {
        String s="badc", t="baba";
        System.out.println(isIsomorphic(s,t));
    }

        private static boolean isIsomorphic(String s, String t) {
            HashMap<Character, Character> map = new HashMap<Character, Character>();

            for(int i = 0 ; i< s.length(); i++){
                char k = s.charAt(i);
                char v = t.charAt(i);

                if(map.containsKey(k) && !map.get(k).equals(v)) return false; // Fail if the key is mapped to a different value

                if(!map.containsKey(k) && map.containsValue(v)) return false; // Fail if the value is mapped to a different key

                map.put(k, v);  // Map the key and value
            }

            return true;
        }
}
