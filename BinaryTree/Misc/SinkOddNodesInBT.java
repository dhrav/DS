package BinaryTree.Misc;

import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class SinkOddNodesInBT {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(5);
        root.right    = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(9);
        root.right.right = new Node(10);

        root = sinkAllOddNodes(root);
        //inorder(root);
        levelOrder(root);
    }

    private static void levelOrder(Node root) {
        if(root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()) {
            Node element = queue.remove();

            if(element == null) {
                System.out.println();
                if(queue.size() > 1) {
                    queue.add(null);
                }
            } else {
                System.out.print(element.data + " ");
                if(element.left != null) {
                    queue.add(element.left);
                }

                if(element.right != null) {
                    queue.add(element.right);
                }
            }
        }
    }

    private static void inorder(Node root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    private static boolean isOdd(int data) {
        return ! (data % 2 == 0);
    }

    private static Node sinkAllOddNodes(Node root) {
        if(root == null) {
            return null;
        }

        if(root.left == null && root.right == null) {
            return root;
        }

        Node leftRoot = sinkAllOddNodes(root.left);
        Node rightRoot = sinkAllOddNodes(root.right);

        //if current node's data is odd, check its children
        if(isOdd(root.data)) {
            if(!isOdd(leftRoot.data)) {
              int temp = root.data;
              root.data = leftRoot.data;
              leftRoot.data = temp;

              root.left = sinkAllOddNodes(root.left);
            } else if(!isOdd(rightRoot.data)) {
                int temp = root.data;
                root.data = rightRoot.data;
                rightRoot.data = temp;

                root.right = sinkAllOddNodes(root.right);
            }
        }

        return root;
    }
}
