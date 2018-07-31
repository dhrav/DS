package BinaryTree.CheckingPrinting;

import BinaryTree.Node;

import java.util.HashSet;

public class CheckDuplicate {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(12);
        root.left.left = new Node(3);
        System.out.println(hasDuplicate(root, new HashSet<>()));
    }

    private static boolean hasDuplicate(Node root, HashSet<Integer> nodeSet) {
        if(root == null) {
            return false;
        }
        if(nodeSet.contains(root.data)) {
            return true;
        } else {
            nodeSet.add(root.data);
        }

        return hasDuplicate(root.left, nodeSet) ||
                hasDuplicate(root.right, nodeSet);
    }
}
