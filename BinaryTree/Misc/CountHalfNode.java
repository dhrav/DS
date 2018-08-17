package BinaryTree.Misc;

import BinaryTree.Node;

public class CountHalfNode {
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left     = new Node(7);
        root.right     = new Node(5);
        root.left.right = new Node(6);
        root.left.right.left = new Node(1);
        root.left.right.right = new Node(11);
        root.right.right = new Node(9);
        root.right.right.left = new Node(4);

        System.out.println(countHalfNode(root));
    }

    private static int countHalfNode(Node root) {
        if(root == null || (root.left == null && root.right == null)) {
            return 0;
        }

        int leftNodeCount = countHalfNode(root.left);
        int rightNodeCount = countHalfNode(root.right);
        int currentCount = 0;

        if((root.left != null && root.right == null) || (root.left == null && root.right != null)) {
            currentCount = 1;
        }

        return currentCount + leftNodeCount + rightNodeCount;
    }
}
