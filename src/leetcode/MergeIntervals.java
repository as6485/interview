package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Stack<int[]> stack = new Stack<>();

        //push first element to stack
        stack.push(intervals[0]);

        //compare and merge intervals
        for(int i=1; i<intervals.length; i++){
            int[] top = stack.peek();
            if(top[1] >=  intervals[i][0]){
                int[] merged = new int[2];
                int[] popped = stack.pop();
                if (popped[1]>=intervals[i][1]){
                    merged = new int[]{popped[0], popped[1]};
                }else {
                    merged = new int[]{popped[0], intervals[i][1]};
                }
                stack.push(merged);
            }
            else{
                stack.push(intervals[i]);
            }
        }

        //prepare result
        int k = stack.size();
        int[][] result = new int[k][2];

        while(!stack.empty()){
            result[k-1] = stack.pop();
            k--;
        }


        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(arr)));
    }
}
