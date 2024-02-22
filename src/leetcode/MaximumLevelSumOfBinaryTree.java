package leetcode;

import java.util.Collections;
import java.util.HashMap;

public class MaximumLevelSumOfBinaryTree {
    static HashMap<Integer, Integer> hm = new HashMap<>();
    public static void main(String[] args) {
        TreeNode l2 = new TreeNode(7);
        TreeNode r2 = new TreeNode(-8);
        TreeNode l1 = new TreeNode(7, l2, r2);
        TreeNode r1 = new TreeNode(0);
        TreeNode root = new TreeNode(1, l1, r1);
        System.out.println(maxLevelSum(root));


        /*TreeNode root = new TreeNode(1);
        System.out.println(maxLevelSum(root));*/

    }


    public static int maxLevelSum(TreeNode root) {
        hm.put(1, root.val);
        levelSum(1, root);
        //return Collections.max(hm.entrySet(), Map.Entry.comparingByValue()).getKey();
        return Collections.max(hm.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey();
    }

    private static void levelSum(int level, TreeNode node){
        level++;
        if(node.left != null){
            hm.put(level, hm.getOrDefault(level, 0) + node.left.val);
            levelSum(level, node.left);
        }
        if(node.right != null){
            hm.put(level, hm.getOrDefault(level, 0) + node.right.val);
            levelSum(level, node.right);
        }
    }
}
