package BinarySearchTree;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;

public class CheckIfArrRepresentBST {
    static List<Integer> inorderList = new ArrayList<>();
    public static void main(String[] args) {
        //int arr[] = { 512, 330, 78, 11, 8 };
        int arr[] = { 500, 200, 90, 250, 100 };
        Node root = constructBSTLevelWise(arr);
        System.out.println(checkIfBST(root));

    }

    private static boolean checkIfBST(Node root) {
        if(root == null) {
            return true;
        }

        inorder(root);
        boolean result = true;
        for(int i= 1; i < inorderList.size(); i++) {
            if(inorderList.get(i-1) > inorderList.get(i)) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static void inorder(Node root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        inorderList.add(root.data);
        inorder(root.right);
    }

    private static Node constructBSTLevelWise(int[] arr) {
        Node current = null;
        Node root = null;
        for(int i : arr) {
            if(current == null) {
                current = new Node(i);
                root = current;
            } else if(current.data > i) {
                current.left = new Node(i);
                current = current.left;
            } else if(current.data < i) {
                current.right = new Node(i);
                current = current.right;
            }
        }
        return root;
    }
}
