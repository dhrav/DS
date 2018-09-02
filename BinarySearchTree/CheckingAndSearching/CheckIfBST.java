package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

public class CheckIfBST {
    public static void main(String[] args) {
        /*Node root = new Node(4);
        root.left        = new Node(2);
        root.right       = new Node(5);
        root.left.left  = new Node(1);
        root.left.right = new Node(3);*/

        Node root = new Node(3);
        root.left        = new Node(2);
        root.right       = new Node(5);
        root.left.left  = new Node(1);
        root.left.right = new Node(4);

        //Method:1
        //Do inorder traversal and check whether it is in sored order

        //Method:2
        //pass min and max to each traversal to verify the property at tree level
        System.out.println(checkIfBST(root));
    }

    private static boolean checkIfBST(Node root) {
        if(root== null) {
            return true;
        }

        return checkIfBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    private static boolean checkIfBSTUtil(Node root, int minValue, int maxValue) {
        if(root == null) {
            return true;
        }

        if(root.data < minValue || root.data > maxValue) {
            return false;
        }

        return checkIfBSTUtil(root.left, minValue, root.data) && checkIfBSTUtil(root.right, root.data, maxValue);
    }
}
