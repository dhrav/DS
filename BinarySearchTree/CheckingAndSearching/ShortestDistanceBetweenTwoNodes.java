package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

public class ShortestDistanceBetweenTwoNodes {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(15);
        root.right.left = new Node(25);
        root.right.right = new Node(35);

        System.out.println(findShortestDistance(root, 30, 35));
    }

    private static int findShortestDistance(Node root, int key1, int key2) {
        if(root == null) {
            return -1;
        }

        Node lca = findLca(root, key1, key2);
        if(lca.data == key1) {
            return findLevel(lca, key2,0);
        } else if(lca.data == key2) {
            return findLevel(lca, key1, 0);
        } else {
            int firstNodeLevel = findLevel(lca, key1, 0);
            int secondNodeLevel = findLevel(lca, key2, 0);
            return firstNodeLevel + secondNodeLevel;
        }
    }

    private static int findLevel(Node root, int key2, int level) {
        if(root == null) {
            return 0;
        }

        if(root.data == key2) {
            return level;
        } else if(root.data < key2) {
            return findLevel(root.right, key2, level+1);
        } else {
            return findLevel(root.left, key2, level+1);
        }
    }

    private static Node findLca(Node root, int key1, int key2) {
        if(root == null) {
            return null;
        }

        if(root.data == key1 || root.data == key2) {
            return root;
        }

        if(root.data < key1 && root.data < key2) {
            return findLca(root.right, key1, key2);
        } else if(root.data > key1 && root.data > key2) {
            return findLca(root.left, key1, key2);
        }
        return root;
    }
}
