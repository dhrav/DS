package BinaryTree.Construction;

import java.util.ArrayList;

public class TreeToAncestorMatrix {
    static boolean[][] matrix;

    public static void main(String[] args) {
        int size = 6;
        Node root        = new Node(5);
        root.left        = new Node(1);
        root.right       = new Node(2);
        root.left.left  = new Node(0);
        root.left.right = new Node(4);
        root.right.left = new Node(3);
        matrix = new boolean[6][6];

        createAncestorMatrix(root, new ArrayList<Integer>());
        printMatrix(size);
    }

    private static void createAncestorMatrix(Node root, ArrayList<Integer> ancestor) {
        if(root == null) {
            return;
        }

        int data = root.data;
        for(Integer i : ancestor) {
            matrix[i][data] = true;
        }

        ancestor.add(data);

        createAncestorMatrix(root.left, ancestor);
        createAncestorMatrix(root.right, ancestor);
        ancestor.remove((Integer) data);
    }

    private static void printMatrix(int size) {

        for(int i =0; i < size; i++) {
            for(int j= 0; j< size; j++){
                System.out.print((matrix[i][j] ? 1: 0) + " ");
            }
            System.out.println();
        }
    }


}
