package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

public class InorderPredecessorSuccessorIterative {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        findInorderPredecessorAndSucc(root, 20);
    }

    private static void findInorderPredecessorAndSucc(Node root, int key) {
        if(root == null) {
            System.out.println("Tree is empty");
        }

        int predecessor = 0, successor=0;

        while(root != null) {
            if(root.data == key) {

                //check for predecessor
                if(root.left != null) {
                    Node current = root.left;
                    while(current.right != null) {
                        current = current.right;
                    }

                    predecessor = current.data;
                }

                //check for successor
                if(root.right != null) {
                    Node current = root.right;
                    while(current.left != null) {
                        current = current.left;
                    }

                    successor = current.data;
                }
                break;
            } else if(root.data < key) {
                predecessor = root.data;
                root = root.right;
            } else {
                successor = root.data;
                root = root.left;
            }
        }
        System.out.println("Predecessor is " + predecessor);
        System.out.println("Successor is " + successor);
    }
}
