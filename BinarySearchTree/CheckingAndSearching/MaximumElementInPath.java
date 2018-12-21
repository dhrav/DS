package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

public class MaximumElementInPath {
    static int maxElement;
    public static void main(String[] args) {
        int arr[] = { 18, 36, 9, 6, 12, 10, 1, 8 };
        int a = 1, b= 10;

        findMaxElement(arr, a, b);
    }

    private static void findMaxElement(int[] arr, int a, int b) {
        Node root = constructTree(arr);
        System.out.println("Constructed tree is :");
        inorder(root);
        Node lca = findLca(root, a, b);
        System.out.println();
        System.out.println("LCA is " + lca.data);

        int maxNum = Math.max(a, b);
        System.out.println("Max Element is: ");
        System.out.print(findMax(lca, maxNum));
    }

    private static void inorder(Node root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    private static int findMax(Node root, int key) {
        if(root == null) {
            return 0;
        }

        if(root.data < key) {
            maxElement = Math.max(maxElement, root.data);
            return findMax(root.right, key);
        } else if(root.data > key) {
            maxElement = Math.max(maxElement, root.data);
            return findMax(root.left, key);
        }

        return Math.max(maxElement, root.data);
    }

    private static Node findLca(Node root, int a, int b) {
        if(root == null) {
            return null;
        }

        if(root.data == a || root.data == b) {
            return root;
        }

        if(root.data < a && root.data < b) {
            return findLca(root.right, a, b);
        } else if(root.data > a && root.data > b) {
            return findLca(root.left, a, b);
        }
        return root;
    }

    private static Node constructTree(int[] arr) {
        Node root = null;
        int size = arr.length;
        for(int i = 0; i < size; i++) {
            root = insert(arr[i], root);
        }
        return root;
    }

    private static Node insert(int i, Node root) {
        if(root == null) {
            return new Node(i);
        }

        if(root.data < i) {
            root.right =  insert(i, root.right);
        } else if(root.data > i) {
            root.left = insert(i, root.left);
        }

        return root;
    }
}
