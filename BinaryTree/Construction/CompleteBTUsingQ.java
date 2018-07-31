package BinaryTree.Construction;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBTUsingQ {
    static Queue<Node> queue = new LinkedList<>();
    static Node root = null;

    public static void main(String[] args) {

        for(int i=1; i <=12; i++ ) {
           insert(i);
        }

        levelOrder(root);
    }

    private static void levelOrder(Node root) {

        if(root== null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node element = queue.remove();
            System.out.println(element.data);
            if(element.left != null) {
                queue.add(element.left);
            }

            if(element.right != null) {
                queue.add(element.right);
            }
        }
    }

    private static void insert(int i) {
        Node newNode = new Node(i);
        if(root == null) {
            root = newNode;
        }

        if(!queue.isEmpty()) {
            Node element = queue.peek();

            if(element.left!= null && element.right != null) {
                queue.remove();
                element = queue.peek();
            }
            if(element.left == null) {
                element.left = newNode;
            } else if (element.right == null) {
                element.right = newNode;
            }

        }
        queue.add(newNode);
    }
}
