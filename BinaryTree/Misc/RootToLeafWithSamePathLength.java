package BinaryTree.Misc;

import BinaryTree.Node;

import java.util.HashMap;
import java.util.Map;

public class RootToLeafWithSamePathLength {
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left    = new Node(5);
        root.right   = new Node(4);
        root.left.left = new Node(9);
        root.left.right = new Node(7);
        root.right.right = new Node(11);
        root.right.right.left = new Node(3);

        countDistinctPath(root);
    }

    private static void countDistinctPath(Node root) {
        if(root == null) {
            System.out.println("The tree is empty");
            return;
        }

        HashMap<Integer, Integer> pathLengthCount = new HashMap<>();
        countPathUtil(root, pathLengthCount, 1);

        //System.out.println(pathLengthCount.entrySet());

        for(Map.Entry<Integer, Integer> entry : pathLengthCount.entrySet()) {
            System.out.println(entry.getValue() + " path(s) have length of " + entry.getKey());
        }
    }

    private static void countPathUtil(Node root, HashMap<Integer,Integer> pathLengthCount, int index) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            if(pathLengthCount.containsKey(index)) {
                int distinctPathCount = pathLengthCount.get(index);
                pathLengthCount.put(index, distinctPathCount+1);
            } else {
                pathLengthCount.put(index, 1);
            }
        }

        countPathUtil(root.left, pathLengthCount, index+1);
        countPathUtil(root.right, pathLengthCount, index+1);
    }
}
