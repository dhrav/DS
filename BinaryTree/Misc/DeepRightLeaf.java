package BinaryTree.Misc;

import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class DeepRightLeaf {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.right = new Node(7);
        root.right.right.right = new Node(8);
        root.right.left.right.left = new Node(9);
        root.right.right.right.right = new Node(10);

        System.out.println(findDeepRightLeaf(root));
    }

    private static int findDeepRightLeaf(Node root) {
        if(root == null) {
            return -1;
        }

        int deepRightLeaf = -1;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node element = queue.remove();

            if(element.left != null) {
                queue.add(element.left);
            }

            if(element.right != null) {
                queue.add(element.right);

                if(element.right.left == null && element.right.right == null) {
                    deepRightLeaf = element.right.data;
                }
            }
        }
        return deepRightLeaf;

    }
}
