package BinaryTree.Misc;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmallestValueInLevel {
    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(6);
        root.right = new Node(5);
        root.left.left = new Node(4);
        root.left.right = new Node(3);
        root.right.left = new Node(2);
        root.right.right = new Node(1);

        printSmallestValAtEachLevel(root);
    }

    private static void printSmallestValAtEachLevel(Node root) {
        if(root == null) {
            return;
        }

        HashMap<Integer, Integer> minValList = new HashMap<>();

        findSmallest(root, minValList, 0);

        for(Map.Entry<Integer, Integer> entry : minValList.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    private static void findSmallest(Node root, HashMap<Integer, Integer> minValList, int level) {
        if(root == null) {
            return;
        }

        if(minValList.containsKey(level)) {
            int curVal = minValList.get(level);
            if(curVal > root.data) {
                minValList.put(level, root.data);
            }
        } else {
            minValList.put(level, root.data);
        }

        findSmallest(root.left, minValList, level+1);
        findSmallest(root.right, minValList, level+1);
    }
}
