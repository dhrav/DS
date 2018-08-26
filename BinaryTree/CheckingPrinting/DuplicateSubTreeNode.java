package BinaryTree.CheckingPrinting;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DuplicateSubTreeNode {
    static class Result {
        HashMap<String, Integer> nodemap = new HashMap<>();
        List<Node> duplicateNodeList = new ArrayList<>();
    }
    public static void main(String[] args) {
        Node root = null;
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(2);
        root.right.left.left = new Node(4);
        root.right.right = new Node(4);
        Result result = new Result();
        findDuplicate(root, result);

        for(Node node : result.duplicateNodeList) {
            System.out.println(node.data);
        }
    }

    /*
    * Do inorder traversal and store the string in the hashmap
    * Using hashmap, find duplicates*/

    private static String findDuplicate(Node root, Result result) {
        if(root == null) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        builder.append("(");
        builder.append(findDuplicate(root.left, result));
        builder.append(root.data);
        builder.append(findDuplicate(root.right, result));
        builder.append(")");

        String currentString = builder.toString();
        if(result.nodemap.containsKey(currentString)) {
            int frequency = result.nodemap.get(currentString);
            if(frequency == 1) {
                result.duplicateNodeList.add(root);
            }
                result.nodemap.put(currentString, frequency+1);

        } else {
            result.nodemap.put(currentString, 1);
        }
        return currentString;
    }
}
