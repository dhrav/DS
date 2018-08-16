package BinaryTree.Misc;

import BinaryTree.Node;

public class MinimumDepth {
    static class Result {
        int minDepth = Integer.MAX_VALUE;
    }
    public static void main(String[] args) {
        Node root        = new Node(1);
        root.left        = new Node(2);
        root.right       = new Node(3);
        root.right.left       = new Node(13);
        root.left.left  = new Node(4);
        root.left.left.left  = new Node(41);
        root.left.right = new Node(5);
        root.left.right.left = new Node(15);

        Result result = new Result();
        findMinDepth(root, result, 1);
        System.out.println(result.minDepth);
    }

    private static int findMinDepth(Node root, Result result, int level) {
        if(root == null) {
            return 0;
        }

        int leftLevel = findMinDepth(root.left, result, level+1);
        int rightLevel = findMinDepth(root.right, result, level+1);


        if(level < result.minDepth && root.left == null && root.right == null) {
            result.minDepth = level;
        }

        return Math.max(leftLevel, rightLevel);
    }
}
