package BinaryTree.Misc;

import BinaryTree.Node;

public class LargestThreeElements {
    static int first, second, third;
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        findTopThree(root);
        System.out.println("The top three elements are " + first + ", " + second + ", " + third);
    }

    private static void findTopThree(Node root) {
        if(root == null) {
            return;
        }

        if(root.data > first) {
                third = second;
                second = first;
                first = root.data;
        } else if(root.data > second && root.data != first) {
                third = second;
                second = root.data;
        } else if(root.data > third && root.data != second && root.data != first) {
            third = root.data;
        }

        findTopThree(root.left);
        findTopThree(root.right);
    }
}
