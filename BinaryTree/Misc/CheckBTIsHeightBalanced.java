package BinaryTree.Misc;

import BinaryTree.Node;

public class CheckBTIsHeightBalanced {
    static class Height {
        int height;
    }
    public static void main(String[] args) {
       /* Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.left.left.left = new Node(7);*/
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(8);

        System.out.println(isHeightBalanced(root));
    }

    private static boolean isHeightBalanced(Node root) {
        if(root == null) {
            return true;
        }

        Height height = new Height();
        return checkHeightBalancedUtil(root, height);
    }

    private static boolean checkHeightBalancedUtil(Node root, Height height) {
        if(root == null) {
            return true;
        }

        Height leftHeight = new Height();
        Height rightHeight = new Height();

        boolean leftTree  = checkHeightBalancedUtil(root.left, leftHeight);
        boolean rightTree = checkHeightBalancedUtil(root.right, rightHeight);

        height.height = 1+ Math.max(leftHeight.height, rightHeight.height);

        int diff = Math.abs(leftHeight.height - rightHeight.height);
        if(diff > 1) {
            return false;
        }

        return leftTree && rightTree;
    }
}
