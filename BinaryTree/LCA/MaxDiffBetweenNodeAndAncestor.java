package BinaryTree.LCA;

import BinaryTree.Node;

public class MaxDiffBetweenNodeAndAncestor {
    static class Result {
        int maxDiff;
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);

        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);

        root.right = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);

        System.out.println(maxDiff(root));
    }

    private static int maxDiff(Node root) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }

        Result r = new Result();

        maxDiffUtil(root, r);
        return r.maxDiff;

    }

    private static int maxDiffUtil(Node root, Result result) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }

        if(root.left == null && root.right == null) {
            return root.data;
        }

        int val = Math.min(maxDiffUtil(root.left, result),
                maxDiffUtil(root.right, result));

        result.maxDiff = Math.max(result.maxDiff, root.data - val);

        //return the smallest of children and current node data
        //so as to maximize the difference between the nodes
        return Math.min(val, root.data);
    }
}
