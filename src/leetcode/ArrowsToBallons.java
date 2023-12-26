package leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrowsToBallons {

    public static void main(String[] args) {
        int[][] arr = new int[][] {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(Arrays.deepToString(arr));

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        System.out.println(Arrays.deepToString(arr));

    }

    public static int findMinArrowShots(int[][] points) {

        return 0;
    }
}
