package leetcode;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        System.out.println(canPartition(arr));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int ele : nums ){
            sum+=ele;
        }
        if(sum%2!=0) return false;
        sum = sum/2;


        boolean dp[] =  new boolean[sum+1];
        // dp[i] =  means is it possible to make sum i using array element
        dp[0] =true;// if no element of array include then sum will be zero

        for(int num : nums){
            for(int i=sum;i>0;i--){
                if(i>=num){ // means required sum greater than num in nums
                    // dp[i] -  means if  num not inlcude ,
                    // dp[i-num] -  means if num included , ans will now depend on value of i-num in dp
                    dp[i] =  dp[i] || dp[i-num];
                }
            }
        }
        return dp[sum];

    }
}
