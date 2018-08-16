package BinaryTree.Misc;

import BinaryTree.Node;

public class FindDeepestLeftLeafRecursive {
    static class Result {
        int maxLevel;
        int data;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.right = new Node(7);
        root.right.right.right = new Node(8);
        root.right.left.right.left = new Node(91);
        root.right.right.right.right = new Node(10);

        Result result = new Result();
        findDeepestLeftLeaf(root, result, 0);
        System.out.println(result.data);
    }

    private static int findDeepestLeftLeaf(Node root, Result result, int level) {
        if(root == null) {
            return 0;
        }

        int leftLevel = findDeepestLeftLeaf(root.left, result, level+1);
        int rightLevel = findDeepestLeftLeaf(root.right, result, level+1);

        if(root.left != null && root.left.left == null && root.left.right == null) {
            if(result.maxLevel < level) {
                result.maxLevel = level;
                result.data = root.left.data;
            }
        }

        return Math.max(leftLevel, rightLevel);

    }
}
