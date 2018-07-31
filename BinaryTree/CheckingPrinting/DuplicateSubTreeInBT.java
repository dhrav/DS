package BinaryTree.CheckingPrinting;

import java.util.HashSet;

public class DuplicateSubTreeInBT {
    static class Node {
        char data;
        Node left, right;

        Node(char c) {
            data = c;
            left = null;
            right = null;
        }
    }
    public static void main(String[] args) {
        Node root = new Node('A');
        root.left = new Node('B');
        root.right = new Node('C');
        root.left.left = new Node('D');
        root.left.right = new Node('E');
        root.right.right = new Node('B');
        root.right.right.right = new Node('E');
        //root.right.right.left= new Node('D');
        root.right.right.left= new Node('Z');

        System.out.println("".equals(findDuplicateSubTree(root, "", new HashSet<String>())));
    }

    private static String findDuplicateSubTree(Node root, String result, HashSet<String> subTreeSet) {
        if(root == null) {
            return "$";
        }

        String leftSubTreeString = findDuplicateSubTree(root.left, result, subTreeSet);
        if("".equals(leftSubTreeString)) {
            return leftSubTreeString;
        }

        String rightSubTreeString = findDuplicateSubTree(root.right, result, subTreeSet);
        if("".equals(rightSubTreeString)) {
            return rightSubTreeString;
        }

        String currentString = root.data + leftSubTreeString + rightSubTreeString;

        if(currentString.length() > 3 && subTreeSet.contains(currentString)) {
            return "";
        } else {
            subTreeSet.add(currentString);
        }

        return currentString;
    }
}
