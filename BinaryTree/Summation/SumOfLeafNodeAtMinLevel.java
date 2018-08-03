package BinaryTree.Summation;

import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeafNodeAtMinLevel {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.right.left = new Node(8);
        root.right.left.right = new Node(9);

        System.out.println(getSumAtMinLevel(root));
    }

    private static int getSumAtMinLevel(Node root) {
        if(root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        boolean isLeafFound = false;
        int sum = 0;

        while(!queue.isEmpty()) {
            Node element = queue.remove();
            if(element == null) {
                if(isLeafFound) {
                    break;
                } else if(queue.size() > 1) {
                    queue.add(null);
                }
            } else {
                if(element.left == null && element.right == null) {
                    if(!isLeafFound) {
                        isLeafFound = true;
                    }
                    sum+= element.data;
                } else {
                    if(element.left != null) {
                        queue.add(element.left);
                    }

                    if(element.right != null) {
                        queue.add(element.right);
                    }
                }
            }
        }
        return sum;
    }
}
