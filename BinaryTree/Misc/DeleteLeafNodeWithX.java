package BinaryTree.Misc;

import BinaryTree.Node;

public class DeleteLeafNodeWithX {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(1);
        root.right.right = new Node(3);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(3);

        int x = 3;
        root = deleteWithNodeX(root, x);
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

    private static Node deleteWithNodeX(Node root, int x) {
        if(root == null) {
            return null;
        }

        root.left = deleteWithNodeX(root.left, x);
        root.right = deleteWithNodeX(root.right, x);
        if(root.data == x && root.left == null && root.right == null) {
            root = null;
            return null;
        }
        return root;
    }


}
