package BinarySearchTree;

import BinaryTree.Node;

public class BSTToGreaterSumTree {
    static int sum;
    public static void main(String[] args) {
        Node root = new Node(11);
        root.left = new Node(2);
        root.right = new Node(29);
        root.left.left = new Node(1);
        root.left.right = new Node(7);
        root.right.left = new Node(15);
        root.right.right = new Node(40);
        root.right.right.left = new Node(35);

        System.out.println("Before change: ");
        inorder(root);

        convertToGreaterSumTree(root);
        System.out.println();

        System.out.println("After change");
        inorder(root);
    }

    private static void convertToGreaterSumTree(Node root) {
        if(root == null) {
            return;
        }

        convertToGreaterSumTree(root.right);
        int temp = sum;
        sum+= root.data;
        root.data = temp;
        convertToGreaterSumTree(root.left);
    }

    private static void inorder(Node root) {
        if(root== null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}
