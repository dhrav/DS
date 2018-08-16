package BinaryTree.Misc;

import BinaryTree.Node;

public class HeightOfSpecialBT {
    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(6);

        // Given tree contains 3 leaf nodes
        Node L1 = root.left.left.left;
        Node L2 = root.left.right;
        Node L3 = root.right;

        // create circular doubly linked list out of
        // leaf nodes of the tree

        // set next pointer of linked list
        L1.right = L2;
        L2.right = L3;
        L3.right = L1;

        // set prev pointer of linked list
        L3.left = L2;
        L2.left = L1;
        L1.left = L3;

        System.out.println(findMaxDepth(root));
    }

    private static int findMaxDepth(Node root) {
        if(root == null) {
            return 0;
        }

        if(root.left != null && root.right != null && root.right.left == root) {
            return 1;
        }

        int leftHeight = findMaxDepth(root.left);
        int rightHeight = findMaxDepth(root.right);

        return 1+ Math.max(leftHeight, rightHeight);
    }
}
