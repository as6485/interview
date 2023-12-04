package leetcode;

import java.util.stream.IntStream;

public class SingleNumber {

    public static void main(String[] args) {
        int nums[] = new int[] {5, 3, 4, 5, 3};
        System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        int result = 0;
        for(int i=0; i<nums.length; i++){
            result = result ^ nums[i];
        }
        return result;
    }
}
