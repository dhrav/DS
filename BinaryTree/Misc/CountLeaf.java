package BinaryTree.Misc;

import BinaryTree.Node;

public class CountLeaf {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left        = new Node(2);
        root.right       = new Node(3);
        root.left.left  = new Node(4);
        root.left.right = new Node(5);
        root.right.left  = new Node(6);
        root.right.right = new Node(7);

        System.out.println(countLeaf(root));
    }

    private static int countLeaf(Node root) {
        if(root == null) {
            return 0;
        }

        if(root.left == null && root.right == null) {
            return 1;
        }

        return countLeaf(root.left) + countLeaf(root.right);
    }

}
