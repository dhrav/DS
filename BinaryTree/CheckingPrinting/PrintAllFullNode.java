package BinaryTree.CheckingPrinting;

import BinaryTree.Node;

public class PrintAllFullNode {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.right = new Node(7);
        root.right.right.right = new Node(8);
        root.right.left.right.left = new Node(9);
        findFullNode(root);
    }

    private static void findFullNode(Node root) {
        if(root == null) {
            return;
        }

        if(isFullNode(root)) {
            System.out.println(root.data);
        }

        findFullNode(root.left);
        findFullNode(root.right);
    }

    private static boolean isFullNode(Node root) {
        return (root.left != null && root.right != null);
    }
}
