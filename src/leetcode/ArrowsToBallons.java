package leetcode;

import java.util.Arrays;

public class ArrowsToBallons {

    public static void main(String[] args) {
        //int[][] arr = new int[][] {{10,16},{2,8},{1,6},{7,12}};
        int[][] arr = new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}};
        System.out.println(Arrays.deepToString(arr));

        //Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        //System.out.println(Arrays.deepToString(arr));
        System.out.println("Min arrow : "+findMinArrowShots(arr));
    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        //Arrays.sort(points, (a, b) -> a[1] - b[1]);
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int arrowPos = points[0][1];
        int arrowCnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) {
                continue;
            }
            arrowCnt++;
            arrowPos = points[i][1];
        }
        return arrowCnt;
    }
}
