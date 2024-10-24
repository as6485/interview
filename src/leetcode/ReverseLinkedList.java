package leetcode;

import java.util.Stack;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
        /*head = reverseListStack(head);
        head = reverseListIterative(head);
        head = reverseListRecursive(head);
        printList(one);
        System.out.println("");
        one = deleteMiddle(one);
        printList(one);*/

        //reverse linked list from/to index
        //1->2->3->4->5 should be reversed as 1->4->3->2->5
        int left=2, right=4;
        printList(reverseBetween(one, left, right));

        /*ListNode five = new ListNode(5);
        ListNode three = new ListNode(3, five);
        int left=1, right=2;
        printList(reverseBetween(three, left, right));*/

    }
    private static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        ListNode curr = fakeHead.next;
        int i = 1;
        while (i < m) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        ListNode node = prev;
        while (i <= n) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        node.next.next = curr;
        node.next = prev;
        return fakeHead.next;
    }
    /*private static ListNode reverseBetween(ListNode head, int left, int right) {
        //sanity checks
        if(head==null || head.next == null)
            return head;

        ListNode pre= head, post=null, prev=null, curr, next=null;
        int i;

        //get the last node before left
        for(i=2; i<left; i++){
            pre = pre.next;
        }

        curr = pre.next;
        while(i<=right){
            next=curr.next;
            curr.next = prev;
            prev = curr;
            curr=next;
            i++;
        }
        //add post
        post = next;
        pre.next.next = post;
        //add pre
        pre.next=prev!=null?prev:pre.next;

        return head;

    }
*/
    public static ListNode deleteMiddle(ListNode head) {
        ListNode slow = head, fast = head, previous = null;
        while(fast != null && fast.next != null){
            previous = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        if(previous==null)
            head = null;
        else
            previous.next = slow.next;

        return head;
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
