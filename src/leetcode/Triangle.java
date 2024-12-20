package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(2));
        triangle.add(List.of(3,4));
        triangle.add(List.of(6,5,7));
        triangle.add(List.of(4,1,8,3));
        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        // create dp table with size of the largest column (which is number of rows)
        int[] table = new int[triangle.size() + 1];
        Arrays.fill(table, 0);

        // iterate over the entire triangle from bottom to top
        for (int row = triangle.size() - 1; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                // either go to [row + 1, col] or [row + 1, col + 1]
                int remain = Math.min(table[col],
                        table[col + 1]);

                // combine answer with current value
                table[col] = triangle.get(row).get(col) + remain;
            }
        }

        return table[0];
    }

}
