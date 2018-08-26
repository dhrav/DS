package BinaryTree.Misc;

import BinaryTree.Node;

public class Tilt {
    static class Result {
        int tilt;
    }
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(9);
        root.left.left = new Node(3);
        root.left.right = new Node(8);
        root.right.right = new Node(7);
        Result result = new Result();
        findTilt(root, result);
        System.out.println(result.tilt);

    }

    private static int findTilt(Node root, Result result) {
        if(root == null) {
            return 0;
        }

        int leftSum = findTilt(root.left, result);
        int rightSum = findTilt(root.right, result);

        result.tilt += Math.abs(leftSum - rightSum);

        return root.data + leftSum + rightSum;
    }
}
