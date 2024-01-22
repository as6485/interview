package leetcode;

public class LongestSubarrayOf1 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        int ans = 0;
        int i = 0, j = 0, sum = 0;
        for (j=0; j < nums.length; j++) {
            sum += nums[j];
            if (sum < j - i)  {
                sum -= nums[i++];
            }
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}
