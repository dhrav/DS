package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

public class CheckIfBSTContainsDeadEnd {
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(9);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.left.left.left = new Node(1);

        System.out.println(checkIfDeadEndExists(root));
    }

    private static boolean checkIfDeadEndExists(Node root) {
        if(root == null) {
            return false;
        }
        //here minvalue is passed as 1 (based on the given qn)
        return checkForDeadEndUtil(root, 1, Integer.MAX_VALUE);
    }

    private static boolean checkForDeadEndUtil(Node root, int minValue, int maxValue) {
        if(root == null) {
            return false;
        }

        if(minValue == maxValue) {
            return true;
        }

        return checkForDeadEndUtil(root.left, minValue, root.data -1) ||
                checkForDeadEndUtil(root.right, root.data + 1, maxValue);
    }
}
