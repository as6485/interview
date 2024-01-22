package leetcode;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 3;
        System.out.println(longestOnes(nums, k));
    }

    public static int longestOnes(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int zeros = 0;

        while (end < nums.length) {
            if (nums[end] == 0) {
                zeros++;
            }
            end++;
            if (zeros > k) {
                if (nums[start] == 0) {
                    zeros--;
                }
                start++;
            }
        }
        return end - start;
    }

    /*public static int longestOnes(int[] nums, int k) {
        int previousMaxWindowSize = 0;
        int zeroesFound = 0;
        int j = 0;
        for(int i=0; i<nums.length; i++){
            j = i;
            while(j<nums.length && ((zeroesFound < k) || nums[j] == 1)){
                if(nums[j] == 0)
                    zeroesFound++;
                j++;
            }
            zeroesFound = 0;
            previousMaxWindowSize = Math.max(previousMaxWindowSize, (j-i));
        }

        return previousMaxWindowSize;
    }*/
}
