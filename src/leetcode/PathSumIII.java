package leetcode;

public class PathSumIII {
    static int counter = 0;

    public static void main(String[] args) {

        TreeNode l4_3 = new TreeNode(3);
        TreeNode l4_2 = new TreeNode(-2);
        TreeNode l4_1 = new TreeNode(1);

        TreeNode l3_3 = new TreeNode(3, l4_3, l4_2);
        TreeNode l3_2 = new TreeNode(2, null, l4_1);
        TreeNode l3_11 = new TreeNode(11);

        TreeNode l2_5 = new TreeNode(5, l3_3, l3_2);
        TreeNode l2_3 = new TreeNode(-3, null, l3_11);

        TreeNode root = new TreeNode(10, l2_5, l2_3);

        System.out.println(pathSum(root, 8));

    }
    // iterate to each node and add everything up.
    public static long pathSum(TreeNode root, int sum) {
        long curCount = isMeetSum(root, sum);
        if (root == null) {
            return 0;
        }

        return curCount + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    //method find the number of solutions that starting at the root, it doesn't matter where it ends.
    public static long isMeetSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        long count = 0;
        if (root.val == sum) {
            count++;
        }
        return count + isMeetSum(root.left, sum - root.val) + isMeetSum(root.right, sum - root.val);
    }


    /*public static int pathSum(TreeNode root, int targetSum) {
        int paths = 0;

        if(root == null)
            return paths;
        else
            return countPathSum(root, 0, targetSum);
    }

    private static int countPathSum(TreeNode current, int pathSum, int targetSum) {
        int count = 0, leftCount=0, rightCount=0;
        if(current.val + pathSum == targetSum){
            count++;
            pathSum = current.val;
        }
        else if(current.val + pathSum < targetSum){
            pathSum+= current.val;
        }
        else{
            pathSum = current.val;
        }

        if(current.left!=null){
            leftCount = countPathSum(current.left, pathSum, targetSum);
        }
        if(current.right!=null) {
            rightCount = countPathSum(current.right, pathSum, targetSum);
        }

        return count+leftCount+rightCount;
    }*/
}
