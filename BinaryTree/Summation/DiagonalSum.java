package BinaryTree.Summation;

import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class DiagonalSum {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(9);
        root.left.right = new Node(6);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.right.left.right = new Node(7);
        root.right.left.left = new Node(12);
        root.left.right.left = new Node(11);
        root.left.left.right = new Node(10);

        printDiagonalSum(root);
    }

    private static void printDiagonalSum(Node root) {
        if(root == null) {
            return;
        }

        int sum=0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()) {
            Node element = queue.remove();
            if(element == null) {
                if(queue.size() > 1 ) {
                    queue.add(null);
                }
                System.out.println(sum);
                sum =0;
            } else {
                while(element != null) {
                    sum+= element.data;
                    if(element.left != null) {
                        queue.add(element.left);
                    }
                    element = element.right;
                }
            }

        }
    }
}
