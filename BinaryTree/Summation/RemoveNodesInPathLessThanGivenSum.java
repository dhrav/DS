package BinaryTree.Summation;

import BinaryTree.Node;

public class RemoveNodesInPathLessThanGivenSum {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(12);
        root.right.right.left = new Node(10);
        root.right.right.left.right = new Node(11);
        root.left.left.right.left = new Node(13);
        root.left.left.right.right = new Node(14);
        root.left.left.right.right.left = new Node(15);

        RemoveNodesInPathLessThanGivenSum object = new RemoveNodesInPathLessThanGivenSum();

        System.out.println("Original Tree");
        //before pruning
        object.inorder(root);

        root = object.pruneTree(root, 45);

        System.out.println("After removal");

        //after pruning
        object.inorder(root);
    }

    private Node pruneTree(Node root, int sum) {
        if(root == null) {
            return null;
        }

        root.left = pruneTree(root.left, sum-root.data);
        root.right = pruneTree(root.right, sum-root.data);

        if(root.left == null && root.right == null) {
            if(root.data < sum) {
                root = null;
            }
        }

        return root;
    }

    private void inorder(Node root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
}
