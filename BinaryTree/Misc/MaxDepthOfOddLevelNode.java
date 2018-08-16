package BinaryTree.Misc;

import BinaryTree.Node;

public class MaxDepthOfOddLevelNode {
    static class Result {
        int maxDepth;
    }
    public static void main(String[] args) {
        /*Node root  = new Node(10);
        root.left  = new Node(28);
        root.right = new Node(13);
        root.right.left   = new Node(14);
        root.right.right  = new Node(15);
        root.right.right.left  = new Node(23);
        root.right.right.right = new Node(24);
*/
        Node root  = new Node(5);
        root.left  = new Node(10);
        root.right = new Node(2);
        root.right.right  = new Node(15);
        root.right.right.left  = new Node(9);
        root.right.right.right = new Node(8);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.left.right.left = new Node(44);
        root.left.right.left.right = new Node(12);

        Result result = new Result();
        findMaxDepthForOddLevel(root, 1, result);
        System.out.println(result.maxDepth);
    }

    private static int findMaxDepthForOddLevel(Node root, int level, Result result) {
        if(root == null) {
            return 0;
        }

        if(level % 2 != 0 && level > result.maxDepth) {
            result.maxDepth = level;
        }
        int leftLevel = findMaxDepthForOddLevel(root.left, level +1, result );
        int rightLevel = findMaxDepthForOddLevel(root.right, level +1, result );

        return Math.max(leftLevel, rightLevel);
    }
}
