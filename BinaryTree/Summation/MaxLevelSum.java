package BinaryTree.Summation;

import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left        = new Node(2);
        root.right       = new Node(3);
        root.left.left  = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(8);
        root.right.right.left  = new Node(6);
        root.right.right.right  = new Node(7);

        System.out.println(findMaxLevelSum(root));
    }

    private static int findMaxLevelSum(Node root) {
        if(root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        int currentLevelSum = 0;
        int maxLevelSum = Integer.MIN_VALUE;
        while(!queue.isEmpty()) {
            Node element = queue.remove();
            if(element == null) {
                if(queue.size() > 1) {
                    queue.add(null);
                }

                if(currentLevelSum > maxLevelSum) {
                    maxLevelSum = currentLevelSum;
                }
                currentLevelSum = 0;
            } else {
                currentLevelSum += element.data;

                if(element.left != null) {
                    queue.add(element.left);
                }

                if(element.right != null) {
                    queue.add(element.right);
                }
            }
        }
        return maxLevelSum;

    }
}
