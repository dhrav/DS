package BinaryTree.Misc;

import BinaryTree.Node;

public class LargestSubTreeWithIdenticalLeftRightTree {

    static class Result {
        Node maxNode;
        int maxSize;
    }

    static class Details {
        String treeString ="";
        int size=0;
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(10);
        root.right = new Node(60);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right.left = new Node(70);
        root.right.left.left = new Node(65);
        root.right.left.right = new Node(80);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        findLargestSubTree(root);
    }



    private static void findLargestSubTree(Node root) {
        if(root == null) {
            return;
        }

        Result result = new Result();


        findLargestSubTreeUtil(root, result);
        System.out.println("Node " + result.maxNode.data + " with depth as " + result.maxSize );
    }

    private static Details findLargestSubTreeUtil(Node root, Result result) {
        if(root == null || (root.left == null && root.right == null)) {
            return new Details();
        }

        Details leftSize = findLargestSubTreeUtil(root.left, result);
        Details rightSize = findLargestSubTreeUtil(root.right, result);

        int curSize = 1 + leftSize.size + rightSize.size;
        if(leftSize.treeString.equals(rightSize.treeString)) {
            if(result.maxSize < curSize) {
                result.maxSize = curSize;
                result.maxNode = root;
            }
        }

        Details returnval = new Details();
        returnval.size = curSize;
        StringBuilder builder = new StringBuilder();
        builder.append("|").append(leftSize.treeString).append("|");
        builder.append("|").append(root.data).append("|");
        builder.append("|").append(rightSize.treeString).append("|");
        returnval.treeString = builder.toString();

        return returnval;
    }
}
