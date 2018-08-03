package BinaryTree.Summation;

import BinaryTree.Node;

public class SumOfNodesAtMaxDepth {
    class Result {
        int maxSum;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        SumOfNodesAtMaxDepth object = new SumOfNodesAtMaxDepth();

        System.out.println(object.findSumOfMaxDepth(root));
    }

    private int findSumOfMaxDepth(Node root) {
        if(root == null) {
            return 0;
        }

        int maxDepth = getMaxDepth(root);

        Result result = new Result();

        findSumOfMaxDepthUtil(root, maxDepth, result);
        return result.maxSum;
    }

    private int findSumOfMaxDepthUtil(Node root, int maxDepth, Result result) {
        if(root == null) {
            return 0;
        }

        int leftHeight = findSumOfMaxDepthUtil(root.left, maxDepth-1,  result);
        int rightHeight = findSumOfMaxDepthUtil(root.right, maxDepth-1, result);
        if(1 == maxDepth) {
            result.maxSum += root.data;
        }

        return 1+ Math.max(leftHeight, rightHeight);
    }

    private int getMaxDepth(Node root) {
        if(root == null) {
            return 0;
        }

        int leftHeight = getMaxDepth(root.left);
        int rightHeight = getMaxDepth(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
