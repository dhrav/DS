package BinaryTree.Misc;

import BinaryTree.Node;

public class MaxLeftNode {
    static class Result {
        int maxLeftNode;
    }
    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(6);
        root.right = new Node(5);
        root.left.left = new Node(4);
        root.left.right = new Node(3);
        root.right.left = new Node(2);
        root.right.left.left = new Node(20);
        root.right.right = new Node(1);

        printMaxLeftNode(root);
    }

    private static void printMaxLeftNode(Node root) {
        if(root == null) {
            System.out.println("Empty Tree");
            return;
        }

        Result result = new Result();
        printMaxLeftUtil(root, result, false);
        System.out.println("Max left Node is " + result.maxLeftNode);
    }

    private static void printMaxLeftUtil(Node root, Result result, boolean isLeft) {
        if(root == null) {
            return;
        }

        if(isLeft) {
            if(result.maxLeftNode < root.data) {
                result.maxLeftNode = root.data;
            }
        }

        printMaxLeftUtil(root.left, result, true);
        printMaxLeftUtil(root.right, result, false);
    }
}
