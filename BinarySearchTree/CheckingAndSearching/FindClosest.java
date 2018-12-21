package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

public class FindClosest {
    static class Result {
        int element;
        int minDiff = Integer.MAX_VALUE;
    }
    public static void main(String[] args) {
        int arr[] = {9, 4, 17, 3, 6, 5, 7, 22, 20};
        int k = 12;

        Node root = constructTree(arr);
        Result result = new Result();
        findClosest(root, k, result);
        System.out.println("The closest Element is " + result.element);
    }

    private static void findClosest(Node root, int k, Result result) {
        if(root == null) {
            return;
        }

        int minimum = Math.min(result.minDiff, Math.abs(root.data-k));
        if(minimum != result.minDiff) {
            result.minDiff = minimum;
            result.element = root.data;
        }
        if(root.data == k) {
            return;
        } else if(root.data < k) {
            findClosest(root.right, k, result);
        } else {
            findClosest(root.left, k, result);
        }
    }

    private static Node constructTree(int[] arr) {
        Node root = null;
        for(int i : arr) {
            root = insert(root, i);
        }
        return root;
    }

    private static Node insert(Node root, int i) {
        if(root == null) {
            return new Node(i);
        }

        if(root.data < i) {
            root.right = insert(root.right, i);
        } else if(root.data > i) {
            root.left = insert(root.left, i);
        }
        return root;
    }
}
