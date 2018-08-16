package BinaryTree.Misc;

import BinaryTree.Node;

public class HeightWithEvenLevelLeaf {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);

        int maxHeightWithEvenLeaf = getHeight(root, 1);
        System.out.println(maxHeightWithEvenLeaf);
    }

    private static int getHeight(Node root, int level) {
        if(root == null) {
            return 0;
        }

        if(root.left == null && root.right == null) {
            if(level % 2 == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        int leftHeight = getHeight(root.left, level+1);
        int rightHeight = getHeight(root.right, level+1);

        if(leftHeight == 0 && rightHeight == 0) {
            return 0;
        }

        return 1+ Math.max(leftHeight, rightHeight);
    }
}
