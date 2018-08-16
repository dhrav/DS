package BinaryTree.Misc;

import BinaryTree.Node;

public class ReplaceNodeWithDepth {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        System.out.println("Before change:");
        inorder(root);

        replaceWithDepth(root, 0);

        System.out.println("After change");
        inorder(root);
    }

    private static void inorder(Node root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    private static void replaceWithDepth(Node root, int level) {
        if(root == null) {
            return;
        }

        root.data = level;

        replaceWithDepth(root.left, level+ 1);
        replaceWithDepth(root.right, level + 1);
    }
}
