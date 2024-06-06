package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        int [] fruits = {1,2,3,2,2};
        System.out.println(totalFruit(fruits));
    }

    public static int totalFruit(int[] tree) {
        int ans = 0;
        Map<Integer, Integer> count = new HashMap<>();

        for (int l = 0, r = 0; r < tree.length; ++r) {
            count.put(tree[r], count.getOrDefault(tree[r], 0) + 1);
            while (count.size() > 2) {
                count.put(tree[l], count.get(tree[l]) - 1);
                count.remove(tree[l], 0);
                ++l;
            }
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }


    /*public static int totalFruit(int[] fruits) {
        int baskets = 2;
        Set<Integer> distinctFruits;
        int maxFruits = 0;
        int i , j;

        if(fruits==null || fruits.length==0){
            return 0;
        }
        if(fruits.length == 1){
            return 1;
        }

        for(i = 0 ; i< fruits.length-1; i++){
            distinctFruits = new HashSet<>();
            distinctFruits.add(fruits[i]);
            for(j = i+1; j < fruits.length; j++){
                if(distinctFruits.size() < baskets){
                    distinctFruits.add(fruits[j]);
                }
                else if(distinctFruits.contains(fruits[j])){
                    continue;
                }
                else{
                   break;
                }
            }
            maxFruits = Math.max(maxFruits, j-i);
        }

        return maxFruits;
    }*/
}
