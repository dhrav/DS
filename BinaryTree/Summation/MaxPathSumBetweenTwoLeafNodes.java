package BinaryTree.Summation;

import BinaryTree.Node;

public class MaxPathSumBetweenTwoLeafNodes {
    public static void main(String[] args) {
        Node root = new Node(-15);
        root.left = new Node(5);
        root.right = new Node(6);
        root.left.left = new Node(-8);
        root.left.right = new Node(1);
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(6);
        root.right.left = new Node(3);
        root.right.right = new Node(9);
        root.right.right.right= new Node(0);
        root.right.right.right.left= new Node(4);
        root.right.right.right.right= new Node(-1);
        root.right.right.right.right.left= new Node(10);

        MaxPathSumBetweenTwoLeafNodes object = new MaxPathSumBetweenTwoLeafNodes();

        System.out.println(object.findMaxPathSumBetweenLeaf(root));
    }

    class Result {
        int maxSum;
    }

    private int findMaxPathSumBetweenLeaf(Node root) {
        if(root == null) {
            return 0;
        }

        Result result = new Result();

        findMaxPathSumUtil(root, result);
        return result.maxSum;

    }

    private int findMaxPathSumUtil(Node root, Result result) {
        if(root == null) {
            return 0;
        }

        if(root.left == null && root.right == null) {
            return root.data;
        }

        int leftMaxSum = findMaxPathSumUtil(root.left, result);
        int rightMaxSum = findMaxPathSumUtil(root.right, result);

        if(root.left != null && root.right != null) {
            //update the final result only if tree is not a skew tree
            //because in skew trees leaf to leaf path doesnt exist
            result.maxSum = Math.max(result.maxSum, leftMaxSum + root.data + rightMaxSum);

            return Math.max(leftMaxSum, rightMaxSum) + root.data;
        } else {
           int subTreeSum = (root.left == null) ? rightMaxSum : leftMaxSum;
           return root.data + subTreeSum;
        }

    }
}
