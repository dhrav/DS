package BinarySearchTree.Misc;

import BinaryTree.Node;

public class ChangeKeyInBST {
    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 70);
        root = insert(root, 60);
        root = insert(root, 80);
        System.out.println("Before change");
        inorder(root);

        root = changeKey(root, 40, 10);

        System.out.println("After change");
        inorder(root);
    }

    private static Node changeKey(Node root, int oldVal, int newVal) {
        if(root == null) {
            return new Node(newVal);
        }

        root = delete(root, oldVal);
        root = insert(root, newVal);
        return root;
    }

    private static Node delete(Node root, int key) {
        if(root == null) {
            return null;
        }

        if(root.data == key) {
            if(root.left == null && root.right == null) {
                return null;
            } else {
                if(root.right != null) {
                    int temp = findMin(root.right);
                    root.data = temp;
                    root.right = delete(root.right, temp);
                }
            }
        } else if(root.data > key) {
            root.left = delete(root.left, key);
        } else {
            root.right = delete(root.right, key);
        }
        return root;

    }

    private static int findMin(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root.data;
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
