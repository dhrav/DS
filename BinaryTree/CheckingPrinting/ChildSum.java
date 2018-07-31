package BinaryTree.CheckingPrinting;

import BinaryTree.Node;

public class ChildSum {
    public static void main(String[] args) {
        Node root  = new Node(11);
       // Node root  = new Node(10);
        root.left         = new Node(8);
        root.right        = new Node(2);
        root.left.left   = new Node(3);
        root.left.right  = new Node(5);
        root.right.right = new Node(2);

        System.out.println(checkChildSum(root));
    }

    private static boolean checkChildSum(Node root) {

        if(root == null) {
            return true;
        }

        if(root.left == null && root.right == null) {
            return true;
        }

        boolean left = checkChildSum(root.left);
        boolean right = checkChildSum(root.right);

      /* if(!left || !right) {
           return false;
       }*/
        int leftData = root.left == null ? 0: root.left.data;
        int rightData = root.right == null ? 0: root.right.data;

        //return (root.data == (leftData + rightData)) ? true : false;
        return (root.data == (leftData + rightData)) && left && right;

    }
}
