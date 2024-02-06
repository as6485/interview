package leetcode;

import java.util.ArrayList;
import java.util.List;

public class OddEvenLinkedList {

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
        printList(oddEvenList(one));

    }

    public static ListNode oddEvenList(ListNode head) {
        if (head != null) {

            ListNode odd = head, even = head.next, evenHead = even;

            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
        }
        return head;
    }

    public static ListNode oddEvenListAyan(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode current = head;
        List<Integer> evens = new ArrayList<>();

        while(current.next != null){
            ListNode evenNode = current.next;
             evens.add(evenNode.val);

             if(current.next.next != null) {
                 ListNode temp = current.next.next;
                 current.next = temp;
                 current = temp;
             }
             else
                 break;
        }

        for(Integer ev : evens){
            ListNode ln = new ListNode(ev);
            current.next = ln;
            current = current.next;
        }

        return head;
    }


    private static void printList(ListNode node) {
        while(node != null){
            System.out.print(node.val+"->");
            node = node.next;
        }
    }

}
