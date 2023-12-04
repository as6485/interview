package leetcode;

import java.util.Arrays;

public class MergeStringsAlternately {
    public static void main(String[] args) {
        String word1 = "abcd";
        String word2 = "pq";
        System.out.println(mergeAlternately(word1, word2));
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder("");
        int length1 = word1.length();
        int length2 = word2.length();
        int i,j =0;
        for(i=0; i< length1; i++){
            result.append(word1.charAt(i));
            if(j<length2){
                result.append(word2.charAt(j));
                j++;
            }
        }

        if(j<length2){
            while(j<length2) {
                result.append(word2.charAt(j));
                j++;
            }
        }

        return result.toString();
    }
}
