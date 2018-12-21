package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

import java.util.HashSet;

public class FindPairWithGivenSum {
    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);

        System.out.println(findPair(root, 28));
    }

    private static boolean findPair(Node root, int sum) {
        if(root == null) {
            return false;
        }

        HashSet<Integer> nodeEntries = new HashSet<>();
        inorder(root, nodeEntries);

        for(Integer element : nodeEntries) {
            int pair = sum - element;
            if(pair != element) {
                if(nodeEntries.contains(pair)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void inorder(Node root, HashSet nodeEntries) {
        if(root == null) {
            return;
        }

        inorder(root.left, nodeEntries);
        nodeEntries.add(root.data);
        inorder(root.right, nodeEntries);

    }
}
