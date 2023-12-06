package leetcode;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    /*public static void moveZeroes(int[] nums) {
        int left = 0, right = 1;

        while(right < nums.length){
            if(nums[left] != 0){
                left++;
            }
            else if(nums[left] == 0 && nums[right] !=0){
                nums[left] = nums[right];
                nums[right] = 0;
                left++;
            }
            right++;
        }
    }*/

    public static void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
}
