package BinaryTree.Summation;

import BinaryTree.Node;

public class MaxSumWithNoAdjacentLevels {
    class Result {
        int maxSum;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.left.right = new Node(5);
        root.right.left.right.left = new Node(6);
        MaxSumWithNoAdjacentLevels object = new MaxSumWithNoAdjacentLevels();
        System.out.println(object.getSum(root));
    }

    private int getSum(Node root) {
        if(root == null) {
            return 0;
        }

        Result result = new Result();
        getSumUtil(root, result);
        return result.maxSum;

    }

    private int getSumUtil(Node root, Result result) {
        if(root == null) {
            return 0;
        }

        int leftSum=0, rightSum=0;
        if(root.left != null) {
            leftSum = getSumUtil(root.left.left, result) + getSumUtil(root.left.right, result);
        }

        if(root.right != null) {
            rightSum = getSumUtil(root.right.left, result) + getSumUtil(root.right.right, result);
        }

        int currentSum =  root.data + leftSum + rightSum;
        if(result.maxSum < currentSum) {
            result.maxSum = currentSum;
        }

        getSumUtil(root.left, result);
        getSumUtil(root.right, result);

        return currentSum;

    }
}
