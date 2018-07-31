package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderLineByLine {
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
        Node levelMarker = new Node(-1);

        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);
        queue.add(levelMarker);

        while(!queue.isEmpty()) {
            Node element = queue.remove();

            if(element.data == -1) {
                if(queue.size() >= 1) {
                    queue.add(levelMarker);
                    System.out.println();
                }
            } else {
                System.out.print(element.data + " ");
                if (element.left != null) {
                    queue.add(element.left);
                }

                if (element.right != null) {
                    queue.add(element.right);
                }
            }
        }
    }
}
