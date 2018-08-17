package BinaryTree.Misc;

import BinaryTree.Node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BottomViewBT {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        printBottomView(root);
    }

    private static void printBottomView(Node root) {
        if(root == null) {
            return;
        }

        TreeMap<Integer, Data> verticalNodeMap = new TreeMap<>();
        printBottomViewUtil(root, verticalNodeMap, 0, 0);
        for(Map.Entry<Integer, Data> entry : verticalNodeMap.entrySet()) {
            System.out.println(entry.getValue().data);
        }

    }

    private static void printBottomViewUtil(Node root, TreeMap<Integer,Data> verticalNodeMap, int horizontalDistance, int level) {
        if(root == null) {
            return;
        }

        if(verticalNodeMap.containsKey(horizontalDistance)) {
            Data data = verticalNodeMap.get(horizontalDistance);
            if(data.level <= level) {
                data.level = level;
                data.data = root.data;
                verticalNodeMap.put(horizontalDistance, data);
            }
        } else {
            Data data = new Data();
            data.data = root.data;
            data.level = level;
            verticalNodeMap.put(horizontalDistance, data);
        }



        printBottomViewUtil(root.left, verticalNodeMap, horizontalDistance-1, level+1);
        printBottomViewUtil(root.right, verticalNodeMap, horizontalDistance+1, level+1);
    }
}

class Data {
    int data;
    int level;
}

