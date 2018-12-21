package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

public class FindLargestBSTSubTree {
    static class Details {
        int treeSize;
        int bstTreeSize;
        boolean isBST;
        int min;
        int max;

        public Details() {}

        public Details(int treeSize, int bstTreeSize, boolean isBST, int max, int min) {
            this.treeSize = treeSize;
            this.bstTreeSize = bstTreeSize;
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left        = new Node(10);
        root.right       = new Node(60);
        root.left.left  = new Node(5);
        root.left.right = new Node(20);
        root.right.left  = new Node(55);
        root.right.left.left  = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        Details result = findLargestSubTree(root);
        System.out.println(result.bstTreeSize);
    }

    private static Details findLargestSubTree(Node root) {
        if(root == null) {
            return new Details(0, 0, true, 0, 0);
        }

        if(root.left == null && root.right == null) {
            return new Details(1, 1, true, root.data, root.data);
        }

        Details leftSubTreeResult = findLargestSubTree(root.left);
        Details rightSubTreeResult = findLargestSubTree(root.right);

        Details returnVal = new Details();
        returnVal.treeSize = 1 + leftSubTreeResult.treeSize + rightSubTreeResult.treeSize;

        if(leftSubTreeResult.isBST && rightSubTreeResult.isBST && leftSubTreeResult.max < root.data && (rightSubTreeResult.min == 0 || rightSubTreeResult.min > root.data )) {
            returnVal.bstTreeSize = returnVal.treeSize;
            returnVal.isBST = true;
            returnVal.min = Math.min(leftSubTreeResult.min, Math.min(root.data, rightSubTreeResult.min));
            returnVal.max = Math.max(rightSubTreeResult.max, Math.max(leftSubTreeResult.max, root.data));
        } else {
            returnVal.isBST = false;
            returnVal.bstTreeSize = Math.max(leftSubTreeResult.bstTreeSize, rightSubTreeResult.bstTreeSize);
        }

        return returnVal;


    }
}
