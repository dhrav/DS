package BinaryTree.CheckingPrinting;

import BinaryTree.Node;

public class CheckForEdgeToSplitBT {
    static boolean result = false;
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(1);
        root.right = new Node(6);
        root.left.left = new Node(3);
        root.right.left = new Node(7);
        root.right.right = new Node(4);

        System.out.println(checkForBTSplit(root));
    }

    private static boolean checkForBTSplit(Node root) {
        if(root == null) {
            return true;
        }

        int totalCount = count(root);



        checkForBTSplitUtil(root, totalCount);

        return result;


    }

    private static int checkForBTSplitUtil(Node root, int totalCount) {
        if(root == null) {
            return 0;
        }

        int count = 1 + checkForBTSplitUtil(root.left, totalCount) + checkForBTSplitUtil(root.right, totalCount);

        if(count == (totalCount-count)){
            result = true;
        }

        return count;
    }

    private static int count(Node root) {

        if(root == null) {
            return 0;
        }

        return 1 + count(root.left) + count(root.right);
    }
}
