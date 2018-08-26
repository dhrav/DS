package BinarySearchTree;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinaryTreeToBST {
    static List<Integer> nodeList = new ArrayList<>();
    static int index = 0;
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(30);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.right.right = new Node(5);
        System.out.println("Before change");
        inorder(root);
        nodeList.sort(Comparator.comparingInt(o -> o));
        convertToBST(root);
        System.out.println();
        System.out.println("After change");
        inorder(root);
    }

    private static void convertToBST(Node root) {
        if(root == null) {
            return;
        }

        convertToBST(root.left);
        root.data = nodeList.get(index++);
        convertToBST(root.right);
    }

    private static void inorder(Node root) {
        if(root== null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        nodeList.add(root.data);
        inorder(root.right);
    }
}
