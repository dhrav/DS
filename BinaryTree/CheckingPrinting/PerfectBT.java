package BinaryTree.CheckingPrinting;

import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectBT {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        //root.right.right = new Node(70);

        System.out.println(checkPerfectTree(root));
    }

    private static boolean checkPerfectTree(Node root) {
        if(root == null) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int level = 0;
        double nodeCount = 0;

        while(!queue.isEmpty()) {
            Node element = queue.remove();

            if(element == null) {
                double expectedNode = Math.pow(2, level);
                if(expectedNode != nodeCount) {
                    return false;
                }
                if(queue.size() > 1) {
                    queue.add(null);
                }

                nodeCount=0;
                level++;
            } else {
                //sout
                nodeCount++;
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
