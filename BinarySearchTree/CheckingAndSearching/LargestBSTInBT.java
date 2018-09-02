package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

public class LargestBSTInBT {
    static class Detail {
        int currentTreeSize;
        int bstTreeSize;
        boolean isBST;
        int max;
        int min;

        public Detail() {
        }

        public Detail(int treeSize, int bstTreeSize, boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.bstTreeSize = bstTreeSize;
            this.currentTreeSize = treeSize;
            this.min = min;
            this.max = max;
        }
    }

    public static void main(String[] args) {
       /* Node root = new Node(60);
        root.left = new Node(65);
        root.right = new Node(70);
        root.left.left = new Node(50);*/
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);
        Detail detail = findLargestBST(root);
        System.out.println(detail.bstTreeSize);
    }

    private static Detail findLargestBST(Node root) {
        if(root == null) {
            return new Detail(0, 0, true, 0, 0);
        }

        if(root.left == null && root.right == null) {
            return new Detail(1, 1, true, root.data, root.data);
        }

        Detail leftTree = findLargestBST(root.left);
        Detail rightTree = findLargestBST(root.right);

        Detail returnVal = new Detail();
        returnVal.currentTreeSize = 1 + leftTree.currentTreeSize + rightTree.currentTreeSize;

        if(leftTree.isBST && rightTree.isBST && leftTree.max < root.data && (rightTree.min == 0 || rightTree.min > root.data)) {
            returnVal.isBST = true;
            returnVal.bstTreeSize = returnVal.currentTreeSize;
            returnVal.min = Math.min(leftTree.min, Math.min(rightTree.min, root.data));
            returnVal.max = Math.max(rightTree.max, Math.max(leftTree.max, root.data));
        } else {
            returnVal.isBST = false;
            returnVal.bstTreeSize = Math.max(leftTree.bstTreeSize, rightTree.bstTreeSize);
        }

        return returnVal;


    }


}
