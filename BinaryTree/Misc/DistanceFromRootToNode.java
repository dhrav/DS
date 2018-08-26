package BinaryTree.Misc;

import BinaryTree.Node;

public class DistanceFromRootToNode {
    static class Result {
        int distance;
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.left.right = new Node(25);
        root.left.right.right = new Node(45);
        root.right.left = new Node(30);
        root.right.right = new Node(35);
        int key = 35;

        Result result = new Result();
        countDistance(root, key, result, 0);
        System.out.println(result.distance);
    }

    private static void countDistance(Node root, int key, Result result, int distance) {
        if(root == null) {
            return;
        }
        if(root.data == key) {
            result.distance = distance;
            return;
        }

        countDistance(root.left, key, result, distance+ 1);
        countDistance(root.right, key, result, distance+ 1);
    }
}
