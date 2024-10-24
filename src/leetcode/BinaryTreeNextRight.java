package leetcode;

/**Leet 117 **/
public class BinaryTreeNextRight {

    public static void main(String[] args) {
        TNode t4 = new TNode(4);
        TNode t5 = new TNode(5);
        TNode t7 = new TNode(7);
        TNode t3 = new TNode(3, null, t7, null);
        TNode t2 = new TNode(2, t4, t5, null);
        TNode t1 = new TNode(1, t2, t3, null);

        connect(t1);
        System.out.println("End");
    }
    private static void connect(TNode root) {
        for (TNode head = root; head != null; ) {
            TNode nextHead = new TNode(0), nextTail = nextHead;
            for (TNode node = head; node != null; node = node.next) {
                if (node.left != null) {
                    nextTail.next = node.left;
                    nextTail = node.left;
                }
                if (node.right != null) {
                    nextTail.next = node.right;
                    nextTail = node.right;
                }
            }
            head = nextHead.next;
        }
    }

}
