package BinaryTree.Misc;

import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class FindDeepestLeftLeaf {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.right = new Node(7);
        root.right.right.right = new Node(8);
        root.right.left.right.left = new Node(19);
        root.right.right.right.right = new Node(10);


        System.out.println(findDeepestLeftLeaf(root));
    }

    private static int findDeepestLeftLeaf(Node root) {
        if(root == null) {
            return -1;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node deepestLeafLeftNode = null;

        while(!queue.isEmpty()) {
            Node element = queue.remove();
            if(element.left != null) {
                if(element.left.left == null && element.left.right == null) {
                    deepestLeafLeftNode = element.left;
                }
                queue.add(element.left);
            }

            if(element.right != null) {
                queue.add(element.right);
            }
        }

        return deepestLeafLeftNode == null ? -1 : deepestLeafLeftNode.data;
    }
}
