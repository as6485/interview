package leetcode;

public class FindTheDuplicateNumber {
    public static void main(String args[]) {
        int[] arr = {1,3,4,2,2};
        System.out.println(findDuplicate(arr));
    }


    public static int findDuplicate(int[] nums) {
        int i=0;
        while(i < nums.length){
            if(nums[i] != i+1){
                int j = nums[i]-1;
                int temp = nums[j];
                if(nums[j] == nums[i]) return nums[i];
                nums[j] = nums[i];
                nums[i] = temp;

            } else {
                i++;
            }
        }
        return -1;
    }
}
