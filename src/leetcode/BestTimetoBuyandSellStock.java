package leetcode;

/*LeetCode 121. Best Time to Buy and Sell Stock 
 * #Top75
 */
public class BestTimetoBuyandSellStock {

	public static void main(String[] args) {
		int[] prices = new int[] { 1,2,4,2,5,7,2,4,9,0,9 };
		int left = 0;
		int right = left + 1;
		int profit, maxProfit = 0;

		while (right < prices.length) {
			//profitable trade
			if(prices[left] < prices[right]) {
				profit = prices[right] - prices[left];
				if(profit > maxProfit)
					maxProfit = profit;
			}
			/*Not a profitable trade means prices[right] is the lowest so far 
			hence update left to current right.
			Primarily left tracks the minimum value, it need not iterate over all values */
			else {
				left = right;
			}
			/*increment right regardless of profit situation
			 * right iterates over all values and helps us to calculate the profit
			 */
			right++;
		}

		System.out.println(maxProfit);

	}
}
