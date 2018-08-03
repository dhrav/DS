package BinaryTree.Summation;

import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class DiffEvenOddLevelSum {
    class Result {
        int oddSum;
        int evenSum;
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left  = new Node(1);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.right.right = new Node(8);
        root.right.right.right = new Node(9);
        root.right.right.left = new Node(7);

        DiffEvenOddLevelSum object = new DiffEvenOddLevelSum();

        System.out.println(object.findDiff(root));
        System.out.println(object.findDiffIterative(root));
    }

    private int findDiffIterative(Node root) {
        Result result = new Result();
        if(root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int level = 1;

        while(!queue.isEmpty()) {
            Node element = queue.remove();
            if(element == null) {
                if(queue.size() > 0) {
                    queue.add(null);
                }
                level++;
            } else {
                if(level % 2 == 0) {
                    result.evenSum += element.data;
                } else {
                    result.oddSum += element.data;
                }

                if(element.left != null) {
                    queue.add(element.left);
                }

                if(element.right != null) {
                    queue.add(element.right);
                }
            }
        }

        return result.oddSum - result.evenSum;

    }

    private int findDiff(Node root) {
        if(root == null) {
            return 0;
        }

        Result result = new Result();
        findDiffUtil(root, result, 1);

        return result.oddSum - result.evenSum;
    }

    private void findDiffUtil(Node root, Result result, int level) {
        if(root == null) {
            return;
        }

        if(level % 2 == 0) {
            result.evenSum += root.data;
        } else {
            result.oddSum += root.data;
        }

        findDiffUtil(root.left, result, level+1);
        findDiffUtil(root.right, result, level+1);
    }
}
