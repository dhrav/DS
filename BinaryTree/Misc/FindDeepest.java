package BinaryTree.Misc;

import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class FindDeepest {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.right = new Node(7);
        root.right.right.right = new Node(8);
        root.right.left.right.left = new Node(9);

        System.out.println(findDeepest(root));
    }

    private static int findDeepest(Node root) {
        if(root == null) {
            return -1;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node element = null;

        while(!queue.isEmpty()) {
            element = queue.remove();
            if(element.left != null) {
                queue.add(element.left);
            }

            if(element.right != null) {
                queue.add(element.right);
            }
        }

        return element == null ? -1 : element.data;
    }
}
