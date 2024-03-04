package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {
        int [] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    public static int[] dailyTemperatures(int[] temps) {
        int[] results = new int[temps.length];
        Stack<Integer> stack = new Stack<>();
        /// UPVOTE !
        for (int i = 0; i < temps.length; i++) {
            while (!stack.isEmpty() && temps[stack.peek()] < temps[i]) {
                results[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }

        return results;
    }


    //brute force
    /*public static int[] dailyTemperatures(int[] temperatures) {
        int[] answers = new int[temperatures.length];
        for(int i = temperatures.length-1; i>=1; i--){
            for(int j = i-1; j>=0; j--){
                if(temperatures[i]>temperatures[j]){
                    answers[j] = i-j;
                }
            }
        }

        return answers;
    }*/

}
