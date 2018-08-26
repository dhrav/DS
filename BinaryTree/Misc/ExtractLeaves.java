package BinaryTree.Misc;

import BinaryTree.Node;

public class ExtractLeaves {
    static Node head = null;
    static Node tail = null;
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);
        System.out.println("Before change");
        inorder(root);
        extractLeaves(root);
        printList();
        System.out.println("After change");
        inorder(root);
    }

    private static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    private static void printList() {
        System.out.println();
        System.out.println("Extracted Leaves");
        Node current = head;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.right;
        }
        System.out.println();
    }

    private static boolean extractLeaves(Node root) {
        if(root == null) {
            return false;
        }

        if(root.left == null && root.right == null) {
            if(head == null) {
                head = root;
                tail = root;
            } else {
                tail.right = root;
                root.left = tail;
                tail = root;
            }
            return true;
        }

        boolean isLeftLeaf = extractLeaves(root.left);
        boolean isRightLeaf = extractLeaves(root.right);

        if(isLeftLeaf) {
            root.left = null;
        }

        if(isRightLeaf) {
            root.right = null;
        }

        return false;




    }
}
