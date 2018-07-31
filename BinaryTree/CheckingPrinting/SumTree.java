package BinaryTree.CheckingPrinting;

import BinaryTree.Node;

public class SumTree {
    public static void main(String[] args) {
        //Node root  = new Node(26);
        Node root  = new Node(27);
        root.left         = new Node(10);
        root.right        = new Node(3);
        root.left.left   = new Node(4);
        root.left.right  = new Node(6);
        root.right.right = new Node(3);
        System.out.println(checkSumTree(root));
    }

    private static int subTreeSum(Node root) {
        if(root == null) {
            return 0;
        }

        return subTreeSum(root.left) + root.data + subTreeSum(root.right);
    }

    private static boolean checkSumTree(Node root) {
        if(root == null || (root.left == null && root.right == null)) {
            return true;
        }

        int leftData = subTreeSum(root.left);
        int rightData = subTreeSum(root.right);

       return (root.data == (leftData + rightData)) && checkSumTree(root.left) && checkSumTree(root.right);
    }
}
