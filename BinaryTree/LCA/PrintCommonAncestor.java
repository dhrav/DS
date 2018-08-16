package BinaryTree.LCA;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;

public class PrintCommonAncestor {
    static List<Integer> pathList1 = new ArrayList<>();
    static List<Integer> pathList2 = new ArrayList<>();

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.right.left.left = new Node(9);
        root.right.left.right = new Node(10);

        findCommonAncestor(root, 9, 7);
    }

    private static void findCommonAncestor(Node root, int key1, int key2) {
        if(root == null) {
            System.out.println("Not present");
        }

        findPath(root, key1, pathList1);
        findPath(root, key2, pathList2);
        for(int i = 0; i < pathList1.size() && i < pathList2.size(); i++) {
            if(pathList1.get(i) == pathList2.get(i)) {
                System.out.println(pathList1.get(i));
            } else {
                break;
            }
        }

    }

    private static boolean findPath(Node root, int key1, List<Integer> pathList1) {
        if(root == null) {
            return false;
        }

        pathList1.add(root.data);
        if(root.data == key1) {
            return true;
        }

        boolean isPresentInLeftTree = findPath(root.left, key1, pathList1);
        if(isPresentInLeftTree) {
            return true;
        }

        boolean isPresentRight = findPath(root.right, key1, pathList1);
        if(isPresentRight) {
            return true;
        }

        pathList1.remove(pathList1.size()-1);
        return false;
    }
}
