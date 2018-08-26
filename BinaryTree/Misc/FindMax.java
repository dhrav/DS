package BinaryTree.Misc;

import BinaryTree.Node;

public class FindMax {
    static int maxVal = Integer.MIN_VALUE;
    static int minVal = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left        = new Node(7);
        root.right       = new Node(5);
        root.left.right = new Node(6);
        root.left.right.left=new Node(1);
        root.left.right.right=new Node(11);
        root.right.right=new Node(9);
        root.right.right.left=new Node(4);
        findMax(root);
        System.out.println("Maxvalue is " + maxVal);
        System.out.println("Minvalue is " + minVal);
    }

    private static void findMax(Node root) {
        if(root == null) {
            return;
        }

        if(root.data > maxVal) {
            maxVal = root.data;
        }

        if(root.data < minVal) {
            minVal = root.data;
        }

        findMax(root.left);
        findMax(root.right);


    }
}
