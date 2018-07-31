package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class DiagonalTraversalBT {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.right = new Node(9);
        root.left.left = new Node(7);
        root.right.left = new Node(15);
        root.right.right = new Node(8);
        Node temp = root;
        diagonalTraversal(temp);
    }

    private static void diagonalTraversal(Node temp) {
        if(temp == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);
        queue.add(null);
        while(!queue.isEmpty()) {
            Node element = queue.remove();

            if(element == null) {
                if(queue.size() > 1) {
                    queue.add(null);
                }
                System.out.println();
            } else {
                while(element != null) {
                    System.out.print(element.data +  " ");
                    if(element.left != null) {
                        queue.add(element.left);
                    }
                    element = element.right;
                }
            }
        }
    }
}
