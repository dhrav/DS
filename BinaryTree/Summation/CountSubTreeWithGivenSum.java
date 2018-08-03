package BinaryTree.Summation;

import BinaryTree.Node;

public class CountSubTreeWithGivenSum {
    class Result {
        int count;
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(-10);
        root.right = new Node(3);
        root.left.left = new Node(9);
        root.left.right = new Node(8);
        root.right.left = new Node(-4);
        root.right.right = new Node(7);
        int sum = 7;
        CountSubTreeWithGivenSum object = new CountSubTreeWithGivenSum();

        System.out.println(object.countSubTree(root, sum));
    }

    private int countSubTree(Node root, int sum) {
        if(root == null) {
            return 0;
        }

        Result result = new Result();
        countSubTreeUtil(root, result, sum);
        return  result.count;
    }

    private int subTreeSum(Node root) {
        if(root == null) {
            return 0;
        }

        return root.data + subTreeSum(root.left) + subTreeSum(root.right);
    }

    private void countSubTreeUtil(Node root, Result result, int sum) {
        if(root == null) {
            return;
        }

        int currentSum = root.data + subTreeSum(root.left) + subTreeSum(root.right);
        if(currentSum == sum) {
            result.count += 1;
        }

        countSubTreeUtil(root.left, result, sum);
        countSubTreeUtil(root.right, result, sum);



    }
}
