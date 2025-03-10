package leetcode;

import java.util.*;

public class TopKElements {
    public static void main(String args[]) {
        int[] arr = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(arr, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(i -> {
            map.put(i, map.getOrDefault(i, 0)+1);
        });

        Queue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        heap.addAll(map.keySet());

        for(int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }

        return result;
    }
}
