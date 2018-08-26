package BinaryTree.Misc;

import BinaryTree.Node;

public class NextRight {
    static class Result {
        int nextRight=-1;
        int level=-1;
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(6);
        root.right.right = new Node(5);
        root.left.left = new Node(8);
        root.left.right = new Node(4);
        Result result = new Result();
        int key = 8;
        findNextRight(root, result, 0, key);
        System.out.println(result.nextRight == 0 ? "Not found" : result.nextRight);
    }

    private static void findNextRight(Node root, Result result, int level, int key) {
        if(root == null) {
            return;
        }

        if(level == result.level && result.nextRight == -1) {
            result.nextRight = root.data;
            return;
        }

        if(root.data == key) {
            result.level = level;
        }

        findNextRight(root.left, result, level+1, key);
        findNextRight(root.right, result, level+1, key);
    }
}
