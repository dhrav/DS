package BinaryTree.Misc;

import BinaryTree.Node;

public class Isomorphism {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.left        = new Node(2);
        n1.right       = new Node(3);
        n1.left.left  = new Node(4);
        n1.left.right = new Node(5);
        n1.right.left  = new Node(6);
        n1.left.right.left = new Node(7);
        n1.left.right.right = new Node(8);

        Node n2 = new Node(1);
        n2.left         = new Node(3);
        n2.right        = new Node(2);
        n2.right.left   = new Node(4);
        n2.right.right   = new Node(5);
        n2.left.right   = new Node(6);
        n2.right.right.left = new Node(8);
        n2.right.right.right = new Node(7);

        System.out.println(isIsomorphic(n1,n2));
    }

    private static boolean isIsomorphic(Node n1, Node n2) {
        if(n1 == null && n2 == null) {
            return true;
        }

        if(n1 == null || n2 == null) {
            return false;
        }

        if(n1.data != n2.data) {
            return false;
        }

        return (isIsomorphic(n1.left , n2.left) && isIsomorphic(n1.right , n2.right)) ||
                (isIsomorphic(n1.left, n2.right) && isIsomorphic(n1.right, n2.left));
    }
}
