package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertionBT
{
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.right = new Node(9);
        root.left.left = new Node(7);
        root.right.left = new Node(15);
        root.right.right = new Node(8);
        Node temp = root;
        inorder(temp);

        temp = root;
        insertToTree(temp, 12);
        System.out.println("Final output");

        inorder(root);
    }

    private static Node insertToTree(Node root, int newVal) {
        Node newNode = new Node(newVal);
        Node temp = root;

        if(root == null) {
            return newNode;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);
        Node element;

        while(!queue.isEmpty()) {
            element = queue.remove();
            if(element.left == null) {
                element.left = newNode;
                return root;
            }
            else
            {
                queue.add(element.left);
            }

            if(element.right == null) {
                element.right = newNode;
                return root;
            }
            else
            {
                queue.add(element.right);
            }
        }
        return root;
    }

    private static void inorder(Node root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
}
