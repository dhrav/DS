package BinarySearchTree.Misc;

import BinaryTree.Node;

public class CorrectBST {
    static Node prev, first, last, middle;
    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(10);
        root.right = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(12);
        root.right.left = new Node(7);

        System.out.println("Inorder traversal before correction:");
        inorder(root);
        //only two nodes are swapped - correct them
        correctBST(root);

        System.out.println("Inorder traversal after correction");
        inorder(root);
    }

    private static void correctBST(Node root) {
        correctBSTUtil(root);

        if(first != null && last != null) {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        } else if(first != null && middle != null) {
            int temp = middle.data;
            middle.data = first.data;
            first.data = temp;
        }
    }

    private static void correctBSTUtil(Node root) {
        if(root == null) {
            return;
        }

        correctBSTUtil(root.left);

        //compare the prev and current and populate the pointers accordingly
        if(prev != null && root.data < prev.data) {
            if(first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }

        prev = root;

        correctBSTUtil(root.right);
    }

    private static void inorder(Node root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
}
