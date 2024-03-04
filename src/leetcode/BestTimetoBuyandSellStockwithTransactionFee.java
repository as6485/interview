package leetcode;

import java.util.HashMap;

public class BestTimetoBuyandSellStockwithTransactionFee {

    public static HashMap<String,Integer> hm = new HashMap();

    public static void main(String[] args) {
        final int fee = 3;
        final int [] prices = {1,3,7,5,10,3};
        System.out.println(maxProfit(prices, fee));
    }

    public static int maxProfit(int[] prices, int fee) {
        int buy = Integer.MIN_VALUE;
        int sell = 0;

        for (int price : prices) {
            buy = Math.max(buy, sell - price);
            sell = Math.max(sell, buy + price - fee);
        }

        return sell;
    }

    /*public static int maxProfit(int[] prices, int fee) {
        return getMaxProfit(0, prices, fee);
    }


    public static int getMaxProfit(int startDay, int[] prices, int fee){
        int overallMaxProfit = 0;
        for(int buyDay = startDay; buyDay<= prices.length-2; buyDay++){
            for(int sellDay = buyDay+1; sellDay<=prices.length - 1; sellDay++){
                String key = String.valueOf(buyDay) + "-" + String.valueOf(sellDay);
                Integer cachedNetProfit = hm.get(key);
                if(cachedNetProfit!=null){
                    overallMaxProfit = Math.max(cachedNetProfit, overallMaxProfit);
                }
                else {
                    int profit = prices[sellDay] - fee - prices[buyDay];
                    if (profit > 0) {
                        int netProfit = profit + getMaxProfit(sellDay + 1, prices, fee);
                        hm.put(key, netProfit);
                        overallMaxProfit = Math.max(netProfit, overallMaxProfit);

                    }
                }
            }
        }

        return overallMaxProfit;
    }*/

}
