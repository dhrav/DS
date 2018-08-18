package BinaryTree.Misc;

import BinaryTree.Node;

public class RemoveAllHalfNodes {
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left        = new Node(7);
        root.right       = new Node(5);
        root.left.right = new Node(6);
        root.left.right.left=new Node(1);
        root.left.right.right=new Node(11);
        root.right.right=new Node(9);
        root.right.right.left=new Node(4);

        System.out.println("Before change");
        inorder(root);

        root = removeAllHalfNodes(root);
        System.out.println("After Change");
        inorder(root);
    }

    private static Node removeAllHalfNodes(Node root) {
        if(root == null) {
            return null;
        }

        root.left = removeAllHalfNodes(root.left);
        root.right = removeAllHalfNodes(root.right);

        if(root.left != null && root.right == null) {
           root = root.left;
        } else if(root.left == null && root.right != null) {
            root = root.right;
        }

        return root;
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
