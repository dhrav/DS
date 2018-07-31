package BinaryTree.CheckingPrinting;

import BinaryTree.Node;

import java.util.Stack;

public class CheckPathInBT {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left    = new Node(3);
        root.right   = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.left.left.left = new Node(1);
        root.right.left = new Node(6);
        root.right.left.right = new Node(7);

        //int[] path = {5,3,4};
        //int[] path = {5,3};
        //int[] path = {5,8,6,7};
        int[] path = {5,8,6,17};

        System.out.println(checkForPath(root, path, new Stack<>()));
    }

    private static boolean checkForPath(Node root, int[] path, Stack<Integer> stack) {
        if(root == null) {
            return false;
        }

        stack.push(root.data);
        if(root.left == null && root.right == null) {
            if(stack.peek() == path[path.length-1]) {
                for(int i = path.length-1; i >= 0; i--) {
                    if(!stack.isEmpty()) {
                        if(stack.pop() != path[i]) {
                            return false;
                        }
                    }
                }
                if(stack.isEmpty()) {
                    return true;
                }
            }
        }

        boolean leftTreeResult = checkForPath(root.left, path, stack);
        boolean rightTreeResult = checkForPath(root.right, path,stack);
        if(!stack.isEmpty()) {
            stack.pop();
        }

        return leftTreeResult || rightTreeResult;
    }
}
