package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderSpiralTwoLevel {
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
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(1);
        root.right.left.left = new Node(4);
        root.right.left.right = new Node(2);
        root.right.right.left = new Node(7);
        root.right.right.right = new Node(2);
        root.left.right.left.left = new Node(16);
        root.left.right.left.right = new Node(17);
        root.right.left.right.left = new Node(18);
        root.right.right.left.right = new Node(19);

        Node temp = root;
        levelOrder(temp);
    }

    private static void levelOrder(Node root) {
        if(root == null) {
            return;
        }
        int count = 2;

        Stack<Integer> stack = new Stack<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);


        boolean isReverse = false;
        while(!queue.isEmpty()) {
            Node element = queue.remove();

            if(element == null) {
                count--;
                if(queue.size() >= 1) {
                    queue.add(null);
                }
                    if(isReverse) {
                        while (!stack.isEmpty()) {
                            System.out.print(stack.pop() + " ");
                        }
                    }


                    if(count ==0) {
                        isReverse = !isReverse;
                        count=2;
                    }
                    System.out.println();

                    continue;
                }
            else {
                if(element.left != null) {
                    queue.add(element.left);
                }

                if(element.right != null) {
                    queue.add(element.right);
                }

                if(!isReverse) {
                    System.out.print(element.data + " ");
                }
                else {
                    stack.push(element.data);
                }
            }

        }

    }
}
