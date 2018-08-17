package BinaryTree.Misc;

import BinaryTree.Node;

public class CountSingleValuedSubTrees {
    static class Result {
        int count;
    }
    public static void main(String[] args) {
        Node root        = new Node(5);
        root.left        = new Node(4);
        root.right       = new Node(5);
        root.left.left  = new Node(4);
        root.left.right = new Node(4);
        root.right.right = new Node(5);

        Result result = new Result();
        countSingleValuedSubTree(root, result);
        System.out.println(result.count);
    }

    private static boolean countSingleValuedSubTree(Node root, Result result) {
        if(root == null) {
            return true;
        }

        boolean left = countSingleValuedSubTree(root.left, result);
        boolean right = countSingleValuedSubTree(root.right, result);

        if(!left || !right) {
            return false;
        }

        if(root.left != null && root.data != root.left.data) {
            return false;
        }

        if(root.right != null && root.data != root.right.data) {
            return false;
        }

        result.count++;
        return true;
    }
}
