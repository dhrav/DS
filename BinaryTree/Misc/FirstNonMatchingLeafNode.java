package BinaryTree.Misc;

import BinaryTree.Node;

import java.util.Stack;

public class FirstNonMatchingLeafNode {
    public static void main(String[] args) {
        Node root1 = new Node(5);
        root1.left = new Node(2);
        root1.right = new Node(7);
        root1.left.left = new Node(10);
        root1.left.right = new Node(11);
        root1.left.right.left = new Node(20);

        Node root2 = new Node(6);
        root2.left = new Node(10);
        root2.right = new Node(11);
        root2.right.left = new Node(19);

        //do iterative preorder of both the trees
        findNonMatchingLeaf(root1,root2);
    }

    private static void findNonMatchingLeaf(Node root1, Node root2) {
        if(root1 == null || root2 == null) {
            return;
        }

        Stack<Node> stack1 = new Stack();
        Stack<Node> stack2 = new Stack();

        stack1.push(root1);
        stack2.push(root2);

        while(!stack1.isEmpty() && !stack2.isEmpty()) {
            Node element1 = stack1.pop();

            while(element1 != null && !isLeaf(element1)) {
                stack1.push(element1.right);
                stack1.push(element1.left);
                element1 = stack1.pop();
            }

            Node element2 = stack2.pop();

            while(element2 != null && !isLeaf(element2)) {
                stack2.push(element2.right);
                stack2.push(element2.left);
                element2 = stack2.pop();
            }

            if(element1 != null && element2 != null) {
                if(element1.data != element2.data) {
                    System.out.println("The first non-matching leaf nodes are " + element1.data + " , " + element2.data);
                    return;
                }
            }
        }
    }

    private static boolean isLeaf(Node element) {
        return element.left == null && element.right == null;
    }
}
