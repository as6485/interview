package leetcode;

public class TNode {
    int val;
    TNode left;
    TNode right;
    TNode next;

    public TNode(int val) {
        this.val = val;
    }

    public TNode(int val, TNode left, TNode right, TNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
