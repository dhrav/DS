package BinaryTree.Misc;

import BinaryTree.Node;

public class LongestPathWithSameValue {
    static class Result {
        int maxLength;
    }
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(4);
        root.right = new Node(4);
        root.left.left = new Node(4);
        root.left.right = new Node(9);
        root.right.right = new Node(5);

        findLongestPathWithSameValue(root);
    }

    private static void findLongestPathWithSameValue(Node root) {
        if(root == null) {
            System.out.println("Tree empty");
            return;
        }

        Result result = new Result();
        findLongestPathWithSameValueUtil(root, result, 0, null);
        System.out.println(result.maxLength);
    }

    private static void findLongestPathWithSameValueUtil(Node root, Result result, int curPathlength, Node prev) {
        if(root == null) {
            return;
        }

        if(prev != null) {
            int diff = root.data - prev.data;
            if(diff == 0) {
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

        findLongestPathWithSameValueUtil(root.left, result, curPathlength, prev);
        findLongestPathWithSameValueUtil(root.right, result, curPathlength, prev);
    }
}
