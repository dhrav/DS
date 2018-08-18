package BinaryTree.Misc;

import BinaryTree.Node;

public class MaxBendPath {
    static class Result {
        int length;
        int bendCount;
    }
    public static void main(String[] args) {
     /*   Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);
        root.right.left.right = new Node(1);
        root.right.left.right.left = new Node(9);*/

        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.left.left = new Node(12);
        root.right.right.left.right = new Node(10);
        root.right.right.left.right.right = new Node(11);
        root.right.right.left.right.right.left = new Node(45);
        root.right.right.left.right.right.right = new Node(13);
        root.right.right.left.right.right.right.right = new Node(14);

        findMaxBendPath(root);
    }

    private static void findMaxBendPath(Node root) {
        if(root == null) {
            return;
        }

        Result result = new Result();
        String bendString = "";
        findMaxBendUtil(root, result, bendString);
        System.out.println(result.length);
    }

    private static void findMaxBendUtil(Node root, Result result, String bendString) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            int bendCount = 0;
            for(int i = 1; i < bendString.length(); i++) {
                if(bendString.charAt(i-1) != bendString.charAt(i)) {
                    bendCount++;
                }
            }

            if(result.bendCount < bendCount) {
                result.bendCount = bendCount;
                result.length = bendString.length();
            }
        }

        findMaxBendUtil(root.left, result, bendString + "L");
        findMaxBendUtil(root.right, result, bendString + "R");
    }
}
