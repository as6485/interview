package javabasics.datastructure.minheap;
/* Complete binary tree (filled left to right) wher each node < childs */

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;

	}
}

public class MinHeap {

	Node root;

	public MinHeap() {
		this.root = null;
	}

	public void insert(int data) {
		Node newNode = new Node(data);
		insertNode(root, newNode);
	}

	private Node insertNode(Node currentNode, Node newNode) {
		int temp;

		// root is null
		if (root == null) {
			root = newNode;
			return root;
		}

		// find bottom rightmost leaf to insert newNode
		if (currentNode.left == null && currentNode.right == null) {
			currentNode.left = newNode;
			// swap as required
			if (currentNode.data > currentNode.left.data) {
				temp = currentNode.data;

				if (currentNode == root) {
					currentNode.data = currentNode.left.data;
					root.data = currentNode.left.data;
				} else {
					currentNode.data = currentNode.left.data;
				}

				currentNode.left.data = temp;
			}
		} else if (currentNode.left != null && currentNode.right == null) {
			currentNode.right = newNode;
			// swap as required
			if (currentNode.data > currentNode.right.data) {
				temp = currentNode.data;

				if (currentNode == root) {
					currentNode.data = currentNode.right.data;
					root.data = currentNode.right.data;
				} else {
					currentNode.data = currentNode.right.data;
				}
				currentNode.right.data = temp;
			}
		} else if (currentNode.left != null && currentNode.right != null) {
			if (isNotFilled(currentNode.left)) {
				insertNode(currentNode.left, newNode);
			} else if (isNotFilled(currentNode.right)) {
				insertNode(currentNode.right, newNode);
			}
		}

		return newNode;
	}

	private boolean isNotFilled(Node node) {
		if (node.left == null || node.right == null)
			return true;
		else
			return false;
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
		MinHeap minHeap = new MinHeap();

		minHeap.insert(4);
		minHeap.insert(50);
		minHeap.insert(7);
		minHeap.insert(55);
		minHeap.insert(90);
		minHeap.insert(87);
		minHeap.insert(2);

		minHeap.inOrderTraversal(minHeap.root);

	}

}
