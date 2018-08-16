package BinaryTree.LCA;

import BinaryTree.Node;

public class PrintCommonAncestor_LCA {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.right.left.left = new Node(9);
        root.right.left.right = new Node(10);

        findCommonAncestor(root, 9, 7);
    }

    private static void findCommonAncestor(Node root, int key1, int key2) {
        if(root == null) {
            return;
        }

        Node lca = findLca(root, key1, key2);

        printAncestors(root, lca);
    }

    private static boolean printAncestors(Node root, Node lca) {
        if(root == null || lca == null) {
            return false;
        }

        if(root.data == lca.data) {
            System.out.println(root.data);
            return true;
        }

        if(printAncestors(root.left, lca) || printAncestors(root.right, lca)) {
            System.out.println(root.data);
            return true;
        }

        return false;
    }

    private static Node findLca(Node root, int key1, int key2) {
        if(root == null) {
            return null;
        }

        if(root.data == key1 || root.data == key2) {
            return root;
        }

        Node leftSubTree = findLca(root.left, key1, key2);
        Node rightSubTree = findLca(root.right, key1, key2);

        if(rightSubTree != null && leftSubTree != null) {
            return root;
        }

        return leftSubTree == null ? rightSubTree : leftSubTree;
    }
}
