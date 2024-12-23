package leetcode;

/*LeetCode 122. Best Time to Buy and Sell Stock
 * #Top75
 */
public class BestTimetoBuyandSellStock2 {

	public static void main(String[] args) {
		int[] prices = new int[]{7,1,5,40,60};
		System.out.println(maxProfit(prices));
	}

	private static int maxProfit(int[] prices) {
		int left = 0;
		int right = left + 1;
		int maxProfit = 0;

		while (right < prices.length) {
			//profitable trade
			if(prices[left] < prices[right]) {
				maxProfit += prices[right] - prices[left];
			}
			left = right;
			right++;
		}
		return maxProfit;

	}
}
