package BinarySearchTree;

import BinaryTree.Node;

public class BSTToTreeWithSumOfSmallerKeys {
    static int sum = 0;
    public static void main(String[] args) {
        Node root = new Node(9);
        root.left = new Node(6);
        root.left.left = new Node(3);
        root.right = new Node(15);
        root.right.right = new Node(21);

        System.out.println("Before change");
        inorder(root);

        constructBSTWithSumOfSmallerkeys(root);
        System.out.println();
        System.out.println("After change");
        inorder(root);
    }

    private static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    private static void constructBSTWithSumOfSmallerkeys(Node root) {
        if(root == null) {
            return;
        }

        constructBSTWithSumOfSmallerkeys(root.left);
        sum += root.data;
        root.data = sum;
        constructBSTWithSumOfSmallerkeys(root.right);
    }
}
