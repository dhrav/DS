package BinaryTree.Summation;

import BinaryTree.Node;

public class SumOfNodeWIthChildX {
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(7);
        root.left.right = new Node(2);
        root.right.left = new Node(2);
        root.right.right = new Node(3);

        int x = 2;
        System.out.println(findSumWithChildX(root, x));
    }

    static class Result {
        int sum = 0;
    }

    private static int findSumWithChildX(Node root, int x) {
        if(root == null) {
            return 0;
        }
        Result result = new Result();

        findSumUtil(root, x, result);
        return result.sum;
    }

    private static void findSumUtil(Node root, int x, Result result) {
        if(root == null) {
            return;
        }

        if((root.left != null &&  root.left.data == x) ||
        (root.right != null && root.right.data == x)) {
            result.sum += root.data;
        }
        findSumUtil(root.left, x, result);
        findSumUtil(root.right, x, result);
    }
}
