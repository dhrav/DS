package BinaryTree.Summation;

import BinaryTree.Node;

import java.util.HashMap;

public class MaxSumWithNoAdjacentNodes {
    class Result {
        int maxSum;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.left.left = new Node(1);

        MaxSumWithNoAdjacentNodes object = new MaxSumWithNoAdjacentNodes();
        System.out.println(object.getSum(root));
    }

    private int getSum(Node root) {
        if(root == null) {
            return 0;
        }
        Result result = new Result();
        HashMap nodeToSumMap =new HashMap<>();

        getSumUtil(root, result, nodeToSumMap);
        return result.maxSum;
    }

    private int getSumUtil(Node root, Result result, HashMap<Node,Integer> nodeToSumMap) {
        if(root == null) {
            return 0;
        }

        if(nodeToSumMap.containsKey(root)) {
            return nodeToSumMap.get(root);
        }

        int includeSum = root.data + sumOfGrandChildren(root, result, nodeToSumMap);
        int excludeSum = getSumUtil(root.left, result, nodeToSumMap) +
                getSumUtil(root.right, result, nodeToSumMap);

        int currentSum = Math.max(includeSum, excludeSum);
        if(result.maxSum < currentSum) {
            result.maxSum = currentSum;
        }

        nodeToSumMap.put(root, currentSum);

        return currentSum;
    }

    private int sumOfGrandChildren(Node root, Result result, HashMap<Node,Integer> nodeToSumMap) {
        if(root == null) {
            return 0;
        }

        int sum = 0;

        if(root.left != null) {
           sum += getSumUtil(root.left.left, result, nodeToSumMap) + getSumUtil(root.left.right, result, nodeToSumMap);
        }

        if(root.right != null) {
            sum += getSumUtil(root.right.left, result, nodeToSumMap) + getSumUtil(root.right.right, result, nodeToSumMap);
        }

        return sum;
    }
}
