package BinaryTree.LCA;

import BinaryTree.Node;

public class FindDistanceBetween2Nodes {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        int distance = findDistance(root, 8, 5);
        System.out.println(distance);
    }

    private static int findDistance(Node root, int key1, int key2) {
        if(root == null) {
            return -1;
        }

        Node lca = findLca(root, key1, key2);

        int distance1 = findLevel(lca, key1, 0);
        int distance2 = findLevel(lca, key2, 0);

        return distance1 + distance2;

    }

    private static int findLevel(Node root, int key, int level) {
        if(root == null) {
            return -1;
        }

        if(root.data == key) {
            return level;
        }

        int leftLevel = findLevel(root.left, key, level+1);
        if(leftLevel == -1) {
            return findLevel(root.right, key, level+1);
        }

        return leftLevel;
    }

    private static Node findLca(Node root, int key1, int key2) {
        if(root == null) {
            return null;
        }

        if(root.data == key1 || root.data == key2) {
            return root;
        }

        Node leftLcaNode = findLca(root.left, key1, key2);
        Node rightLcaNode = findLca(root.right, key1, key2);
        if(leftLcaNode != null && rightLcaNode != null) {
            return root;
        }

        return leftLcaNode == null ? rightLcaNode : leftLcaNode;
    }
}
