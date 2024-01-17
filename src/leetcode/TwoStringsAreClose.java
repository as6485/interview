package leetcode;

import java.util.HashMap;
import java.util.List;

public class TwoStringsAreClose {

    public static void main(String[] args){
        String word1 = "aaabbbbccddeeeeefffff", word2 = "aaaaabbcccdddeeeeffff";
        System.out.println(closeStrings(word1, word2));
    }

    public static boolean closeStrings(String word1, String word2) {
        if(word1 == null || word1.isEmpty() || word2 == null || word2.isEmpty())
            return false;

        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();

        word1.chars().mapToObj(c -> (char) c).toList().forEach(c -> {
            hm1.put(c, hm1.getOrDefault(c, 0) + 1);
        });

        word2.chars().mapToObj(c -> (char) c).toList().forEach(c -> {
            hm2.put(c, hm2.getOrDefault(c, 0) + 1);
        });

        if(!hm1.keySet().equals(hm2.keySet())){
            return false;
        }

        List<Integer> ll1 = hm1.values().stream().sorted().toList();
        List<Integer> ll2 = hm2.values().stream().sorted().toList();
        if(!ll1.equals(ll2))
            return false;


        return true;
    }


}
