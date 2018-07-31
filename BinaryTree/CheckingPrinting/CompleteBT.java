package BinaryTree.CheckingPrinting;

import BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBT {
    public static void main(String[] args) {
        Node root  = new Node(1);
        root.left         = new Node(2);
        root.right        = new Node(3);
        root.left.left   = new Node(4);
        root.left.right  = new Node(5);
        //root.right.right = new Node(6);
        root.right.left = new Node(6);


        System.out.println(isComplete(root));
    }

    private static boolean isFullNode(Node root) {
        return root.left != null && root.right != null;
    }

    private static boolean isLeafNode(Node root) {
        return root.left == null && root.right == null;
    }

    private static boolean isComplete(Node root) {
        if(root == null) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean onlyLeaf = false;

        while(!queue.isEmpty()) {
            Node element = queue.remove();
            if(!onlyLeaf && !isFullNode(element)) {
                if(element.left == null && element.right != null) {
                    return false;
                }
                onlyLeaf = true;
            } else if(onlyLeaf) {
                if(!isLeafNode(element)) {
                    return false;
                }
            }
            if(element.left != null) {
                queue.add(element.left);
            }

            if(element.right != null) {
                queue.add(element.right);
            }
        }
        return true;
    }
}
