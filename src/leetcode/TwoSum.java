package leetcode;
import java.util.*;  
/*LeetCode 1. Two Sum
 * #Top75
 */
public class TwoSum {
	public static void main(String args[]) {
		int[] intArray = new int[]{ 3,3 }; 
		int target = 6;
		
		System.out.println("Result :: "+ Arrays.toString(twoSum(intArray, target)));
		
	}
	
	public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int[] result = null;
        
        for(int i=0; i <nums.length; i++) {

        	int difference = target-nums[i];
        	if(hm.containsKey(difference)){
        		if(hm.get(difference)!= i) {
	        		result = new int[] {hm.get(difference), i};
	        		break;
        		}
        	}
        	hm.put(nums[i], i);
        }
        
        return result;
    }
	
}
