package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

public class ReplaceWithLeastGreaterElement {
    static Node successor;
    public static void main(String[] args) {
        int arr[] = { 8, 58, 71, 18, 31, 32, 63, 92,
                43, 3, 91, 93, 25, 80, 28 };

        int[] result = replaceWithLeastGreaterElement(arr);
        printArray(result);
    }

    private static void printArray(int[] result) {
        int resultSize = result.length;
        for(int i = 0; i< resultSize; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private static int[] replaceWithLeastGreaterElement(int[] arr) {
        Node root = null;
        Node succ = null;
        int size = arr.length;
        int[] result = new int[size];
        for(int i = size-1; i >= 0; i--) {
            root = insert(root, succ, arr[i]);
            if(successor != null) {
                System.out.println("Successor of " + arr[i] + " is " + successor.data);
                result[i] = successor.data;
                successor = null;
            } else {
                result[i] = -1;
            }
        }
        inorder(root);
        return result;
    }

    private static void inorder(Node root) {
        if(root== null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    private static Node insert(Node root, Node succ, int i) {
        if(root == null) {
            return new Node(i);
        }

        if(root.data < i) {
            root.right = insert(root.right, succ, i);
        } else {
            successor = root;
            root.left = insert(root.left, succ, i);
        }
        return root;
    }
}
