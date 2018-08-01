package BinaryTree.CheckingPrinting;

import BinaryTree.Node;

public class FindMiddleInPBT {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n1.left = n2;
        n1.right = n3;

        printMiddleLevel(n1);
    }

    private static void printMiddleLevel(Node root) {
        printMiddleLevelUtil(root, root);
    }

    private static void printMiddleLevelUtil(Node slow, Node fast) {
        //base case
        if(slow == null || fast == null) {
            return;
        }

        //if fast reaches leaf node, then slow is in middle
        if(fast.left == null && fast.right == null) {
            System.out.println(slow.data);
            return;
        }

        printMiddleLevelUtil(slow.left, fast.left.left);
        printMiddleLevelUtil(slow.right, fast.right.right);
    }
}
