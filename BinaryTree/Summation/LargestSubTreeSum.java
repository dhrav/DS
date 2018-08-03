package BinaryTree.Summation;

import BinaryTree.Node;

public class LargestSubTreeSum {
    class Result {
        int maxSum;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(-2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(2);

        LargestSubTreeSum object = new LargestSubTreeSum();
        System.out.println(object.findMaxSubTreeSum(root));
    }

    private int findMaxSubTreeSum(Node root) {
        if(root == null) {
           return 0;
        }

        Result result = new Result();
        findMaxSubTreeSumUtil(root, result);
        return result.maxSum;

    }

    private int subTreeSum(Node root) {
        if(root == null) {
            return 0;
        }

        return root.data + subTreeSum(root.left) + subTreeSum(root.right);
    }

    private int findMaxSubTreeSumUtil(Node root, Result result) {
        if(root == null) {
            return 0;
        }

        int leftSubTreeSum = subTreeSum(root.left);
        int rightSubTreeSum = subTreeSum(root.right);

        //subtree sum rooted at current node

        int currentSum = root.data + leftSubTreeSum + rightSubTreeSum;
        if(result.maxSum < currentSum) {
            result.maxSum = currentSum;
        }

        findMaxSubTreeSumUtil(root.left, result);
        findMaxSubTreeSumUtil(root.right, result);

        return currentSum;

        //return root.data + findMaxSubTreeSumUtil(root.left, result) + findMaxSubTreeSumUtil(root.right, result);
    }
}
