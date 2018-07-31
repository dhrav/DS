package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderSpiral {
    public static void main(String[] args) {
       /* Node root = new Node(10);
        root.left = new Node(11);
        root.right = new Node(9);
        root.left.left = new Node(7);
        root.right.left = new Node(15);
        root.right.right = new Node(8);*/

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        Node temp = root;
        levelOrder(temp);
    }

    private static void levelOrder(Node root) {
        if(root == null) {
            return;
        }

        Stack<Node> curstack = new Stack<>();
        Stack<Node> nextstack = new Stack<>();
        curstack.push(root);

        boolean isOdd = true;
        while(!curstack.isEmpty() || !nextstack.isEmpty()) {

            while(!curstack.isEmpty()) {
                Node element = curstack.pop();
                System.out.println(element.data);

                if(isOdd) {

                    if(element.right != null) {
                        nextstack.push(element.right);
                    }

                    if(element.left != null) {
                        nextstack.push(element.left);
                    }

                } else {
                    if(element.left != null) {
                        nextstack.push(element.left);
                    }
                    if(element.right != null) {
                        nextstack.push(element.right);
                    }

                }

            }

            isOdd = !isOdd;
            Stack<Node> temp = nextstack;
            nextstack = curstack;
            curstack = temp;
        }


    }
}
