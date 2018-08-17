package BinaryTree.Misc;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CheckIfVerticalLevelSorted {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(7);
        root.left.right = new Node(4);
        root.left.right.left = new Node(6);

        int level = -1;
        System.out.println(checkIfVLevelSorted(root, level));
    }

    private static boolean checkIfVLevelSorted(Node root, int level) {
        if(root == null) {
            return false;
        }

        HashMap<Integer, List<Integer>> verticalNodeMap = new HashMap<>();
        populateVerticalNode(verticalNodeMap, root, 0);
        boolean result = true;
        List<Integer> reqNodeList = verticalNodeMap.get(level);
        if(reqNodeList != null) {
            int prev = reqNodeList.get(0);
            for(int i = 1; i < reqNodeList.size(); i++) {
                int current =  reqNodeList.get(i);
                if(prev > current){
                    result = false;
                    break;
                }

                prev = current;
            }
        }
        return result;
    }

    private static void populateVerticalNode(HashMap<Integer,List<Integer>> verticalNodeMap, Node root, int horizontalDistance) {
        if(root == null) {
            return;
        }

        if(verticalNodeMap.containsKey(horizontalDistance)) {
            List<Integer> nodeList = verticalNodeMap.get(horizontalDistance);
            nodeList.add(root.data);
            verticalNodeMap.put(horizontalDistance, nodeList);
        } else {
            List<Integer> nodeList = new ArrayList<>();
            nodeList.add(root.data);
            verticalNodeMap.put(horizontalDistance, nodeList);
        }

        populateVerticalNode(verticalNodeMap, root.left, horizontalDistance-1);
        populateVerticalNode(verticalNodeMap, root.right, horizontalDistance+1);
    }
}
