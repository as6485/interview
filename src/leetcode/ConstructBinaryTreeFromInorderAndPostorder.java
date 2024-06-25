package leetcode;

import java.util.Arrays;

public class ConstructBinaryTreeFromInorderAndPostorder {

    public static void main(String[] args) {

        int[] inorder = {-1}, postorder = {-1};
        TreeNode root = buildTree(inorder, postorder);
        System.out.println("End");
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = new TreeNode();
        if((inorder == null && postorder == null) || (inorder.length == 0 && postorder.length==0))
            return null;

        //last element of postorder is the root
        root.val = postorder[postorder.length-1];
        //get position of root
        int rootPos = 0;
        for(int i = 0; i< inorder.length; i++){
            if(inorder[i] == root.val){
                rootPos = i;
                break;
            }
        }

        //get left subtree
        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, rootPos);
        int[] leftPostOrder = Arrays.copyOfRange(postorder, 0, leftInOrder.length);
        root.left = buildTree(leftInOrder, leftPostOrder);


        //get right subtree
        int[] rightInOrder = Arrays.copyOfRange(inorder, rootPos+1, inorder.length);
        int[] rightPostOrder = Arrays.copyOfRange(postorder, leftPostOrder.length, postorder.length-1);
        root.right = buildTree(rightInOrder, rightPostOrder);

        return root;
    }


}
