package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class StockSpannerStack {
    Stack<PriceSpan> stk;
    class PriceSpan{
        Integer price;
        Integer span;
        public PriceSpan(Integer price, Integer span) {
            this.price = price;
            this.span = span;
        }
    }

    public StockSpannerStack() {
        stk = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
//        If The top element of stack price is below or equal to the current price:
//          Then, the previous element will be span of current.
        while(!stk.isEmpty() && stk.peek().price <= price){
            span += stk.pop().span;
        }
//        At each level add the price and the span.
//        So that Next time when visited for consecutive days, you have the value of current that will avoid traversal till the current days span.
        stk.add(new PriceSpan(price, span));
        return span;
    }

    public static void main(String[] args) {
        StockSpannerStack stockSpanner = new StockSpannerStack();
        System.out.println(stockSpanner.next(100)); // return 1
        System.out.println(stockSpanner.next(80)); // return 1
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(70));  // return 2
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(75));  // return 4,
    }
}
