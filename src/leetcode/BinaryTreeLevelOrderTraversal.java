package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t7 = new TreeNode(7);
        TreeNode t3 = new TreeNode(3, t7, null);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);

        System.out.println(levelOrder(t1));
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int level = 0;
        helper(root, result, level);

        return result;
    }

    private static void helper(TreeNode node, List<List<Integer>> result, int level) {
        if(node==null)
            return;

        if(result.isEmpty() || level>= result.size()){
            List<Integer> innerList = new ArrayList<>();
            innerList.add(node.val);
            result.add(level, innerList);
        }
        else{
            List<Integer> innerList = result.get(level);
            innerList.add(node.val);
        }

        helper(node.left, result, level+1);
        helper(node.right, result, level+1);
    }
}
