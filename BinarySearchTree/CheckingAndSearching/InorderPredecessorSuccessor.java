package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

public class InorderPredecessorSuccessor {
    static class Result {
        int predecessor;
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
        findInorderPredecessorAndSucc(root, 21, result);
        System.out.println("Inorder predecessor is " + result.predecessor);
        System.out.println("Inorder successor is " + result.successor);
    }

    private static void findInorderPredecessorAndSucc(Node root, int key, Result result) {
        if(root == null) {
            return;
        }

        if(root.data == key) {
            //check for successor
            if(root.right != null) {
                Node current = root.right;
                while(current.left != null) {
                    current = current.left;
                }

                result.successor = current.data;
            }


            //check for predecessor
            if(root.left != null) {
                Node current = root.left;
                while(current.right != null) {
                    current = current.right;
                }

                result.predecessor = current.data;
            }
        } else if(root.data < key) {
            result.predecessor = root.data;
            findInorderPredecessorAndSucc(root.right, key, result);
        } else {
            result.successor = root.data;
            findInorderPredecessorAndSucc(root.left, key, result);
        }
    }
}
