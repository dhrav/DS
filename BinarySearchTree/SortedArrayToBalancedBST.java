package BinarySearchTree;

import BinaryTree.Node;

public class SortedArrayToBalancedBST {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        Node root = constructBST(arr, 0, arr.length-1);
        System.out.println("The constructed Tree is :");
        inorder(root);
    }

    private static Node constructBST(int[] arr, int low, int high) {
        if(low > high || low <0 || high > arr.length) {
            return null;
        } else if(low == high) {
            return new Node(arr[low]);
        }

        int middle = (high + low)/2;
        Node root = new Node(arr[middle]);
        root.left = constructBST(arr, low, middle-1);
        root.right = constructBST(arr, middle+1, high);
        return root;
    }

    private static void inorder(Node root) {
        if(root== null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}
