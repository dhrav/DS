package BinaryTree.CheckingPrinting;

import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class IterativeIdenticalTree {
    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(15);

        System.out.println(isIdentical(root1, root2));
    }

    private static boolean isIdentical(Node root1, Node root2) {
        if(root1 == null && root2 == null) {
            return true;
        }

        if(root1 == null || root2 == null) {
            return false;
        }

        Queue<Node> queue1 = new LinkedList<>();
        queue1.add(root1);

        Queue<Node> queue2 = new LinkedList<>();
        queue2.add(root2);

        while(!queue1.isEmpty() && !queue2.isEmpty()) {
            Node element1 = queue1.remove();
            Node element2 = queue2.remove();

            if(element1.data != element2.data) {
                return false;
            }

            if(element1.left != null && element2.left != null) {
                queue1.add(element1.left);
                queue2.add(element2.left);
            } else if(!(element1.left == null && element2.left == null)) {
                return false;
            }

            if(element1.right != null && element2.right != null) {
                queue1.add(element1.right);
                queue2.add(element2.right);
            } else if(!(element1.right == null && element2.right == null) ) {
                return false;
            }
        }
        return true;
    }
}
