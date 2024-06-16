package leetcode;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }


    private static int[] plusOne(int[] digits) {
        int leastSignificant = digits.length-1;
        int sum = 0;

        while(true) {
            sum = digits[leastSignificant] + 1;
            if (sum < 10) {
                digits[leastSignificant] = sum;
                break;
            } else {
                digits[leastSignificant] = 0;
                leastSignificant--;
                if(leastSignificant < 0){
                    int[] arr = new int[digits.length+1];
                    arr[0] = 1;
                    return arr;
                }
            }
        }
        return digits;
    }
}
