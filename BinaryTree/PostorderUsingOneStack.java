package BinaryTree;

import java.util.Stack;

public class PostorderUsingOneStack {
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

        Stack<Node> stack = new Stack<>();
        Node current = temp;


        do {

            while(current != null) {
                if(current.right != null) {
                    stack.push(current.right);
                }
                stack.push(current);
                current = current.left;
            }

          if(current == null) {
                   current = stack.pop();
                    if(!stack.isEmpty() && current.right == stack.peek()) {
                        Node rightNode = stack.pop();
                        stack.push(current);
                        current = rightNode;
                    }
                    else {
                        System.out.println(current.data);
                        current = null;
                    }

            }
        }while(!stack.isEmpty());
    }
}
