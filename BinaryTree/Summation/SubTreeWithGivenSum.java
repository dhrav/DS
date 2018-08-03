package BinaryTree.Summation;

import BinaryTree.Node;

public class SubTreeWithGivenSum {
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left    = new Node(5);
        root.right   = new Node(4);
        root.left.left = new Node(9);
        root.left.right = new Node(7);
       // root.left.right.left = new Node(11);
        root.left.right.left = new Node(1);
        root.left.right.right = new Node(12);
        root.left.right.right.right = new Node(2);
        root.right.right = new Node(11);
        root.right.right.left = new Node(3);

        int sum = 22;

        System.out.println(checkForSubTree(root, sum));
    }

    private static int subTreeSum(Node root) {
        if(root == null) {
            return 0;
        }

        return root.data + subTreeSum(root.left) + subTreeSum(root.right);
    }

    private static boolean checkForSubTree(Node root, int sum) {
        if(root == null) {
            return false;
        }

        //sum of subtree rooted at given node
        int currentSum = root.data + subTreeSum(root.left) + subTreeSum(root.right);

        if(currentSum == sum) {
            return true;
        }


        return checkForSubTree(root.left, sum) || checkForSubTree(root.right, sum);
    }
}
