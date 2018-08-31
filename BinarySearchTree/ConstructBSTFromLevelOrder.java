package BinarySearchTree;


import java.util.LinkedList;
import java.util.Queue;

public class ConstructBSTFromLevelOrder {
    static class Node {
        int data;
        int min;
        int max;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }
    public static void main(String[] args) {
        int arr[] = {7, 4, 12, 3, 6, 8, 1, 5, 10};
        Node root = constructBST(arr);
        inorder(root);
    }

    private static Node constructBST(int[] arr) {
        int index = 0;
        Node root = new Node(arr[index++]);
        root.min = Integer.MIN_VALUE;
        root.max = Integer.MAX_VALUE;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node newNode = null;

        int size = arr.length;
        while(index < size) {
            Node element = queue.remove();

            if(index < size && arr[index] < element.data && arr[index] > element.min) {
                newNode = new Node(arr[index++]);
                newNode.min = element.min;
                newNode.max = element.data;
                element.left = newNode;

                queue.add(newNode);
            }

            if(index < size && arr[index] > element.data && arr[index] < element.max) {
                newNode = new Node(arr[index++]);
                newNode.min = element.data;
                newNode.max = element.max;
                element.right = newNode;

                queue.add(newNode);
            }

        }

        return root;
    }

    private static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

}
