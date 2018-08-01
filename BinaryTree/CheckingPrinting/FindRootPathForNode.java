package BinaryTree.CheckingPrinting;

import BinaryTree.Node;

public class FindRootPathForNode {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int key = 6;

        printPathForNode(root, key, new int[100], 0);
    }

    private static void printPathForNode(Node root, int key, int[] path, int index) {
        if(root == null) {
            return;
        }

        path[index++] = root.data;
        if(root.data == key) {
            for(int i = 0; i< index; i++) {
                System.out.print(path[i] + " ");
            }
        } else {
            printPathForNode(root.left, key, path, index);
            printPathForNode(root.right, key, path, index);
        }
    }
}
