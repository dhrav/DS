package BinaryTree.CheckingPrinting;

import BinaryTree.Node;

public class PrintRootToLeafPath {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left        = new Node(2);
        root.right       = new Node(3);
        root.left.left  = new Node(4);
        root.left.right = new Node(5);

        printRootToLeafPath(root);
    }

    private static void printRootToLeafPath(Node root) {
        if(root == null) {
            return;
        }

        printPathUtil(root, new int[100], 0);
    }

    private static void printPathUtil(Node root, int[] path, int index) {
        if(root == null) {
            return;
        }

        path[index++] = root.data;
        if(root.left == null && root.right == null) {
            for(int i = 0; i < index; i++) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
            return;
        }
        printPathUtil(root.left, path, index);
        printPathUtil(root.right, path, index);
    }
}
