package Heap;

import java.util.LinkedList;
import java.util.Queue;

public class CheckBinaryTreeIsHeap {
    public static void main(String[] args) {
        NodeElement root = new NodeElement(10);
        root.left = new NodeElement(9);
        root.right = new NodeElement(8);
        root.left.left = new NodeElement(7);
        root.left.right = new NodeElement(6);
        root.right.left = new NodeElement(5);
        root.right.right = new NodeElement(4);
        root.left.left.left = new NodeElement(3);
        root.left.left.right = new NodeElement(2);
        root.left.right.left = new NodeElement(1);

        CheckBinaryTreeIsHeap object = new CheckBinaryTreeIsHeap();

        System.out.println("\nThe binary tree is max heap or not :" + object.isHeap(root));
    }

    private Boolean isHeap(NodeElement root) {
        if(root == null) {
            return true;
        }

        return isCompleteBinaryTree(root) && isMaxHeap(root);

    }

    private boolean isMaxHeap(NodeElement root) {
        if(root == null || isLeafNode(root)) {
            return true;
        }

        //if only one child
        if(root.right == null) {
            return root.data >= root.left.data;
        }

        //check the current root and recur for subtree if its true
        if(root.data >= root.left.data && root.data >= root.right.data ) {
            return isMaxHeap(root.left) && isMaxHeap(root.right);
        } else { // else if max heap is violated in the current root, return false
            return false;
        }
    }

    private Boolean isCompleteBinaryTree(NodeElement root) {
        if(root == null) {
            return true;
        }

        Queue<NodeElement> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeafFound = false;

        while(!queue.isEmpty()) {
            NodeElement curr = queue.remove();
            if(!isFullNode(curr) && !isLeafFound) {
                if(curr.left == null && curr.right != null) {
                    return false;
                }
                isLeafFound = true;
            } else if(isLeafFound && !isLeafNode(curr)) {
                return false;
            }

            if(curr.left != null) {
                queue.add(curr.left);
            }

            if(curr.right != null) {
                queue.add(curr.right);
            }
        }
        return true;

    }

    private boolean isFullNode(NodeElement root) {
        return root.left != null && root.right != null;
    }

    private boolean isLeafNode(NodeElement root) {
        return root.left == null && root.right == null;
    }
}

class NodeElement {
    public int data;
    public NodeElement left,right;

    public NodeElement(int data) {
        this.data = data;
        left = null;
        right = null;
    }

}
