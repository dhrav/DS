package BinarySearchTree;

import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class ReversePathInBST {
    static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right = new Node(70);
        root.right.right = new Node(80);
        root.right.left = new Node(60);

        System.out.println("Before change");
        inorder(root);

        reversePath(root, 80);

        System.out.println();
        System.out.println("After change");
        inorder(root);
    }

    private static void reversePath(Node root, int key) {
        if(root == null) {
            return;
        }

        if(root.data == key) {
            if(!queue.isEmpty()) {
                Node element = queue.remove();
                root.data = element.data;
                element.data = key;
            }
        } else if(root.data < key) {
            queue.add(root);
            reversePath(root.right, key);
            if(!queue.isEmpty()) {
                Node element = queue.remove();
                root.data = element.data;
            }
        } else {
            queue.add(root);
            reversePath(root.left, key);
            if(!queue.isEmpty()) {
                Node element = queue.remove();
                root.data = element.data;
            }
        }
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
