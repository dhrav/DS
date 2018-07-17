package BinaryTree;

import java.util.Stack;

public class InorderWithStack {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.right = new Node(9);
        root.left.left = new Node(7);
        root.right.left = new Node(15);
        root.right.right = new Node(8);
        Node temp = root;
        inorder(temp);
    }

    private static void inorder(Node root) {

        if(root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node current = root;

        while(current != null || !stack.isEmpty()) {

            while(current != null) {
                stack.push(current);
                current= current.left;
            }

            Node element = stack.pop();
            System.out.println(element.data);
            current = element.right;

        }
    }
}
