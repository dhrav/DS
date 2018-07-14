package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class ContinuousBT {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(4);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(5);

       /* Node root = new Node(7);
        root.left = new Node(5);
        root.right = new Node(8);
        root.left.left = new Node(6);
        root.left.right = new Node(4);
        root.right.right = new Node(10);*/
        System.out.println(isContinuous(root));
    }

    private static boolean isContinuous(Node root) {
        if(root == null) {
            return true;
        }

        if(root.left == null && root.right == null) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node element;

        while(!queue.isEmpty()) {
            element = queue.remove();

            if(element.left != null) {
                int diff = Math.abs(element.data - element.left.data);
                if(diff != 1) {
                    return false;
                }
                else {
                    queue.add(element.left);
                }
            }

            if(element.right != null ) {
                int diff = Math.abs(element.data - element.right.data);
                if(diff != 1) {
                    return false;
                }
                else {
                    queue.add(element.right);
                }
            }

        }
        return true;
    }
}
