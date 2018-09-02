package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

public class CountAndPrintAllNodesInRange {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left     = new Node(5);
        root.right     = new Node(50);
        root.left.left = new Node(1);
        root.right.left = new Node(40);
        root.right.right = new Node(100);

        int low=5;
        int high=45;

        int count = countAndPrintNodesInRange(root, low, high);
        System.out.println();
        System.out.println(count);
    }

    private static int countAndPrintNodesInRange(Node root, int low, int high) {
        if(root == null) {
            return 0;
        }

        if(root.data >= low && root.data <= high) {
            System.out.print(root.data + " ");
            return 1 + countAndPrintNodesInRange(root.left, low, high) + countAndPrintNodesInRange(root.right, low, high);
        } else if(root.data > high) {
            return countAndPrintNodesInRange(root.left, low, high);
        } else {
            return countAndPrintNodesInRange(root.right, low, high);
        }
    }
}
