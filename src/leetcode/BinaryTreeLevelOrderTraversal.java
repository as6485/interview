package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);

        //System.out.println(levelOrder(t1));
        System.out.println(levelOrderBFS(t1));
    }

    //BFS
    public static List<List<Integer>> levelOrderBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if(root == null) return result;

        queue.offer(root);

        while(!queue.isEmpty()){
            int qLen = queue.size();
            List<Integer> currentList = new LinkedList<Integer>();
            for(int i=0; i<qLen; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                currentList.add(queue.poll().val);
            }
            result.add(currentList);
        }
        return result;
    }


    //DFS
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
