package leetcode;

public class CountGoodNodesInBinaryTree {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(5);
        TreeNode root = new TreeNode(4, left, right);
        System.out.println(goodNodes(root));
    }

    public static int goodNodes(TreeNode root) {
        int goodNodes = 0;
        if(root == null)
            return goodNodes;
        else
            return countGoodNodes(root, root.val);
    }

    public static int countGoodNodes(TreeNode current, int maxVal) {
        int goodNodes = 0, leftGoodNodes = 0, rightGoodNodes = 0;

        if(current.val >= maxVal){
            goodNodes++;
            maxVal = current.val;
        }

        if (current.left != null)
            leftGoodNodes = countGoodNodes(current.left, maxVal);
        if (current.right != null)
            rightGoodNodes = countGoodNodes(current.right, maxVal);

        return goodNodes+leftGoodNodes+rightGoodNodes;
    }
}
