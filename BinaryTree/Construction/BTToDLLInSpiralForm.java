package BinaryTree.Construction;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class BTToDLLInSpiralForm {
    static Node head = null;
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
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);

        convertToDLLSpiral(root);
        printList();

    }

    private static void printList() {
        Node current = head;
        while(current != null) {
            System.out.println(current.data);
            current = current.right;
        }
    }

    private static void convertToDLLSpiral(Node root) {
        if(root == null) {
            return;
        }
        Stack<Node> stack = new Stack();
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        int nodecount = 1;
        boolean isReverse = false;
        while(!queue.isEmpty()) {

            Node element;
            if(isReverse) {
                while(nodecount > 0) {
                    element = queue.removeFirst();

                    if (element.left != null) {
                        queue.addLast(element.left);
                    }
                    if (element.right != null) {
                        queue.addLast(element.right);
                    }
                    nodecount--;
                    stack.push(element);
                }
            } else {
                while(nodecount > 0) {
                    element = queue.removeLast();


                    if (element.right != null) {
                        queue.addFirst(element.right);
                    }

                    if (element.left != null) {
                        queue.addFirst(element.left);
                    }

                    nodecount--;
                    stack.push(element);
                }
            }
                    isReverse = !isReverse;
                    nodecount = queue.size();
            }

        while(!stack.isEmpty()) {
            addToList(stack.pop());
        }
    }

    private static void addToList(Node element) {
        if(head == null) {
            head = element;
            element.right = null;
            element.left = null;
        } else {
            element.right = head;
            head.left = element;
            head = element;
        }
    }
}
