package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;

public class CheckIfTwoBSTContainSameElements {
    static int index;
    public static void main(String[] args) {
        // First BST
        Node root1 = new Node(15);
        root1.left = new Node(10);
        root1.right = new Node(20);
        root1.left.left = new Node(5);
        root1.left.right = new Node(12);
        root1.right.right = new Node(25);

        // Second BST
        Node root2 = new Node(15);
        root2.left = new Node(12);
        root2.right = new Node(20);
        root2.left.left = new Node(5);
        root2.left.left.right = new Node(10);
        //root2.right.right = new Node(251);
        root2.right.right = new Node(25);

        System.out.println(checkIfSameElements(root1, root2));
    }

    private static boolean checkIfSameElements(Node root1, Node root2) {
        if(root1 == null && root2 == null) {
            return true;
        }

        if(root1 == null || root2 == null) {
            return false;
        }

        List<Integer> inorderList = new ArrayList<>();
        findInorderList(root1, inorderList);

        return isMatchingBSTElements(root2, inorderList);

    }

    private static boolean isMatchingBSTElements(Node root, List<Integer> inorderList) {
        if(root == null) {
            return true;
        }
        boolean result = true;

        boolean left = isMatchingBSTElements(root.left, inorderList);
        if(inorderList.get(index++) != root.data) {
            result = false;
        }
        boolean right = isMatchingBSTElements(root.right, inorderList);
        return result && left && right;
    }

    private static void findInorderList(Node root, List<Integer> inorderList) {
        if(root == null) {
            return;
        }

        findInorderList(root.left, inorderList);
        inorderList.add(root.data);
        findInorderList(root.right, inorderList);
    }
}
