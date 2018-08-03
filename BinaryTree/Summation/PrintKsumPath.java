package BinaryTree.Summation;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;

public class PrintKsumPath {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.left.right.left = new Node(1);
        root.right = new Node(-1);
        root.right.left = new Node(4);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(2);
        root.right.right = new Node(5);
        root.right.right.right = new Node(2);
        PrintKsumPath object = new PrintKsumPath();

        object.printKSumPaths(root, 5);
    }

    private void printKSumPaths(Node root, int key) {
        if(root == null) {
            return;
        }

        printKsumUtil(root, new int[100], 0, key);
    }

    private void printKsumUtil(Node root, int[] path, int index, int key) {
        if(root == null) {
            return;
        }

        path[index++] = root.data;
        int currentSum = 0;
        int pathLength = index;
       // List<Integer> nodeList = new ArrayList<>();

        for(int i = index-1; i >=0; i--) {
            currentSum+= path[i];
            //nodeList.add(path[i]);
            pathLength--;
            if(currentSum == key) {
               /* for(int j = nodeList.size()-1; j >=0; j--) {
                    System.out.print(nodeList.get(j) + " ");
                }*/
               for(int j = pathLength; j < index; j++) {
                   System.out.print(path[j] + " ");
               }
                System.out.println();
            }
        }


        printKsumUtil(root.left, path, index, key);
        printKsumUtil(root.right, path, index, key);
    }
}
