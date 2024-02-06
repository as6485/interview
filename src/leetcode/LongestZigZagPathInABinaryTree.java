package leetcode;

enum Direction{
    LEFT,
    RIGHT
}

public class LongestZigZagPathInABinaryTree {
    public static void main(String[] args) {
        TreeNode l6 = new TreeNode(1);
        TreeNode l5 = new TreeNode(1, null, l6);
        TreeNode l4_1 = new TreeNode(1, null, l5);
        TreeNode l4_2 = new TreeNode(1);
        TreeNode l3_1 = new TreeNode(1);
        TreeNode l3_2 = new TreeNode(1, l4_1, l4_2);
        TreeNode l2 = new TreeNode(1, l3_1, l3_2);
        TreeNode root = new TreeNode(1, null, l2);

        System.out.println(longestZigZag(root));

    }

    public static int longestZigZag(TreeNode root) {
        int leftCount = 0, rightCount = 0, leftChild = 0, rightChild=0;
        if(root == null)
            return 0;
        if(root.left!=null){
            leftCount = zigZag(root.left, Direction.LEFT);
        }
        if(root.right!=null){
            rightCount = zigZag(root.right, Direction.RIGHT);
        }

        //recursive calls to child nodes
        if(root.left!=null){
            leftChild = longestZigZag(root.left);
        }
        if(root.right!=null){
            rightChild = longestZigZag(root.right);
        }

        return Math.max(Math.max(Math.max(leftCount, rightCount), leftChild), rightChild);
    }

    private static int zigZag(TreeNode node, Direction direction) {
        int count = 1;

        if(direction == Direction.LEFT && node.right!=null){
            count+=zigZag(node.right, Direction.RIGHT);
        }
        else if (direction == Direction.RIGHT && node.left!=null) {
            count+=zigZag(node.left, Direction.LEFT);
        }

        return count;
    }
}
