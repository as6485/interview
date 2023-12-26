package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        int length = digits.length();
        if(length == 0){
            return result;
        }
        HashMap<Integer, String> dialpad = new HashMap<>();
        dialpad.put(2, "abc");
        dialpad.put(3, "def");
        dialpad.put(4, "ghi");
        dialpad.put(5, "jkl");
        dialpad.put(6, "mno");
        dialpad.put(7, "pqrs");
        dialpad.put(8, "tuv");
        dialpad.put(9, "wxyz");

        for(int i = 0; i < length; i++){
            Integer integer = Character.getNumericValue(digits.charAt(i));
            result = combine(result, dialpad.get(integer));
        }
        return result;
    }

    private static List<String> combine(List<String> result, String str) {
        List<String> combinedResult  = new ArrayList<>();
        for(int i = 0; i< str.length(); i++){
            if(result.isEmpty()) {
                combinedResult.add(String.valueOf(str.charAt(i)));
            }else{
                for (String rs : result) {
                    combinedResult.add(rs + String.valueOf(str.charAt(i)));
                }
            }
        }

        return combinedResult;
    }


    public static void main(String args[]){
        System.out.println(letterCombinations("92"));
    }

}
