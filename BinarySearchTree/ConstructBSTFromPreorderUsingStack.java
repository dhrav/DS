package BinarySearchTree;

import BinaryTree.Node;

import java.util.Stack;

public class ConstructBSTFromPreorderUsingStack {
    public static void main(String[] args) {
        int preorder[] = new int[]{10, 5, 1, 7, 40, 50};
        Node root = constructBST(preorder);
        inorder(root);
    }

    private static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    private static Node constructBST(int[] preorder) {
        Stack<Node> stack = new Stack<>();
        Node root = new Node(preorder[0]);
        stack.push(root);
        Node newNode = null;

        for(int i = 1; i < preorder.length; i++) {
            if(!stack.isEmpty()) {
                Node topElement = stack.peek();
                newNode = new Node(preorder[i]);
                if(topElement.data > preorder[i]) {
                    topElement.left = newNode;
                    stack.push(newNode);
                } else {
                    Node lastPoppedElement = null;
                    while(!stack.isEmpty() && (stack.peek()).data < preorder[i]) {
                        lastPoppedElement = stack.pop();
                    }
                    if(lastPoppedElement != null) {
                        lastPoppedElement.right = newNode;
                        stack.push(newNode);
                    }
                }
            }
        }
        return root;
    }
}
