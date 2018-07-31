package BinaryTree;

import java.util.Stack;

public class ModifyBTForRightPreorder {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.right = new Node(9);
        root.left.left = new Node(7);
        root.right.left = new Node(15);
        root.right.right = new Node(8);
        Node temp = root;
        modifyTree(temp);

        preorderWithRight(temp);
    }

    private static void preorderWithRight(Node root) {
        while(root != null) {
            System.out.println(root.data);
            root = root.right;
        }
    }

    private static void modifyTree(Node root) {
        if(root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node prev = null;

        while(!stack.isEmpty()) {
            Node element = stack.pop();

            if(element.right != null) {
                stack.push(element.right);
            }

            if(element.left != null) {
                stack.push(element.left);
            }

            if(prev != null) {
                prev.right = element;
            }

            prev = element;
        }
    }
}
