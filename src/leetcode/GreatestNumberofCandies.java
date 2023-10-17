package leetcode;
import java.util.*;
public class GreatestNumberofCandies {

	public static void main(String[] args) {		
		int[] candies = new int[] {2,3,5,1,3};
		int extraCandies = 3;
		kidsWithCandies(candies, extraCandies).forEach(v -> System.out.print(v));
	}
	
	private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> result = new ArrayList<Boolean>();
        int max = Arrays.stream(candies).max().getAsInt();
        
        
        for(int i =0; i < candies.length; i++){
            if((candies[i]+extraCandies) >= max){
                result.add(i, true);
            }
            else{
                result.add(i, false);
            }
        }
        return result;
    }

}
