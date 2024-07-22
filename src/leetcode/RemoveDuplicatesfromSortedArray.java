package leetcode;

public class RemoveDuplicatesfromSortedArray {

    public static void main(String[] args) {
        int arr[] = {1,1,2};

        System.out.println(removeDuplicates(arr));
    }

    private static int removeDuplicates(int[] nums) {
        int i=0, j=1;

        if(nums.length < 2)
            return nums.length;

        while(j < nums.length) {
           while(j < nums.length && nums[j]<=nums[i]){
            j++;
           }
           i++;
           if(i < nums.length && j < nums.length)
                nums[i]=nums[j];
        }

        return i;
    }
}
