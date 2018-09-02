package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

public class PrintNodeInGivenRangeMorris {
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(10);

        int low = 4;
        int high = 12;
        printNodeInRange(root, low, high);
    }

    private static void printNodeInRange(Node root, int low, int high) {
        if(root == null) {
            return;
        }

        Node current = root;
        while(current != null) {
            if(current.left == null) {
                if(current.data >= low && current.data <= high) {
                    System.out.print(current.data + " ");
                }
                current = current.right;
            } else {
                Node prev = current.left;
                while(prev.right != null && prev.right != current) {
                    prev = prev.right;
                }

                if(prev.right == null) {
                    prev.right= current;
                    current = current.left;
                } else {
                    prev.right = null;
                    if(current.data >= low && current.data <= high) {
                        System.out.print(current.data + " ");
                    }
                    current = current.right;
                }
            }
        }
    }

}
