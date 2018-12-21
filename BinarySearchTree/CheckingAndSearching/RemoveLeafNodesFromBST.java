package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

public class RemoveLeafNodesFromBST {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.left.left = new Node(5);
        root.left.right = new Node(15);
        root.right = new Node(30);
        root.right.left = new Node(25);
        root.right.right = new Node(35);

        System.out.println("Before change");
        inorder(root);

        System.out.println();
        root = removeLeaf(root);

        System.out.println("After change");
        inorder(root);


    }

    private static Node removeLeaf(Node root) {
        if(root == null || (root.left == null && root.right == null)) {
            return null;
        }

        root.left = removeLeaf(root.left);
        root.right = removeLeaf(root.right);
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
