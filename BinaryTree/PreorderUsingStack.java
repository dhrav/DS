package BinaryTree;

import java.util.Stack;

public class PreorderUsingStack {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.right = new Node(9);
        root.left.left = new Node(7);
        root.right.left = new Node(15);
        root.right.right = new Node(8);
        Node temp = root;
        preorder(temp);
    }

    private static void preorder(Node temp) {
        if(temp == null) {
            return;
        }

        Stack<Node> stack  = new Stack<>();
        stack.push(temp);

        while(!stack.isEmpty()) {
            Node element = stack.pop();
            System.out.println(element.data);

            if(element.right != null) {
                stack.push(element.right);
            }

            if(element.left != null) {
                stack.push(element.left);
            }
        }

    }
}
