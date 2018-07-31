package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBTSpecificLOT {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        /*root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);*/
       /* root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);*/
        Node temp = root;
        levelOrder(temp);
    }

    private static void levelOrder(Node temp) {
        if(temp == null) {
            return;
        }
        System.out.print(temp.data + " ");

        if(temp.left == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(temp.left);
        queue.add(temp.right);

        while(!queue.isEmpty()) {
            Node first = queue.remove();
            Node second = queue.remove();

            System.out.print((first != null ? first.data : null) + " " + (second != null ? second.data: null) + " ");
            if(first.left != null) {
                queue.add(first.left);
                queue.add(second != null ? second.right : null);
                queue.add(first.right);
                queue.add(second != null ? second.left : null);
            }
        }
    }
}
