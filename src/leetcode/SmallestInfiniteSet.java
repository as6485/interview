package leetcode;
import java.util.*;

public class SmallestInfiniteSet {
    private Integer minNum;
    private PriorityQueue<Integer> heap;

    public SmallestInfiniteSet() {
        minNum = 1;
        heap = new PriorityQueue<>();
    }

    public int popSmallest() {
        if (!heap.isEmpty()) {
            return heap.poll();
        }
        minNum++;
        return minNum - 1;
    }
    public void addBack(int num) {
        if (minNum > num && !heap.contains(num)) {
            heap.offer(num);
        }
    }

    public static void main(String[] args) {
        SmallestInfiniteSet sis = new SmallestInfiniteSet();

        sis.addBack(2);
        System.out.println(sis.popSmallest());
        System.out.println(sis.popSmallest());
        sis.addBack(2);
        System.out.println(sis.popSmallest());

    }

}
