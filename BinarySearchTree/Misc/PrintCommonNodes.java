package BinarySearchTree.Misc;

import BinaryTree.Node;

import java.util.Stack;

public class PrintCommonNodes {
    public static void main(String[] args) {
        // Create first tree as shown in example
        Node root1 = null;
        root1 = insert(root1, 5);
        root1 = insert(root1, 1);
        root1 = insert(root1, 10);
        root1 = insert(root1,  0);
        root1 = insert(root1,  4);
        root1 = insert(root1,  7);
        root1 = insert(root1,  9);

        // Create second tree as shown in example
        Node root2 = null;
        root2 = insert(root2, 10);
        root2 = insert(root2, 7);
        root2 = insert(root2, 20);
        root2 = insert(root2, 4);
        root2 = insert(root2, 9);

        System.out.println("Tree1");
        inorder(root1);

        System.out.println("Tree2");
        inorder(root2);

        printCommonNodes(root1, root2);
    }

    private static void printCommonNodes(Node root1, Node root2) {
        if(root1 == null || root2 == null) {
            return;
        }

        //iterative inorder traversal
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        Node current1 = root1;
        Node current2 = root2;
        System.out.println("Printing the common nodes");
        while(true) {
            if(current1 != null || current2 != null) {
                if(current1 != null) {
                    while(current1 != null) {
                        stack1.push(current1);
                        current1 = current1.left;
                    }
                }

                if(current2 != null) {
                    while(current2 != null) {
                        stack2.push(current2);
                        current2 = current2.left;
                    }
                }
            } else {
                if(stack1.isEmpty()) {
                   break;
                } else if(stack2.isEmpty()) {
                    break;
                }

                Node firstTreeNode = stack1.pop();
                Node secondTreeNode= stack2.pop();

                if(firstTreeNode.data == secondTreeNode.data) {
                    System.out.println(firstTreeNode.data);
                    current1 = firstTreeNode.right;
                    current2 = secondTreeNode.right;
                } else if(firstTreeNode.data < secondTreeNode.data) {
                    current1 = firstTreeNode.right;
                    stack2.push(secondTreeNode);
                } else {
                    current2 = secondTreeNode.right;
                    stack1.push(firstTreeNode);
                }
            }

        }

    }

    private static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }


    private static Node insert(Node root, int key) {
        if(root == null) {
            return new Node(key);
        }

        if(root.data < key) {
            root.right = insert(root.right, key);
        } else if(root.data > key) {
            root.left = insert(root.left, key);
        }
        return root;
    }
}
