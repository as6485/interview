package leetcode;

import com.sun.source.tree.Tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BST {
    TreeNode rootNode;

    public BST() {
        this.rootNode = null;
    }

    public BST(TreeNode root) {
        this.rootNode = root;
    }
    public void insert(int data) {
        TreeNode newNode = new TreeNode(data);
        newNode.val = data;
        newNode.left = null;
        newNode.right = null;
        System.out.println("New Node : " + newNode + " created for data : " + data);

        if (this.rootNode == null) {
            this.rootNode = newNode;
        } else {
            insertNode(rootNode, newNode);
        }

    }
    public void insertNode(TreeNode currentNode, TreeNode newNode) {
        // insert left
        if (newNode.val < currentNode.val) {
            if (currentNode.left == null) {
                currentNode.left = newNode;
            } else {
                insertNode(currentNode.left, newNode);
            }
        }
        // insert right
        if (newNode.val > currentNode.val) {
            if (currentNode.right == null) {
                currentNode.right = newNode;
            } else {
                insertNode(currentNode.right, newNode);
            }
        }
    }

    public TreeNode search(int data) {
        return searchNode(rootNode, data);
    }

    public TreeNode searchNode(TreeNode currentNode, int data) {
        if (currentNode == null) {
            return null;
        } else if (data == currentNode.val) {
            return currentNode;
        } else if (data < currentNode.val) {
            return searchNode(currentNode.left, data);
        } else if (data > currentNode.val) {
            return searchNode(currentNode.right, data);
        }

        return null;
    }
    public void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            inOrderTraversal(node.left);
        }

        System.out.print(node.val + ",");

        if (node.right != null) {
            inOrderTraversal(node.right);
        }
    }

    /*public TreeNode deleteNode(TreeNode root, int key) {
       TreeNode nodeFound = searchNode(root, key);
       if(nodeFound == null){
           return null;
       }
        TreeNode temp;
        // only one child exits
        if (nodeFound.left == null) {
            temp = nodeFound.right;
        } else if (nodeFound.right == null) {
            temp = nodeFound.left;
        }
        // both child exists
        else if (nodeFound.left != null && nodeFound.right != null) {
            insertNode(nodeFound.right, nodeFound.left);
            nodeFound.left = null;
            temp = nodeFound.right;
        }

       return root;
    }*/

    private TreeNode deleteNode(TreeNode root, int key) {
        // node is null
        TreeNode temp = null;
        if (root == null) {
            return temp;
        }

        // recursive call to delete the node from left/right subtree and assign the
        // re-arranged subtree to left/right
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }

        // this is the node to delete
        if (key == root.val) {

            // only one child exits
            if (root.left == null) {
                temp = root.right;
            } else if (root.right == null) {
                temp = root.left;
            }
            // both child exists
            else if (root.left != null && root.right != null) {
                insertNode(root.right, root.left);
                root.left = null;
                temp = root.right;
            }

            if (root == rootNode) {
                rootNode = temp;
            }
        }

        return temp;
    }

    public static void main(String[] args) {
        // Node root = new Node(8);
        BST bst = new BST();

        bst.insert(5);
        bst.insert(3);
        bst.insert(6);
        bst.insert(2);
        bst.insert(4);
        bst.insert(7);

        // search existing nodes
        System.out.println("Search 8 : " + bst.search(8));
        System.out.println("Search 4 : " + bst.search(4));
        System.out.println("Search 10 : " + bst.search(10));

        System.out.println("Search 7 : " + bst.search(7));

        bst.inOrderTraversal(bst.rootNode);

        System.out.println("Delete 3 : " + bst.deleteNode(bst.rootNode, 3));
        System.out.println("In order traversal after deleting 3 : ");
        bst.inOrderTraversal(bst.rootNode);
    }

}
