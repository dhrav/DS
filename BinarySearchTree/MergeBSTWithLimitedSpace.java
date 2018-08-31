package BinarySearchTree;

import BinaryTree.Node;

import java.util.Stack;

public class MergeBSTWithLimitedSpace {
    public static void main(String[] args) {
        Node root1 = new Node(3);
        root1.left = new Node(1);
        root1.right = new Node(5);

        Node root2 = new Node(4 );
        root2.left = new Node(2);
        root2.right = new Node(6);

        mergeBST(root1, root2);
    }

    private static void mergeBST(Node root1, Node root2) {
        if(root1 == null){
            inorder(root2);
        } else if(root2 == null) {
            inorder(root1);
        } else {
            mergeBSTUtil(root1, root2);
        }
    }

    private static void mergeBSTUtil(Node root1, Node root2) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        Node current1 = root1;
        Node current2 = root2;

        while(current1 != null || current2 != null || !stack1.isEmpty() || !stack2.isEmpty()) {
            if(current1 != null || current2 != null) {
                if(current1 != null) {
                    stack1.push(current1);
                    current1 = current1.left;
                }

                if(current2 != null) {
                    stack2.push(current2);
                    current2 = current2.left;
                }
            } else {
                if(stack1.isEmpty()) {
                    while(!stack2.isEmpty()) {
                        current2 = stack2.pop();
                        System.out.print(current2.data + " ");
                        current2.left = null;
                        inorder(current2.right);
                    }
                    return;
                } else if(stack2.isEmpty()) {
                    while(!stack1.isEmpty()) {
                        current1 = stack1.pop();
                        System.out.println(current1.data);
                        current1.left = null;
                        inorder(current1.right);
                    }
                    return;
                } else {
                    current1 = stack1.pop();
                    current2 = stack2.pop();

                    if(current1.data < current2.data) {
                        System.out.print(current1.data + " ");
                        current1 = current1.right;
                        stack2.push(current2);
                        current2 = null;
                    } else {
                        System.out.print(current2.data + " ");
                        current2 = current2.right;
                        stack1.push(current1);
                        current1 = null;
                    }

                }
            }
        }
    }

    private static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}
