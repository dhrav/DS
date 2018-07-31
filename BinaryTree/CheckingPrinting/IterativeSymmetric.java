package BinaryTree.CheckingPrinting;

import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class IterativeSymmetric {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        //root.right = new Node(12);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        System.out.println(isSymmetric(root));
    }

    private static boolean isSymmetric(Node root) {
        if(root == null) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()) {
            Node first = queue.remove();
            Node second = queue.remove();

            if((first == null && second != null) || (first != null && second == null)) {
                return false;
            }

            if(first != null && second != null) {
                if(first.data != second.data) {
                    return false;
                }

                queue.add(first.left);
                queue.add(second.right);
                queue.add(first.right);
                queue.add(second.left);
            }
        }
        return true;
    }
}
