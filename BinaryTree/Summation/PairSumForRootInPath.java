package BinaryTree.Summation;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;

public class PairSumForRootInPath {
    class Result {
        boolean isPresent;
        int first;
        int second;
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left    = new Node(5);
        root.right   = new Node(4);
        root.left.left = new Node(9);
        root.left.right = new Node(7);
        root.left.right.left = new Node(1);
        root.left.right.right = new Node(12);
        root.left.right.right.right = new Node(2);
        root.right.right = new Node(11);
        root.right.right.left = new Node(3);

        PairSumForRootInPath object = new PairSumForRootInPath();

        System.out.println(object.isPairSumPresentInPath(root));
    }

    private boolean isPairSumPresentInPath(Node root) {
        if(root == null) {
            return false;
        }

        Result result = new Result();
        pairSumUtil(root, result, new ArrayList<>(), 0);
        return result.isPresent;
    }

    private void pairSumUtil(Node root, Result result, List<Integer> path, int index) {
        if(root == null) {
            return;
        }

        path.add(index, root.data);
        index++;
        if(root.left == null && root.right == null) {
            int rootData = path.get(0);
            for(int i= 1; i < index; i++) {
                int second = rootData - path.get(i);
                for(int j = 1; j < index; j++) {
                    if(path.get(j) == second && i != j) {
                        result.isPresent = true;
                        result.first = path.get(i);
                        result.second = second;
                        return;
                    }
                }

            }
        } else {
            if(!result.isPresent) {
                pairSumUtil(root.left, result, path, index);
                pairSumUtil(root.right, result, path, index);
            }
        }
    }

}
