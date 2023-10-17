package leetcode;

import java.util.Arrays;

public class MinimumCostToTop {

	public static void main(String[] args) {
		int[] arr = new int[] {7,3,5,6,8};
		System.out.println("Minimum cost :: "+minCostClimbingStairs(arr));

	}
	
	private static int minCostClimbingStairs(int[] cost) {
        int length = 0;
        
        Arrays.stream(cost).forEach(v -> System.out.print(" "+v));
        System.out.println("");
        
        //create a minCostToTop[]
        int[] minCostToTop = cost;

        //fill minCostToTop from end to start 
        length = cost.length;
        for(int i=length-1; i>=0; i--){
            //last two elements
            if(i>=length-2){
                minCostToTop[i]=cost[i];
            }
            else{
                minCostToTop[i] = cost[i] + (minCostToTop[i+1]<minCostToTop[i+2] ? minCostToTop[i+1] : minCostToTop[i+2]);
            }
        }
        
        Arrays.stream(minCostToTop).forEach(v -> System.out.print(" "+v));
        System.out.println("");

        //return the minimum of minCostToTop[0] and minCostToTop[1]
        return minCostToTop[0]<minCostToTop[1] ? minCostToTop[0] : minCostToTop[1];
    }

}
