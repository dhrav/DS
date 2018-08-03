package BinaryTree.Summation;

import BinaryTree.Node;

import java.util.HashMap;

public class VerticalSum {
    public static void main(String[] args) {
        Node root         = new Node(1);
        root.left                = new Node(2);
        root.right               = new Node(3);
        root.right.left         = new Node(6);
        root.right.right        = new Node(7);
        root.left.left          = new Node(4);
        root.left.right         = new Node(5);

        findVerticalSum(root);
    }

    private static void findVerticalSum(Node root) {
        if(root == null) {
            return;
        }

        HashMap<Integer, Integer> verticalSumMap = new HashMap<>();

        verticalSumUtil(root, verticalSumMap, 0);
        if(!verticalSumMap.isEmpty()) {
            System.out.println(verticalSumMap.entrySet());
        }
    }

    private static void verticalSumUtil(Node root, HashMap<Integer,Integer> verticalSumMap, int horizontalDistance) {
        if(root == null) {
            return;
        }

        if(verticalSumMap.get(horizontalDistance) == null) {
            verticalSumMap.put(horizontalDistance, root.data);
        } else {
            int prevSum = verticalSumMap.get(horizontalDistance);
            verticalSumMap.put(horizontalDistance, prevSum+root.data);
        }

        verticalSumUtil(root.left, verticalSumMap, horizontalDistance-1);
        verticalSumUtil(root.right, verticalSumMap, horizontalDistance+1);
    }
}
