package BinaryTree.CheckingPrinting;

import BinaryTree.Node;

public class CheckAllLeaves {
    static int firstLeafLevel = 0;
    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(9);
        root.left.left.left = new Node(1);
        //root.left.right.left = new Node(1);

        System.out.println(checkLeafLevel(root, 0));

    }

    private static boolean checkLeafLevel(Node root, int level) {
        if(root == null) {
            return true;
        }

        if(root.left == null && root.right == null) {
            if(firstLeafLevel == 0) {
                firstLeafLevel = level;
                return true;
            }

            return firstLeafLevel == level;
        }

        return checkLeafLevel(root.left, level+1) &&
        checkLeafLevel(root.right, level+1);
    }
}
