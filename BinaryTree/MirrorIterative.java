package BinaryTree;

import java.util.Stack;

public class MirrorIterative {
    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(3);
        root1.right = new Node(2);
        root1.right.left = new Node(5);
        root1.right.right = new Node(4);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);

        System.out.println(areMirror(root1, root2));
    }

    private static boolean areMirror(Node root1, Node root2) {
        if(root1 == null && root2 == null) {
            return true;
        }

        if(root1 == null || root2 == null) {
            return false;
        }

        //Iterative inorder traversal of a tree
        Stack<Node> stack1 = new Stack<>();
        Node current1 = root1;
        Stack<Node> stack2 = new Stack<>();
        Node current2 = root2;

        while(current1 != null && current2 != null) {
            while(current1 != null && current2 != null) {
                if(current1.data != current2.data) {
                    return false;
                }
                stack1.push(current1);
                stack2.push(current2);
                current1 = current1.left;
                current2 = current2.right;
            }

            if(!(current1 == null && current2 == null)) {
                return false;
            }

            while(!stack1.isEmpty() && current1 == null && !stack2.isEmpty() && current2 == null) {
                current1 = stack1.pop();
                //System.out.println(current1.data);
                current1 = current1.right;

                current2 = stack2.pop();
                //System.out.println(current2.data);
                current2 = current2.left;
            }

            if((current1 == null && current2 != null) || (current1 != null && current2 == null)) {
                return  false;
            }
        }
        return true;
    }
}
