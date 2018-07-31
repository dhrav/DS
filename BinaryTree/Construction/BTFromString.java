package BinaryTree.Construction;

import java.util.Stack;

public class BTFromString {
    public static void main(String[] args) {
       // String treeRep = "1(2)(3)";
        String treeRep = "4(2(3)(1))(6(5))";
        Node root = null;
        root = buildTree(treeRep, root);
        preorder(root);
    }

    private static Node buildTree(String treeRep, Node root) {

        int length = treeRep.length();
        if(length<=0) {
            return null;
        }

        int data = Integer.parseInt(treeRep.substring(0,1));
        root = new Node(data);

        if(treeRep.length()== 1) {
            return root;
        }

        root.left = buildTree(getLeft(treeRep), root.left);
        root.right = buildTree(getRight(treeRep), root.right);
        return root;
    }

    private static String getLeft(String treeRep) {
        int startIndex = 1;
        int endIndex = treeRep.length();
        Stack<Character> stack = new Stack<>();
        int i;
        for(i = startIndex; i < endIndex; i++){
            if(treeRep.charAt(i) == '(') {
                stack.push(treeRep.charAt(i));
            } else if(treeRep.charAt(i) == ')') {
                stack.pop();
                if(stack.isEmpty()) {
                    break;
                }
            }
        }
        return treeRep.substring(2, i);
    }

    private static String getRight(String treeRep) {
        if(treeRep.lastIndexOf('(') == 1) {
            return "";
        }
        int endIndex = treeRep.length();
        Stack<Character> stack = new Stack<>();
        int i;
        for(i = endIndex-1; i >= 0; i--){
            if(treeRep.charAt(i) == ')') {
                stack.push(treeRep.charAt(i));
            } else if(treeRep.charAt(i) == '(') {
                stack.pop();
                if(stack.isEmpty()) {
                    break;
                }
            }
        }
        return treeRep.substring(i+1, endIndex-1);
    }

    private static void preorder(Node root) {
        if(root == null) {
            return;
        }

        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }
}
