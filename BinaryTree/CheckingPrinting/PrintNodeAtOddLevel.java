package BinaryTree.CheckingPrinting;

import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class PrintNodeAtOddLevel {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        printOddNodes(root);
    }

    private static void printOddNodes(Node root) {
        if(root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int level = 0;

        while(!queue.isEmpty()) {
            Node element = queue.remove();
            if(element == null) {
                if(queue.size() > 1) {
                    queue.add(null);
                }
                level++;
            } else {
                if(level % 2 == 0) {
                    System.out.println(element.data);
                }

                if(element.left != null) {
                    queue.add(element.left);
                }

                if(element.right != null) {
                    queue.add(element.right);
                }
            }

        }
    }

}
