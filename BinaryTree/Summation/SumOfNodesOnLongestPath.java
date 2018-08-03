package BinaryTree.Summation;

import BinaryTree.Node;

public class SumOfNodesOnLongestPath {

    class Result {
        int sum;
        int maxPathLength = Integer.MIN_VALUE;
    }
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(7);
        root.left.right = new Node(1);
        root.right.left = new Node(2);
        root.right.right = new Node(3);
        root.left.right.left = new Node(6);

        SumOfNodesOnLongestPath object = new SumOfNodesOnLongestPath();

        System.out.println(object.findSumOfLongestPath(root));
    }

    private int findSumOfLongestPath(Node root) {
        if(root == null) {
            return 0;
        }

        Result result = new Result();
        findSumOfLongestPathUtil(root, result, new int[100], 0);
        return result.sum;
    }

    private void findSumOfLongestPathUtil(Node root, Result result, int[] path, int index) {
        if(root == null) {
            return;
        }

        path[index++] = root.data;
        if(root.left == null && root.right == null) {
            if(result.maxPathLength < index) {
                result.maxPathLength = index;
                result.sum = 0;
                for(int i = 0; i < index; i++) {
                    result.sum+= path[i];
                }
            }
        } else {
            findSumOfLongestPathUtil(root.left, result, path, index);
            findSumOfLongestPathUtil(root.right, result, path, index);
        }

    }
}
