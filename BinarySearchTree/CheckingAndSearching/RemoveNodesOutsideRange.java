package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

public class RemoveNodesOutsideRange {
    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(-13);
        root.right = new Node(14);
        root.left.right = new Node(-8);
        root.right.left = new Node(13);
        root.right.right = new Node(15);
        root.right.left.left = new Node(7);

        System.out.println("Before change:");
        inorder(root);

        int low = -10;
        int high = 13;

        root = removeNodes(root, low, high);

        System.out.println();
        System.out.println("After change");
        inorder(root);
    }

    private static Node removeNodes(Node root, int low, int high) {
        if(root == null) {
            return null;
        }

        root.left  = removeNodes(root.left, low, high);
        root.right = removeNodes(root.right, low, high);

        if(root.data < low) {
            return root.right;
        } else if (root.data > high) {
            return root.left;
        }
        return root;
    }

    private static void inorder(Node root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}
