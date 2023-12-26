package leetcode;

import java.util.Arrays;
import java.util.List;

public class NonOverlappingIntervals {

    public static void main(String[] args) {
        //int[][] arr = new int[][] {{10,16},{2,8},{1,6},{7,12}};
        //int[][] arr = new int[][] {{1,2},{2,3},{3,4},{1,2}};
        //int[][] arr = new int[][] {{1,2},{1,2},{1,2}};
        int[][] arr = {{1,100},{11,22},{1,11},{2,12}};
        //int[][] arr = {{1,2},{1,3},{1,4}};
        System.out.println(Arrays.deepToString(arr));

        System.out.println(eraseOverlapIntervals(arr));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        System.out.println(Arrays.deepToString(intervals));
        int prev = 0;
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= intervals[prev][1]) {
                prev = i;
                count++;
            }
        }
        return n - count;
    }

    /*public static int eraseOverlapIntervals(int[][] intervals) {
        int count=0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        System.out.println(Arrays.deepToString(intervals));

        List<int[]> list = Arrays.stream(intervals).toList();
        list.forEach(v -> System.out.println(v[1]));

        for(int i=1; i<intervals.length; i++) {
            //detect overlap
            if(intervals[i-1][1] > intervals[i][0]){
                count++;
                //remove the interval with the maximum right span by setting it to 0
                if(intervals[i-1][1] >= intervals[i][1]){
                    intervals[i-1][0] = 0;
                    intervals[i-1][1] = 0;
                }
                else{
                    intervals[i][0] = 0;
                    intervals[i][1] = 0;
                }
            }
        }
        return count;
    }*/

}
