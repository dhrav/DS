package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

public class KLargestElement {
    static class Result {
        int kthLargest;
        int currentCount;
    }
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        int k=2;
        System.out.println(findKth(root, k));
    }

    private static int findKth(Node root, int k) {
        if(root == null) {
            return -1;
        }

        Result result = new Result();
        findKthUtil(root, k, result);
        return result.kthLargest;
    }

    private static void findKthUtil(Node root, int k, Result result) {
        if(root == null) {
            return;
        }

        findKthUtil(root.right, k, result);
        result.currentCount+=1;
        if(k == result.currentCount) {
            result.kthLargest = root.data;
            return;
        }
        findKthUtil(root.left, k, result);
    }
}
