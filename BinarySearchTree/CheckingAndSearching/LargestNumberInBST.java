package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

public class LargestNumberInBST {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(12);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(9);
        root.right.right = new Node(21);
        root.right.right.left = new Node(19);
        root.right.right.right = new Node(25);

        System.out.println(findLargest(root, 14));
    }

    private static int findLargest(Node root, int i) {
        if (root == null) {
            return -1;
        }

        if (root.left == null && root.right == null && root.data > i) {
            return -1;
        }

        if ((root.data <= i && root.right == null) || (root.data <= i && root.right.data > i)) {
            return root.data;
        }

        if (root.data < i) {
            return findLargest(root.right, i);
        } else {
            return findLargest(root.left, i);
        }
    }


}
