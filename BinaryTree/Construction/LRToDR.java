package BinaryTree.Construction;

import java.util.LinkedList;
import java.util.Queue;

public class LRToDR {
    static Node convertedRoot = null;
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.right.left.left = new Node(6);
        root.right.right.left = new Node(7);
        root.right.right.right = new Node(8);

        Node t = convertTree(root);
        traverseTree(t);
    }

    private static Node convertTree(Node root) {
        if(root == null) {
            return null;
        }
        convertTree(root.left);
        convertTree(root.right);

        if(root.left != null) {
            root.left.right = root.right;
        } else {
            root.left = root.right;
        }
        root.right = null;
        return root;

    }

    private static void traverseTree(Node root) {
        if(root == null) {
            return;
        }

        System.out.println(root.data);
        if(root.right != null){
            traverseTree(root.right);
        }

        if(root.left != null) {
            traverseTree(root.left);
        }

    }


}
