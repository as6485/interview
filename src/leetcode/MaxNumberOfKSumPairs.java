package leetcode;

import java.util.Arrays;

public class MaxNumberOfKSumPairs {

    public static void main(String[] args) {
        int[] nums = {4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4};
        int k = 2;
        System.out.println(maxOperations(nums, k));
    }

    public static int maxOperations(int[] nums, int k) {
        // Sorting the Array
        Arrays.sort(nums);
        //Initializing the Count
        int count=0;
        for(int i=0,j=nums.length-1; i<j;){
            //if Integer at i and j = equal, increment the Count and move the pointer
            if(nums[i]+nums[j]==k){
                count +=1;
                j--;
                i++;
            }
            // if the Integers at i and j are greater the k, we need the decrease the sum so we move the j pointer by -1
            else if(nums[i]+nums[j]>k){
                j--;
            }
            // else we increment the i pointer by +1
            else {
                i++;
            }
        }
        //Return the Count
        return count;
    }

    /*public static int maxOperations(int[] nums, int k) {
        int count = 0, key = -1, index = -1;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(nums[i] >= k)
                break;
            if(nums[i] == -1)
                continue;

            key=k-nums[i];
            nums[i] = -1;
            Arrays.sort(nums);
            index = Arrays.binarySearch(nums, key);
            if( index >= 0) {
                nums[index] = -1;
                count++;
            }
        }
        return count;
    }*/

}
