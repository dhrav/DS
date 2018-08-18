package BinaryTree.Misc;

import BinaryTree.Node;

public class MaxConsecutiveIncreasingPathLength {
    static class Result {
        int maxLength;
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.right = new Node(9);
        root.left.left = new Node(13);
        root.left.right = new Node(12);
        root.right.left = new Node(13);
        root.right.right = new Node(8);

        findMaxIncreasingPathLength(root);
    }

    private static void findMaxIncreasingPathLength(Node root) {
        if(root == null) {
            System.out.println("Tree empty");
            return;
        }

        Result result = new Result();
        findMaxPathLengthUtil(root, result, 0, null);
        System.out.println(result.maxLength);
    }

    private static void findMaxPathLengthUtil(Node root, Result result, int curPathlength, Node prev) {
        if(root == null) {
            return;
        }

        if(prev != null) {
            int diff = root.data - prev.data;
            if(diff == 1) {
                curPathlength++;
            } else {
                curPathlength = 1;
            }
        } else {
            curPathlength = 1;
        }
        prev = root;

        if(result.maxLength < curPathlength) {
            result.maxLength = curPathlength;
        }

        findMaxPathLengthUtil(root.left, result, curPathlength, prev);
        findMaxPathLengthUtil(root.right, result, curPathlength, prev);
    }
}
