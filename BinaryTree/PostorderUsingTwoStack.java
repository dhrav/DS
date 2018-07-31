package BinaryTree;

import java.util.Stack;

public class PostorderUsingTwoStack {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.right = new Node(9);
        root.left.left = new Node(7);
        root.right.left = new Node(15);
        root.right.right = new Node(8);
        Node temp = root;
        postorder(temp);
    }

    private static void postorder(Node temp) {
        if(temp == null) {
            return;
        }

        Stack<Node> first = new Stack<>();
        Stack<Node> second = new Stack<>();

        first.push(temp);
        while(!first.isEmpty()) {
            Node element = first.pop();
            second.push(element);

            if(element.left != null) {
                first.push(element.left);
            }

            if(element.right != null) {
                first.push(element.right);
            }
        }

        while(!second.isEmpty()) {
            System.out.println(second.pop().data);
        }
    }
}
