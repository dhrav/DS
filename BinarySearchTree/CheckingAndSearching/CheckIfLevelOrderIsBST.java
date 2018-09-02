package BinarySearchTree.CheckingAndSearching;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfLevelOrderIsBST {
    static class Node {
        int data;
        int min;
        int max;
        Node left, right;
        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    
    public static void main(String[] args) {
        //int arr[] = {7, 4, 12, 3, 6, 8, 1, 5, 10};
        int arr[] = {11, 6, 13, 5, 12, 10};
        System.out.println(checkIfBST(arr) ? "true" : "false");
    }

    private static boolean checkIfBST(int[] arr) {
        int size = arr.length;
        Queue<Node> queue = new LinkedList<>();
        int i = 0;
        Node root = new Node(arr[i++]);
        root.min = Integer.MIN_VALUE;
        root.max = Integer.MAX_VALUE;
        queue.add(root);
        Node nodeElement;

        while(i < size && !queue.isEmpty()) {
            Node temp = queue.remove();

            if(arr[i] < temp.data && arr[i] > temp.min) {
                nodeElement = new Node(arr[i++]);
                nodeElement.min = temp.min;
                nodeElement.max = temp.data;

                queue.add(nodeElement);
            }

            if(i < size && arr[i] > temp.data && arr[i] < temp.max) {
                nodeElement = new Node(arr[i++]);
                nodeElement.min = temp.data;
                nodeElement.max = temp.max;
                queue.add(nodeElement);
            }
        }

        return (i == size);

    }

}
