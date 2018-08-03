package BinaryTree.Summation;

import BinaryTree.Node;

public class SumOfHeights {
    class Result {
        int sum;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        SumOfHeights object = new SumOfHeights();
        System.out.println(object.findSumOfHeights(root));
    }

    private int findSumOfHeights(Node root) {
        if(root == null) {
            return 0;
        }

        Result result = new Result();
        findSumUtil(root, result);
        return result.sum;
    }

    private int findSumUtil(Node root, Result result) {
        if(root == null) {
            return 0;
        }

        int leftHeight = findSumUtil(root.left, result);
        int rightHeight = findSumUtil(root.right, result);

        int currentHeight = 1 + Math.max(leftHeight, rightHeight);
        result.sum += currentHeight;
        return  currentHeight;
    }
}
