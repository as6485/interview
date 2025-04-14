package leetcode;

public class HouseRobber {
    public static void main(String[] args) {
        int nums[] = new int[] {2,1,1,2};
        System.out.println(rob(nums));

    }
    //fibonacci approach : Time - O(n), Space - O(n)
    /*public static int rob(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int subTotal = 0;
            if(i >= 2 ){
                subTotal=hm.get(i-2);
            }
            if(i >= 3 ){
                subTotal=Math.max(hm.get(i-3), subTotal);
            }
            hm.put(i, subTotal+nums[i]);
        }

        return Collections.max(hm.values());
    }*/

    //fibonacci with O(1) space
    public static int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int dp2=nums[0], dp1=Math.max(nums[0],nums[1]),dp=dp1;
        for(int i = 2; i < n; i++){
            dp = Math.max(dp1, dp2 + nums[i]);
            dp2 = dp1;
            dp1 = dp;
        }
        return dp;
    }
}
