package BinaryTree.LCA;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;

public class FindLCA_1 {
   static List<Integer> pathListForNode1 = new ArrayList<>();
    static List<Integer> pathListForNode2 = new ArrayList<>();

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        //findLCA(root, 4, 5);
        findLCA(root, 2, 4);
    }

    private static void findLCA(Node root, int key1, int key2) {
        if(root == null) {
            return;
        }



        findPath(root, key1, pathListForNode1);
        findPath(root, key2, pathListForNode2);

        int i;
        for( i =0; i < pathListForNode1.size() && i < pathListForNode2.size(); i++) {
            if(!pathListForNode1.get(i).equals(pathListForNode2.get(i))) {
                break;
            }
        }

        System.out.println(pathListForNode1.get(i-1));
    }

    private static boolean findPath(Node root, int key1, List<Integer> pathNode) {
        if(root == null) {
            return false;
        }

        pathNode.add(root.data);
        if(root.data == key1) {
            return true;
        }

        boolean leftTree = findPath(root.left, key1, pathNode);
        if(leftTree) {
            return true;
        }

        boolean rightTree = findPath(root.right, key1, pathNode);
        if(rightTree) {
            return true;
        }

        pathNode.remove(pathNode.size()-1);
        return false;
    }


}
