package BinaryTree.Summation;

import BinaryTree.Node;

public class SumOfLeftLeaf {
    public static void main(String[] args) {
        Node root         = new Node(20);
        root.left                = new Node(9);
        root.right               = new Node(49);
        root.right.left         = new Node(23);
        root.right.right        = new Node(52);
        root.right.right.left  = new Node(50);
        root.left.left          = new Node(5);
        root.left.right         = new Node(12);
        root.left.right.right  = new Node(12);

        System.out.println(findLeftLeafSum(root));
    }

    static class Result {
        int sum;
    }

    private static int findLeftLeafSum(Node root) {
        if(root == null) {
            return 0;
        }
        Result result = new Result();
        findLeftLeafSumUtil(root, result, false);
        return result.sum;
    }

    private static void findLeftLeafSumUtil(Node root, Result result, boolean isLeft) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null && isLeft) {
            result.sum += root.data;
        }

        findLeftLeafSumUtil(root.left, result, true);
        findLeftLeafSumUtil(root.right, result, false);


    }
}
