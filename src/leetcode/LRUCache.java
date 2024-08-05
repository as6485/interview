package leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class LRUCache {

    HashMap<Integer, Integer> map;
    Queue dq;
    int capacity;

    public static void main(String[] args) {
        /*LRUCache obj = new LRUCache(2);
        obj.put(1, 1);
        obj.put(2, 2);
        System.out.println(obj.get(1));
        obj.put(3, 3);
        System.out.println(obj.get(2));
        obj.put(4, 4);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));*/

        LRUCache obj = new LRUCache(2);
        obj.put(2, 1);
        obj.put(2, 2);
        System.out.println(obj.get(2));
        obj.put(1, 1);
        obj.put(4, 1);
        System.out.println(obj.get(2));
    }


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        dq = new ArrayDeque<Integer>(capacity);
    }

    public int get(int key) {
        Integer val = map.get(key);
        if (val != null) {
            //update queue
            dq.remove(key);
            dq.add(key);
            return val;
        } else
            return -1;
    }

    public void put(int key, int value) {
        Integer prevVal = map.put(key, value);
        if (prevVal != null) {
            //update queue
            dq.remove(key);
        }

        if (map.size() > capacity) {
            map.remove(dq.poll());
        }

        dq.add(key);
    }

}
