package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BTSpecificLOT {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.right = new Node(9);
        root.left.left = new Node(7);
        root.right.left = new Node(15);
        root.right.right = new Node(8);
        Node temp = root;
        levelOrder(temp);
    }

    private static void levelOrder(Node temp) {
        if(temp == null) {
            return;
        }
        System.out.print(temp.data + " ");

        if(temp.left == null && temp.right == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(temp.left);
        queue.add(temp.right);

        while(!queue.isEmpty()) {
            Node first = queue.remove();
            Node second = queue.remove();

            System.out.print((first != null ? first.data : null) + " " + (second != null ? second.data: null) + " ");
            if(first != null || second != null) {
                if(!isLeafNode(first) && !isLeafNode(second)) {
                    queue.add(first != null ? first.left : null);
                    queue.add(second != null ? second.right : null);
                    queue.add(first != null ? first.right : null);
                    queue.add(second != null ? second.left : null);
                }
            }
        }
    }

    public static boolean isLeafNode(Node root) {
        return root != null && root.left == null && root.right == null;
    }
}
