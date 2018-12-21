package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

public class SumOfKSmallestElement {
    static class Result {
        int currentCount;
        int sum;
    }
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);

        Result result = new Result();
        findSumOfKSmallestElements(root, 4, result);
        System.out.println(result.sum);

    }

    private static void findSumOfKSmallestElements(Node root, int k, Result result) {
        if(root == null) {
            return;
        }

        findSumOfKSmallestElements(root.left, k, result);
        if(result.currentCount < k) {
            result.currentCount++;
            result.sum+=root.data;
        }
        findSumOfKSmallestElements(root.right, k, result);
    }
}
