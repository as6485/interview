package leetcode;

import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        String s = "cars";
        List<String> wordDict = List.of("car","ca","rs");
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> dict) {
        if (s == null || s.length() == 0) return false;
        int n = s.length();
        // dp[i] represents whether s[0...i] can be formed by dict
        boolean[] dp = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);
                if (dict.contains(sub) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n - 1];
    }


    //my naive approach doesn't cover all scenarios
    /*public static boolean wordBreak(String s, List<String> wordDict) {
        String t = helper(s, wordDict);
        while(t.length() < s.length()){
            if(t.isEmpty())
                return true;
            else {
                s = t;
                t = helper(s, wordDict);
            }
        }
        return false;
    }

    public static String helper(String s, List<String> wordDict) {
        for(String word:wordDict){
            if(s.length()>= word.length() && word.equals(s.substring(0,word.length()))){
                return s.substring(word.length());
            }
        }
        return s;
    }*/

}
