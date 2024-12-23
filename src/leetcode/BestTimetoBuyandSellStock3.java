package leetcode;

/*LeetCode 122. Best Time to Buy and Sell Stock
 * #Top75
 */
public class BestTimetoBuyandSellStock3 {

	public static void main(String[] args) {
		int[] prices = new int[]{3,3,5,0,0,3,1,4};
		System.out.println(maxProfit(prices));
	}

	private static int maxProfit(int[] prices) {
		if(prices.length ==0)
			return 0;
		int k=2;
		int dp[][] = new int[k + 1][prices.length];
		for (int i = 1; i < dp.length; i++) {
			int maxDiff = -prices[0];
			for (int j = 1; j < dp[0].length; j++) {
				maxDiff = Math.max(maxDiff, dp[i - 1][j - 1] - prices[j - 1]);
				dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
			}
		}
		return dp[k][prices.length - 1];
	}
}
