package BinaryTree.Misc;

import BinaryTree.Node;

public class TurnsToReachBetweenTwoNodesInBT {
    static class Result {
        String treeString = "";
    }
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

        int key1 = 5, key2 = 3;
        findTurns(root, key1, key2);
    }

    private static void findTurns(Node root, int key1, int key2) {
        Node lca = findLca(root, key1, key2);
        if(lca != null) {
            String finalTreeString;
            Result result = new Result();
            if(lca.data == key1) {
                getTreeString(lca, key2, result, "");
                finalTreeString = result.treeString;
            } else if(lca.data == key2) {
                getTreeString(lca, key1, result, "");
                finalTreeString = result.treeString;
            } else {
                 getTreeString(lca, key1, result, "");
                finalTreeString = result.treeString;
                StringBuilder builder = new StringBuilder(finalTreeString);
                finalTreeString = builder.reverse().toString();

                Result result2 = new Result();
                getTreeString(lca, key2, result2, "");
                finalTreeString+= result2.treeString;
            }

            int turns = 0;

            for(int i = 1; i < finalTreeString.length(); i++) {
                if(finalTreeString.charAt(i-1) != finalTreeString.charAt(i)) {
                    turns++;
                }
            }
            System.out.println("Turns to reach between " + key1 + " , " + key2 + " is " + turns);

        } else {
            System.out.println("Not right input");
        }
    }

    private static void getTreeString(Node root, int key1, Result result, String s) {
        if(root == null) {
            return;
        }

        if(root.data == key1) {
            result.treeString = s;
            return;
        }

        getTreeString(root.left, key1, result, s +"L");
        getTreeString(root.right, key1, result, s+"R");
    }

    private static Node findLca(Node root, int key1, int key2) {
        if(root == null) {
            return null;
        }

        if(root.data == key1) {
            return root;
        }

        if(root.data == key2) {
            return root;
        }

        Node leftTree = findLca(root.left, key1, key2);
        Node rightTree = findLca(root.right, key1, key2);

        if(leftTree != null && rightTree != null) {
            return root;
        }

        return (leftTree == null) ? rightTree : leftTree;
    }
}
