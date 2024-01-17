package leetcode;

public class FindPeakElement {
    public static void main(String[] args){
        int[] elements = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(elements));
    }

    public static int findPeakElement(int[] nums) {
        int length = nums.length;
        for(int i=0; i<length; i++){
            int previous = (i==0)?Integer.MIN_VALUE : nums[i-1];
            int next = (i == length-1)? Integer.MIN_VALUE : nums[i+1];
            int current = nums[i];
            if(previous < current && current > next){
                return i;
            }
        }
        return 0;
    }
}
