package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PerfectBTSpecificLOTBottomUp {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);
        Node temp = root;
        levelOrder(temp);
    }

    private static void levelOrder(Node temp) {
        if(temp == null) {
            return;
        }

        Stack<Integer> stack = new Stack<>();
        //System.out.print(temp.data + " ");
        stack.push(temp.data);

        if(temp.left == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(temp.left);
        queue.add(temp.right);

        stack.push(temp.right.data);
        stack.push(temp.left.data);

        while(!queue.isEmpty()) {
            Node first = queue.remove();
            Node second = queue.remove();

            //System.out.print(first.data + " " + second.data + " ");
            if(first.left != null) {
                queue.add(first.right);
                queue.add(second.left);
                queue.add(first.left);
                queue.add(second.right);

                stack.push(second.left.data);
                stack.push(first.right.data);
                stack.push(second.right.data);
                stack.push(first.left.data);
            }
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
