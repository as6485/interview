package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class EqualRowAndColumnPairs {
    public static void main(String[] args) {
        int[][] grid = {{3,2,1},{1,7,6},{2,7,7}};
        System.out.println(equalPairs(grid));
    }


    public static int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;
        HashMap<String, Integer> hm = new HashMap();
        for (int i=0; i<n; i++){
            String row = Arrays.toString(grid[i]);
            hm.put(row, hm.getOrDefault(row, 0)+1);
        }

        for(int j=0; j<n; j++){
            String column = Arrays.toString(getColumn(grid, j));
            count+=hm.getOrDefault(column, 0);
        }

        return count;
    }

    static int[] getColumn(int[][] matrix, int column) {
        return IntStream.range(0, matrix.length)
                .map(i -> matrix[i][column]).toArray();
    }
}
