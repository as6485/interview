package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }

    private static int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];
        List<int[]> list = new ArrayList<>();
        for (int[]interval : intervals) {
            int curStart = interval[0];
            int curEnd = interval[1];
            //this interval is before the new interval
            if (curEnd < start) {
                list.add(new int[]{curStart, curEnd});
            }
            //new interval is before this interval
            else if (curStart > end) {
                list.add(new int[]{start, end});
                start = curStart;
                end = curEnd;
            } else {
                start = Math.min(start, curStart);
                end = Math.max(end, curEnd);
            }
        }
        list.add(new int[]{start, end});
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }
        return res;
    }
}
