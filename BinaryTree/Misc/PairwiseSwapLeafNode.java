package BinaryTree.Misc;

import BinaryTree.Node;

public class PairwiseSwapLeafNode {
    static class Result {
        Node prev;
        int count = 0;
    }
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(8);
        root.right.left.left = new Node(6);
        root.right.left.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);
        System.out.println("Before change");
        inorder(root);

        Result result = new Result();

         swapLeaf(root, result);

        System.out.println("After change");
        inorder(root);
    }

    private static void  swapLeaf(Node root, Result result) {
        if(root == null) {
            return;
        }


        if(root.left == null && root.right == null) {
            result.count++;
            if(result.count % 2 != 0) {
                result.prev = root;
            } else {
                int temp = result.prev.data;
                result.prev.data = root.data;
                root.data = temp;
            }
        }

        swapLeaf(root.left, result);
        swapLeaf(root.right, result);
    }

    private static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
}
