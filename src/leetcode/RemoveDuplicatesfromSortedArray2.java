package leetcode;



public class RemoveDuplicatesfromSortedArray2 {
    public static void main(String[] args)
    {
        int arr[] = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (j == 1 || nums[i] != nums[j - 2]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
