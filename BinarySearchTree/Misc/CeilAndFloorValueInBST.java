package BinarySearchTree.Misc;

import BinaryTree.Node;

public class CeilAndFloorValueInBST {
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(12);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.right.left = new Node(10);
        root.right.right = new Node(14);

        int key = 5;
        int ceil = findCeil(root, key);
        System.out.println("Ceil value of " + key + " is " + ceil);

        int floor = findFloor(root, key);
        System.out.println("Floor value of " + key + " is " + floor);
    }

    private static int findFloor(Node root, int key) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }

        if(root.data == key) {
            return root.data;
        }

        if(root.data > key) {
            return findFloor(root.left, key);
        }

        int floor = findFloor(root.right, key);
        return (floor <= key) ? floor : root.data;
    }

    private static int findCeil(Node root, int key) {
        if(root == null) {
            return -1;
        }

        if(root.data == key) {
            return root.data;
        }

        if(root.data < key) {
            return findCeil(root.right, key);
        }

        int ceil = findCeil(root.left, key);
        return (ceil >= key) ?ceil :root.data;
    }
}
