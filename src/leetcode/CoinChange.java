package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {186,419,83,408}; int amount = 6249;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        Map<Integer,Integer> map=new HashMap<>();
        return helper(coins,amount,map);
    }
    private static int helper(int[] coins, int amount, Map<Integer,Integer> mem ){
        if(amount<0) return -1;
        if(amount==0) return 0;
        Integer c=mem.get(amount);
        if(c!=null) return c;
        int cc=-1;
        for(int i=0;i<coins.length;i++) {
            int coin=helper(coins, amount-coins[i],mem);
            if(coin>=0) cc=cc<0?coin+1:Math.min(cc,coin+1);
        }
        mem.put(amount,cc);
        return cc;
    }
}
