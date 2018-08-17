package BinaryTree.Misc;

import BinaryTree.Node;

public class GetLevel {
    static class Result {
        int level;
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(4);

        Result result = new Result();
        getLevel(root, 2, 1, result);

        System.out.println(result.level);
    }

    private static void getLevel(Node root, int key, int level, Result result) {
        if(root == null) {
            return;
        }

        if(root.data == key) {
            result.level = level;
            return;
        }

        getLevel(root.left, key, level+1, result);
        getLevel(root.right, key, level+1, result);
    }
}
