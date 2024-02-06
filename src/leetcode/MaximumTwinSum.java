package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaximumTwinSum {
    public static void main(String[] args) {
        ListNode eight = new ListNode(8);
        ListNode seven = new ListNode(7, eight);
        ListNode six = new ListNode(6, seven);
        ListNode five = new ListNode(5, six);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
        printList(one);
        System.out.println("");
        System.out.println(pairSum(one));
    }

    public static int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        int maxSum = 0;
        while(head != null){
            list.add(head.val);
            head = head.next;
        }

        int length = list.size();

        for(int i=0; i<(length/2); i++){
            int sum = list.get(i) + list.get(length-1-i);
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }

    private static void printList(ListNode node) {
        while(node != null){
            System.out.print(node.val+"->");
            node = node.next;
        }
    }
}
