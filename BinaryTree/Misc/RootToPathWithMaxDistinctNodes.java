package BinaryTree.Misc;

import BinaryTree.Node;

import java.util.HashMap;

public class RootToPathWithMaxDistinctNodes {
    static class Result {
        int maxCount;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);

        findMaxDistinctNodeInPath(root);
    }

    private static void findMaxDistinctNodeInPath(Node root) {
        if(root == null) {
            System.out.println("Empty tree");
            return;
        }

        HashMap<Integer, Integer> nodeCountInPath = new HashMap<>();
        Result result = new Result();
        findDistinctNodeUtil(root, nodeCountInPath, result);
        System.out.println("Max distinct nodes in all paths is of " + result.maxCount);
    }

    private static void findDistinctNodeUtil(Node root, HashMap<Integer,Integer> nodeCountInPath, Result result) {
        if(root == null) {
            return;
        }

        if(nodeCountInPath.containsKey(root.data)) {
            int frequency = nodeCountInPath.get(root.data);
            nodeCountInPath.put(root.data , frequency + 1);
        } else {
            nodeCountInPath.put(root.data, 1);
        }

        if(root.left == null && root.right == null) {

            if(result.maxCount < nodeCountInPath.keySet().size()) {
                result.maxCount = nodeCountInPath.keySet().size();
            }

        }

        findDistinctNodeUtil(root.left, nodeCountInPath, result);
        findDistinctNodeUtil(root.right, nodeCountInPath, result);

        int frequency = nodeCountInPath.get(root.data);
        frequency-=1;
        if(frequency == 0) {
            nodeCountInPath.remove(root.data);
        } else {
            nodeCountInPath.put(root.data, frequency);
        }
    }
}
