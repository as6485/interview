package leetcode;

import java.util.PriorityQueue;

public class BinaryTreeMaximumPathSum {
    static PriorityQueue<Integer> pq = new PriorityQueue<Integer>(5, (a, b) -> {
        return b-a;
    });

    public static void main(String[] args) {
        TreeNode t3_15 = new TreeNode(15);
        TreeNode t3_7 = new TreeNode(7);
        TreeNode t2_9 = new TreeNode(9);
        TreeNode t2_20 = new TreeNode(20, t3_15, t3_7);
        TreeNode root = new TreeNode(-10, t2_9, t2_20);

        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {
        pq.clear();
        helper(root);
        return pq.poll();
    }

        private static int helper(TreeNode node) {
            int returnVal = 0, max = 0;
            if (node == null) {
                returnVal = 0;
                pq.add(returnVal);
            } else if (node.left == null && node.right == null) {
                returnVal = node.val;
                pq.add(returnVal);
            } else if (node.left == null && node.right != null) {
                returnVal = Math.max(node.val, (node.val + helper(node.right)));
                pq.add(returnVal);
            } else if (node.left != null && node.right == null) {
                returnVal = Math.max(node.val, (node.val + helper(node.left)));
                pq.add(returnVal);
            } else {
                int leftVal = helper(node.left);
                int rightVal = helper(node.right);
                returnVal = Math.max(node.val, (node.val + Math.max(leftVal, rightVal)));
                pq.add(Math.max(returnVal, node.val+leftVal+rightVal));
            }

            return returnVal;
        }
}
