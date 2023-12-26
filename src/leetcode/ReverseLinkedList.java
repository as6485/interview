package leetcode;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseLinkedList {
    public static void main(String[] args) {
        /*ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);*/
        ListNode three = new ListNode(3, null);
        ListNode two = new ListNode(2, three);
        ListNode head = new ListNode(1, two);
        //head = reverseListStack(head);
        //head = reverseListIterative(head);
        head = reverseListRecursive(head);
        printList(head);
    }

    private static void printList(ListNode node) {
        while(node != null){
            System.out.print(node.val+"->");
            node = node.next;
        }
    }

    public static ListNode reverseListIterative(ListNode head) {
        ListNode newHead = null;
        while(head!=null){
            ListNode next = head.next;
            head.next= newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public static ListNode reverseListRecursive(ListNode head) {
        // base case
        if(head == null || head.next == null) return head;
        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public static ListNode reverseListStack(ListNode head) {
        Stack<ListNode> stk = new Stack<>();
        while(head != null){
            stk.push(head);
            head = head.next;
        }
        if(stk.peek()!=null){
            head = stk.pop();
        }
        retrieveStack(stk, head);
        return head;
    }

    private static void retrieveStack(Stack<ListNode> stk, ListNode node) {
        while(!stk.isEmpty()){
            ListNode top = stk.pop();
            top.next = null;
            node.next = top;
            retrieveStack(stk, node.next);
        }
    }

}
