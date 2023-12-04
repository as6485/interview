package leetcode;

import java.util.HashMap;

public class TribonacciNumber {


    public static void main(String[] args) {
        int n = 4;
        System.out.println(tribonacci(n));
    }

    private static int tribonacci(int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        return tribonacciMap(n, hm);
    }


    private static int tribonacciMap(int n, HashMap<Integer, Integer> hm) {
        int answer =0;

        if(hm.containsKey(n)){
            return hm.get(n);
        }

        if(n == 0 || n == 1) {
            answer = n;
            hm.put(n, answer);
        }
        else if(n==2) {
            answer = 1;
            hm.put(n, answer);
        }
        else {
            answer  = tribonacciMap(n-1, hm)+tribonacciMap(n-2, hm)+tribonacciMap(n-3, hm);
            hm.put(n, answer);
        }

        return answer;
    }
}
