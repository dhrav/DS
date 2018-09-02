package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

public class IterativeBinarySearch {
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left        = new Node(30);
        root.right       = new Node(70);
        root.left.left  = new Node(20);
        root.left.right = new Node(40);
        root.right.left  = new Node(60);
        root.right.right = new Node(80);

        System.out.println(searchBST(root, 50));
    }

    private static boolean searchBST(Node root, int i) {
        if(root == null) {
            return false;
        }

        Node current = root;

        while(current != null) {
            if(current.data == i) {
                return true;
            }
            if(current.data < i) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return false;
    }
}
