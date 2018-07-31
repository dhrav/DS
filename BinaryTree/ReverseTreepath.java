package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class ReverseTreepath {
    static int nextPos;
    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(6);
        root.right = new Node(5);
        root.left.left = new Node(4);
        root.left.right = new Node(3);
        root.right.left = new Node(2);
        root.right.right = new Node(1);

        reverseTreepath(root, 4);
        inorder(root);
    }

    private static Node reverseTreepath(Node root, int data) {
        if(root == null) {
            return root;
        }

        int level = 0;
        int nextPos = 0;
        List<Integer> levelNodeList = new ArrayList<>();

      return reverseTreepathUtil(root, data, level, levelNodeList);
    }

    private static Node reverseTreepathUtil(Node root, int data, int level, List<Integer> levelNodeList) {
        if(root == null) {
            return null;
        }

        if(root.data == data) {
            levelNodeList.add(root.data);
            root.data = levelNodeList.get(nextPos);
            nextPos++;
            return root;
        }

        levelNodeList.add(root.data);
        Node leftSubTree = reverseTreepathUtil(root.left, data, level+1, levelNodeList);
        Node rightSubTree = null;
        if(leftSubTree == null) {
            rightSubTree = reverseTreepathUtil(root.right, data, level+1, levelNodeList);
        }

        if(leftSubTree != null || rightSubTree != null) {
            root.data = levelNodeList.get(nextPos);
            nextPos++;
            return leftSubTree != null ? leftSubTree : rightSubTree;
        }
        return null;

    }

    private static void inorder(Node result) {
        if(result == null) {
            return;
        }
        inorder(result.left);
        System.out.println(result.data);
        inorder(result.right);
    }
}
