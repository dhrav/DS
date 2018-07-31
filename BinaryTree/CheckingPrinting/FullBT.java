package BinaryTree.CheckingPrinting;

import BinaryTree.Node;

public class FullBT {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);

        root.left.right = new Node(40);
        root.left.left = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        root.left.left.left = new Node(80);
        root.left.left.right = new Node(90);
        root.left.right.left = new Node(80);
        root.left.right.right = new Node(90);
        root.right.left.left = new Node(80);
        root.right.left.right = new Node(90);
        root.right.right.left = new Node(80);
        //root.right.right.right = new Node(90);

        System.out.println(isFullBT(root));
    }

    private static boolean isFullBT(Node root) {
        if(root == null) {
            return true;
        }

        return ((root.left == null && root.right == null) || (root.left != null && root.right != null)) &&
                isFullBT(root.left) && isFullBT(root.right);
    }
}
