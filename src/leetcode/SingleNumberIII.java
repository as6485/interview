package leetcode;

import java.util.Arrays;

public class SingleNumberIII {
    public static void main(String[] args) {
        int nums[] = new int[] {1,2,1,3,2,5};
        System.out.println(Arrays.toString(singleNumber(nums)));

    }
    //https://leetcode.com/problems/single-number-iii/solutions/5233206/demon-level-explanation-3-approaches/
    public static int[] singleNumber(int[] nums) {
        int xor = 0;
        //xor all the elements
        for(int num : nums){
            xor^=num;
        }
        int[] result = new int[2];
        int lowestSetBit = xor & (-xor); //https://stackoverflow.com/questions/12247186/find-the-lowest-set-bit

        for (int num : nums) {
            if ((lowestSetBit & num) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }

        return result;
    }
}
