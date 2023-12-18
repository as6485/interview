package leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseLinkedList {


    public static void main(String[] args) {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode head = new ListNode(1, two);

        printList(head);
    }

    private static void printList(ListNode node) {
        while(node != null){
            System.out.print(node.val+"->");
            node = node.next;
        }
    }

    public ListNode reverseList(ListNode head) {

        return head;
    }
}
