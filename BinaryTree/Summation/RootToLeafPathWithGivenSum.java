package BinaryTree.Summation;

import BinaryTree.Node;

public class RootToLeafPathWithGivenSum {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left        = new Node(8);
        root.right       = new Node(2);
        root.left.left  = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);

        int keySum = 21;
        System.out.println(isPathSumPresent(root, keySum));
    }

    private static boolean isPathSumPresent(Node root, int keySum) {
        if(root == null) {
            return (keySum == 0);
        } else {

            int curSum = keySum - root.data;
            if(curSum == 0 && (root.left == null && root.right == null)) {
                return true;
            }

            return  isPathSumPresent(root.left, curSum) ||
                    isPathSumPresent(root.right, curSum);

        }
    }

}
