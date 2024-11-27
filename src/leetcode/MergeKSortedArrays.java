package leetcode;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    private static class HeapNode
            implements Comparable<HeapNode> {
        int x;
        int y;
        int value;

        HeapNode(int x, int y, int value)
        {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override public int compareTo(HeapNode hn)
        {
            if (this.value <= hn.value) {
                return -1;
            }
            else {
                return 1;
            }
        }
    }

    // Function to merge k sorted arrays.
    public static ArrayList<Integer>
    mergeKArrays(int[][] arr, int K)
    {
        ArrayList<Integer> result
                = new ArrayList<Integer>();
        PriorityQueue<HeapNode> heap
                = new PriorityQueue<HeapNode>();

        // Initially add only first column of elements. First
        // element of every array
        for (int i = 0; i < arr.length; i++) {
            heap.add(new HeapNode(i, 0, arr[i][0]));
        }

        HeapNode curr = null;
        while (!heap.isEmpty()) {
            curr = heap.poll();
            result.add(curr.value);

            // Check if next element of curr min exists,
            // then add that to heap.
            if (curr.y < (arr[curr.x].length - 1)) {
                heap.add(
                        new HeapNode(curr.x, curr.y + 1,
                                arr[curr.x][curr.y + 1]));
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        /*solution for above HeapNode
        int[][] arr = { { 2, 6, 12 },
                { 1, 9 },
                { 23, 34, 90, 2000 } };
        System.out.println(
                MergeKSortedArrays.mergeKArrays(arr, arr.length)
                        .toString());*/

        //solution using ListNode below
        ListNode l1_five = new ListNode(5);
        ListNode l1_four = new ListNode(4, l1_five);
        ListNode l1_one = new ListNode(1, l1_four);

        ListNode l2_four = new ListNode(4);
        ListNode l2_three = new ListNode(3, l2_four);
        ListNode l2_one = new ListNode(1, l2_three);

        ListNode l3_six = new ListNode(6);
        ListNode l3_two = new ListNode(2, l3_six);

        ListNode[] lists = {l1_one, l2_one, l3_two};

        ListNode node = mergeKLists(lists);
        while(node != null){
            System.out.print(node.val+"->");
            node = node.next;
        }

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0) return null;
        //Note the pq only stores and compares the first node of each list
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length, (a,b)-> a.val-b.val);

        //dummy head
        ListNode dummy = new ListNode(0);

        //tracks the tail at all time
        ListNode tail=dummy;

        //store the first node of each list
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            //the min element among the first node of each list
            tail.next=queue.poll();
            //increment tail
            tail=tail.next;
            //insert the next element of the same list into the PQ
            if (tail.next!=null)
                queue.add(tail.next);
        }
        //dummy next is the start of the actual result list
        return dummy.next;
    }
}

