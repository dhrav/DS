package BinaryTree.Summation;

import BinaryTree.Node;

public class SumOfNumbersFromPath {
    public static void main(String[] args) {
        Node root = new Node(6);
        root.left        = new Node(3);
        root.right       = new Node(5);
        root.left.left  = new Node(2);
        root.left.right = new Node(5);
        root.right.right = new Node(4);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);

        System.out.println(findSumFromPath(root));
    }

    private static int findSumFromPath(Node root) {
        if(root == null) {
            return 0;
        }

       return findSumFromPathUtil(root, 0);
    }

    private static int findSumFromPathUtil(Node root, int pathNumber) {
        if(root == null) {
            return 0;
        }

        pathNumber = (pathNumber * 10) + root.data;
        if(root.left == null && root.right == null) {
            return pathNumber;
        } else {
           return findSumFromPathUtil(root.left, pathNumber) +
            findSumFromPathUtil(root.right, pathNumber);
        }
    }
}
