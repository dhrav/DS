package BinaryTree.Misc;

import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfBTIsLevelWiseSorted {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(4);
        root.left.right = new Node(6);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);
        root.left.right.left.left = new Node(12);
        root.left.right.right.right = new Node(10);

        System.out.println(isSortedLevelWise(root));
    }

    private static boolean isSortedLevelWise(Node root) {
        if(root == null) {
            return false;
        }

        int prevMax = Integer.MIN_VALUE;
        int curMax = 0;
        int curMin = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()) {
            Node element = queue.remove();
            if(element == null) {
                if(queue.size() > 0) {
                    queue.add(null);
                }
                if(curMin < prevMax) {
                    return false;
                }

                prevMax = curMax;
                curMin = Integer.MAX_VALUE;

            } else {
                if(curMax < element.data) {
                    curMax = element.data;
                } else if(curMin > element.data) {
                    curMin = element.data;
                }


                if(element.left != null) {
                    queue.add(element.left);
                }

                if(element.right != null) {
                    queue.add(element.right);
                }
            }
        }
        return true;
    }
}
