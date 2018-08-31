package BinarySearchTree;

import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class BSTToMinHeapInPlace {
    static Node head;
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(12);
        root.right.left = new Node(10);
        root.right.right = new Node(14);
        root.left.left = new Node(2);
        root.left.right = new Node(6);

        System.out.println("Before change");
        inorder(root);
        System.out.println();

        convertToMinHeap(root);
    }

    private static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    private static void convertToMinHeap(Node root) {
        BSTToSortedLL(root);

        Node current = head;
        Node element, firstChild = null, secondChild = null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(current);
        current = current.right;
        while(!queue.isEmpty() && current != null) {
            element = queue.remove();
            firstChild = current;
            current = current.right;
            if(current != null) {
                secondChild = current;
                current = current.right;
            }


            element.left = firstChild;
            element.right = secondChild;
            firstChild.left = null;
            firstChild.right = null;
            queue.add(firstChild);

            if(secondChild != null) {
                secondChild.left = null;
                secondChild.right = null;
                queue.add(secondChild);
            }
        }

        inorder(head);
    }


    private static void BSTToSortedLL(Node root) {
        if(root == null) {
            return;
        }

        BSTToSortedLL(root.right);

        //process data - convert to LL
        root.right = head;

        if(head != null) {
            head.left = root;
        }

        head = root;

        BSTToSortedLL(root.left);
    }
}
