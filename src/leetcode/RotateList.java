package leetcode;

public class RotateList {
    public static void main(String[] args) {
        ListNode eight = new ListNode(8);
        ListNode seven = new ListNode(7, eight);
        ListNode six = new ListNode(6, seven);
        ListNode five = new ListNode(5, six);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);

        /*ListNode two = new ListNode(2);
        ListNode one = new ListNode(1, two);*/

        printList(one);
        printList(rotateRight(one, 8));

    }


    private static ListNode rotateRight(ListNode head, int k) {
        //for 0 or 1 node return head
        if(head == null || head.next == null)
            return head;
        int length = 2;
        ListNode tail = head;
        //get length of the list
        while(tail.next.next!=null){
            tail = tail.next;
            length++;
        }
        //if k is larger than length, adjust it to save run time
        k = k%length;

        while(k>0){
            tail = head;
            while(tail.next.next!=null){
                tail = tail.next;
            }
            tail.next.next = head;
            head = tail.next;
            tail.next = null;

            k--;
        }
        return head;
    }

    private static void printList(ListNode node) {
        while(node != null){
            System.out.print(node.val+"->");
            node = node.next;
        }
        System.out.println();
    }
}
