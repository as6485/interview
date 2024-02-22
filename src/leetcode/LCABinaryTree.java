package leetcode;

public class LCABinaryTree {
    static TreeNode lca;

    public static void main(String[] args) {
        TreeNode l5 = new TreeNode(5);
        TreeNode l1 = new TreeNode(1);
        TreeNode root = new TreeNode(3, l5, l1);

        /*TreeNode l = new TreeNode(2);
        TreeNode root = new TreeNode(1, l, null);*/

        System.out.println(lowestCommonAncestor(root, l5, l1).val);

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
    }

    /*public static TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        TreeNode searchP = null, searchQ = null;
        if (node.left != null) {
            lca = lowestCommonAncestor(node.left, p, q);
        }
        if (node.right != null) {
            lca = lowestCommonAncestor(node.right, p, q);
        }
        if (lca != null)
            return lca;
        else {
            //search p & q
            searchP = searchNode(node, p);
            if (searchP != null) {
                searchQ = searchNode(node, q);
            }
            if (searchP != null && searchQ != null) {
                return node;
            }
        }
        return null;
    }

    public static TreeNode searchNode(TreeNode currentNode, TreeNode searchNode) {
        TreeNode foundNode = null;
        if (currentNode == null) {
            return null;
        } else if (searchNode == currentNode) {
            return currentNode;
        }

        if (currentNode.left != null && foundNode == null) {
            foundNode = searchNode(currentNode.left, searchNode);
        }
        if (currentNode.right != null && foundNode == null) {
            foundNode = searchNode(currentNode.right, searchNode);
        }
        return foundNode;
    }*/
}
