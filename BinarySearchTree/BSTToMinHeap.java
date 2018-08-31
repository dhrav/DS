package BinarySearchTree;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;

public class BSTToMinHeap {
    static List<Integer> nodeElements = new ArrayList<>();
    static int index;
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        System.out.println("Before change");
        inorder(root);
        System.out.println();
        convertToMinHeap(root);
        System.out.println("After change");
        preorder(root);
    }

    private static void preorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    private static void convertToMinHeap(Node root) {
        if(root == null) {
            return;
        }

        root.data = nodeElements.get(index++);
        convertToMinHeap(root.left);
        convertToMinHeap(root.right);
    }

    private static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        nodeElements.add(root.data);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}
