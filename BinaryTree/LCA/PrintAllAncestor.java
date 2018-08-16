package BinaryTree.LCA;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;

public class PrintAllAncestor {
    static List<Integer> pathFromRoot = new ArrayList<>();

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        boolean hasPath = printAllAncestor(root, 7);
        if(!hasPath) {
            System.out.println("Not present");
        } else {
            for(int i : pathFromRoot) {
                System.out.println(i);
            }
        }
    }

    private static boolean printAllAncestor(Node root, int key) {
        if(root == null) {
            return false;
        }

        pathFromRoot.add(root.data);
        if(root.data == key) {
            return true;
        }

        if(printAllAncestor(root.left, key) || printAllAncestor(root.right, key)) {
            return true;
        }

        pathFromRoot.remove(pathFromRoot.size()-1);
        return false;
    }
}
