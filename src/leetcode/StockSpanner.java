package leetcode;

import java.util.ArrayList;
import java.util.ListIterator;

public class StockSpanner {
    ArrayList<Integer> priceHistory;

    public StockSpanner() {
        priceHistory = new ArrayList<>();
    }

    public int next(int price) {
        int count = 0;
        priceHistory.add(price);
        ListIterator<Integer> listIter = priceHistory.listIterator(priceHistory.size());
        while (listIter.hasPrevious()) {
            Integer prev = listIter.previous();
            if(prev <= price){
                count++;
            }
            else
                break;
        }
        return count;
    }


    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // return 1
        System.out.println(stockSpanner.next(80)); // return 1
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(70));  // return 2
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(75));  // return 4,

        System.out.println(stockSpanner.priceHistory);
    }

}
