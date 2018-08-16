package BinaryTree.Misc;

import BinaryTree.Node;

public class MaxDepthOfOddLevelLeafNode {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.right = new Node(7);
        root.right.right.right = new Node(8);
        root.right.left.right.left = new Node(9);
        root.right.right.right.right = new Node(10);
        root.right.right.right.right.left = new Node(11);

       int result =  findMaxDepthForOddLevelLeaf(root, 1);
        System.out.println(result);
    }

    private static int findMaxDepthForOddLevelLeaf(Node root, int level) {
        if(root == null) {
            return 0;
        }

        if(level % 2 != 0 && root.left == null && root.right == null) {
            return level;
        }

        int leftTreeLevel = findMaxDepthForOddLevelLeaf(root.left, level +1 );
        int rightTreeLevel = findMaxDepthForOddLevelLeaf(root.right, level +1 );

       return Math.max(leftTreeLevel, rightTreeLevel);
    }
}
