package BinaryTree.Misc;

import BinaryTree.Node;

public class ClosestLeaf {
    static class Result {
        int data;
        int level = Integer.MAX_VALUE;
    }
    public static void main(String[] args) {
        Node root  = new Node(1);
        root.left  = new Node(12);
        root.right = new Node(13);

        root.right.left   = new Node(14);
        root.right.right  = new Node(15);

        root.right.left.left   = new Node(21);
        root.right.left.right  = new Node(22);
        root.right.right.left  = new Node(23);
        root.right.right.right = new Node(24);

        root.right.left.left.left  = new Node(1);
        root.right.left.left.right = new Node(2);
        root.right.left.right.left  = new Node(3);
        root.right.left.right.right = new Node(4);
        root.right.right.left.left  = new Node(5);
        root.right.right.left.right = new Node(6);
        root.right.right.right.left = new Node(7);
        root.right.right.right.right = new Node(8);

        Node x = root.right;

        Result result = new Result();

       // findClosestLeaf(x, result, 0);
        findClosestLeaf(root, result, 0);
        System.out.println(result.data);
    }

    private static void findClosestLeaf(Node x, Result result, int currentLevel) {
        if(x == null) {
            return;
        }

        if(x.left == null && x.right == null) {
            if(result.level > currentLevel) {
                result.level = currentLevel;
                result.data = x.data;
            }
        }

        findClosestLeaf(x.left, result, currentLevel+1);
        findClosestLeaf(x.right, result, currentLevel+1);


    }
}
