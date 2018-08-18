package BinaryTree.Misc;

import BinaryTree.Node;

public class SwapNodesAtKLevel {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(8);
        root.right.left = new Node(7);

        System.out.println("Before change");
        inorder(root);

       int k = 2;
       int level = 0;
        root = swapNode(root, k, level);

        System.out.println("After change");
        inorder(root);
    }

    private static Node swapNode(Node root, int k, int level) {
        if(root == null) {
            return null;
        }

        root.left = swapNode(root.left, k, level+ 1);
        root.right = swapNode(root.right, k, level+ 1);

        if((level % k) == 0 ) {
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        }


        return root;
    }

    private static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }


}
