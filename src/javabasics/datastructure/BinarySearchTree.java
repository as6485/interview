package javabasics.datastructure;

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;

	}
}

public class BinarySearchTree {

	Node root;

	public BinarySearchTree() {
		this.root = null;
	}

	public BinarySearchTree(Node root) {
		this.root = root;
	}

	public void insert(int data) {
		Node newNode = new Node(data);
		newNode.data = data;
		newNode.left = null;
		newNode.right = null;
		System.out.println("New Node : " + newNode + " created for data : " + data);

		if (this.root == null) {
			this.root = newNode;
		} else {
			insertNode(root, newNode);
		}

	}

	public void insertNode(Node currentNode, Node newNode) {
		// insert left
		if (newNode.data < currentNode.data) {
			if (currentNode.left == null) {
				currentNode.left = newNode;
			} else {
				insertNode(currentNode.left, newNode);
			}
		}
		// insert right
		if (newNode.data > currentNode.data) {
			if (currentNode.right == null) {
				currentNode.right = newNode;
			} else {
				insertNode(currentNode.right, newNode);
			}
		}
	}

	public Node delete(int data) {
		return deleteNode(root, data);
	}

	// remove the data node and return a proper subtree which will be assigned to
	// the parent
	private Node deleteNode(Node node, int data) {
		// node is null
		Node temp = null;
		if (node == null) {
			return temp;
		}

		// recursive call to delete the node from left/right subtree and assign the
		// re-arranged subtree to left/right
		if (data < node.data) {
			node.left = deleteNode(node.left, data);
		} else if (data > node.data) {
			node.right = deleteNode(node.right, data);
		}

		// this is the node to delete
		if (data == node.data) {

			// only one child exits
			if (node.left == null) {
				temp = node.right;
			} else if (node.right == null) {
				temp = node.left;
			}
			// both child exists
			else if (node.left != null && node.right != null) {
				insertNode(node.right, node.left);
				node.left = null;
				temp = node.right;
			}

			if (node == root) {
				root = temp;
			}

		}

		return temp;
	}


	public Node search(int data) {
		return searchNode(root, data);
	}

	public Node searchNode(Node currentNode, int data) {
		if (currentNode == null) {
			return null;
		} else if (data == currentNode.data) {
			return currentNode;
		} else if (data < currentNode.data) {
			return searchNode(currentNode.left, data);
		} else if (data > currentNode.data) {
			return searchNode(currentNode.right, data);
		}

		return null;
	}

	public void inOrderTraversal(Node node) {
		if (node == null) {
			return;
		}

		if (node.left != null) {
			inOrderTraversal(node.left);
		}

		System.out.print(node.data + ",");

		if (node.right != null) {
			inOrderTraversal(node.right);
		}
	}

	public static void main(String[] args) {
		// Node root = new Node(8);
		BinarySearchTree bst = new BinarySearchTree();

		bst.insert(8);
		bst.insert(4);
		bst.insert(10);
		bst.insert(2);
		bst.insert(6);
		bst.insert(20);

		// search existing nodes
		System.out.println("Search 8 : " + bst.search(8));
		System.out.println("Search 4 : " + bst.search(4));
		System.out.println("Search 10 : " + bst.search(10));

		// search non existing node
		System.out.println("Search 7 : " + bst.search(7));

		bst.inOrderTraversal(bst.root);

		// delete a node
		
		/*
		 * System.out.println("Delete 4 : " + bst.delete(4));
		 * System.out.println("In order traversal after deleting 4 : ");
		 * bst.inOrderTraversal(bst.root);
		 */
		 

		// delete a node
		
		  System.out.println("Delete 10 : " + bst.delete(10));
		  System.out.println("In order traversal after deleting 10 : ");
		  bst.inOrderTraversal(bst.root);
		 

		/* delete root
		System.out.println("Delete 8 : " + bst.delete(8));
		System.out.println("In order traversal after deleting root 8 : ");
		bst.inOrderTraversal(bst.root);*/

	}

}
