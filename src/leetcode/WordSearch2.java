package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSearch2 {
    public static void main(String[] args) {
        char[][] arr = new char[][] {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = new String[]{"oath","pea","eat","rain","hklf", "hf"};
        System.out.println(findWords(arr, words));
    }

    private static List<String> findWords(char[][] arr, String[] words) {
        List<String> result = new ArrayList<>();
        char[][] backupArr = deepCopy(arr);
        for(String word : words){
            if(isWordPresent(word, arr)){
                result.add(word);
            }
            arr = deepCopy(backupArr);
        }

        return result;
    }

    private static boolean isWordPresent(String word, char[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int pos = 0;

        for(int i =0; i < row; i++){
            for(int j =0; j < col; j++){
                if(arr[i][j] == word.charAt(pos) && helper(arr, i , j, word, pos))
                    return true;
            }
        }
        return false;
    }

    private static boolean helper(char[][] arr, int i, int j, String word, int pos) {
        if(i < 0 || i >= arr.length || j < 0 || j >= arr[0].length)
            return false;

        if(arr[i][j] == word.charAt(pos)){
            arr[i][j] = '0';
            if(pos <= word.length() - 2){
                return (
                        helper(arr, i+1, j, word, pos+1)
                     || helper(arr, i-1, j, word, pos+1)
                     || helper(arr, i, j+1, word, pos+1)
                     || helper(arr, i, j-1, word, pos+1)
                        );
            }
            else
                return true;
        }
        return false;
    }

    private static char[][] deepCopy(char[][] grid) {
        return Arrays.stream(grid).map(char[]::clone).toArray(char[][]::new);
    }
}
