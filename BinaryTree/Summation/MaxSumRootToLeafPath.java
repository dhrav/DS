package BinaryTree.Summation;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;

public class MaxSumRootToLeafPath {

    class Result {
        int maxSum;
        List<Integer> nodeList;
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(-2);
        root.right = new Node(7);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);

        MaxSumRootToLeafPath object = new MaxSumRootToLeafPath();

        System.out.println("Max Path Sum : " + object.findMaxSumPath(root));

       /* The above solution calculates maximum sum in one traversal.
            Other approach is that, find the leaf node in the maximum sum path.
            Using this leaf node, find all the root to this leaf path in the tree and print the same.
            (Recursive approach - no need to maintain path[].
            check if current root is search key || if search key is present in either of left /right subtree
            then print that particular node)/ */
    }

    private int findMaxSumPath(Node root) {

        if(root == null) {
            return 0;
        }

        Result result = new Result();

        findMaxSumPathUtil(root, result, new int[100], 0);
        System.out.println("Max sum Path :");
        for(int i : result.nodeList) {
            System.out.print(i + " ");
        }
        System.out.println();
        return result.maxSum;
    }

    private void findMaxSumPathUtil(Node root, Result result, int[] path, int index) {
        if(root == null) {
            return;
        }

        path[index++] = root.data;
        if(root.left == null && root.right == null) {
            int currentSum = 0;
            List<Integer> currentNodeList = new ArrayList<>();
            for(int i = 0; i<index; i++) {
                currentSum+= path[i];
                currentNodeList.add(path[i]);
            }

            if(currentSum > result.maxSum) {
                result.maxSum = currentSum;
                result.nodeList = currentNodeList;
            }
        } else {
            findMaxSumPathUtil(root.left, result, path, index);
            findMaxSumPathUtil(root.right, result, path, index);
        }

    }
}
