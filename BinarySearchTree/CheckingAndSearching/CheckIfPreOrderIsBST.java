package BinarySearchTree.CheckingAndSearching;

import java.util.Stack;

public class CheckIfPreOrderIsBST {
    public static void main(String[] args) {
        //int pre1[] = {40, 30, 35, 80, 100};
        int pre1[] = {40, 30, 35, 20,  80, 100};
        System.out.println(checkIfBst(pre1) ? "true" : "false");
    }

    private static boolean checkIfBst(int[] preorder) {
        int size = preorder.length;
        Stack<Integer> nodeList = new Stack<>();
        int rootData = Integer.MIN_VALUE;
        for(int i = 0;i<size; i++) {
            if(preorder[i] < rootData) {
                return false;
            }

            if(!nodeList.isEmpty()) {
                while(!nodeList.isEmpty() && nodeList.peek() < preorder[i]) {
                    rootData = nodeList.pop();
                }
            }

            nodeList.push(preorder[i]);
        }
        return true;
    }
}
