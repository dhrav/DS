package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

public class CountSubTreeInGivenRange {
    static class Result {
        int count;
    }
    public static void main(String[] args) {
        Node root        = new Node(10);
        root.left        = new Node(5);
        root.right       = new Node(50);
        root.left.left  = new Node(1);
        root.right.left = new Node(40);
        root.right.right = new Node(100);

        int low = 1, high = 45;
        Result result = new Result();
        countSubTreesInRange(root, low, high, result);
        System.out.println(result.count);
    }

    private static boolean countSubTreesInRange(Node root, int low, int high, Result result) {
        if(root == null) {
            return true;
        }

        boolean left = countSubTreesInRange(root.left, low, high, result);
        boolean right = countSubTreesInRange(root.right, low, high, result);

        if(left && right && root.data >= low && root.data <= high) {
            result.count++;
            return true;
        }
        return false;

    }
}
