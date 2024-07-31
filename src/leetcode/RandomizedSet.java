package leetcode;

import java.util.HashMap;
import java.util.List;

public class RandomizedSet {
    HashMap<Integer, Integer> hm;
    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        System.out.println(obj.insert(1));
        System.out.println(obj.insert(10));
        System.out.println(obj.insert(20));
        System.out.println(obj.insert(30));

        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
    }


    public RandomizedSet() {
        hm = new HashMap<Integer, Integer>();
    }

    public boolean insert(int key) {
        return hm.putIfAbsent(key, 1) == null;
    }

    public boolean remove(int key) {
        return hm.remove(key) != null;
    }

    public int getRandom() {
        List<Integer> keys = hm.keySet().stream().toList();
        int max=keys.size()-1, min=0;
        int randomKey = min + (int)(Math.random() * ((max - min) + 1));
        return keys.get(randomKey);
    }
}
