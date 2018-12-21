package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

public class InorderSuccessor {
    static class Result {
        int successor;
    }
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        Result result = new Result();
        findSuccessor(root, 20, result);
        System.out.println(result.successor);
    }

    private static void findSuccessor(Node root, int key, Result result) {
        if(root == null) {
            return;
        }

        if(root.data == key) {
            if(root.right != null) {
                Node current = root.right;
                while(current.left != null) {
                    current = current.left;
                }

                result.successor = current.data;
            }
        } else if(root.data < key) {
            findSuccessor(root.right, key, result);
        } else { //if root.data > key
            result.successor = root.data;
            findSuccessor(root.left, key, result);
        }
    }
}
