package BinarySearchTree;

import BinaryTree.Node;

public class InsertAndSearch {
    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 30);
        inorder(root);
        System.out.println();
        root = insert(root, 20);
        inorder(root);
        System.out.println();
        root = insert(root, 40);
        inorder(root);
        System.out.println();
        root = insert(root, 70);
        inorder(root);
        System.out.println();
        root = insert(root, 60);
        inorder(root);
        System.out.println();
        root = insert(root, 80);
        inorder(root);
        System.out.println();

        System.out.println(searchInBST(root, 80));
        System.out.println(searchInBST(root, 89));
        System.out.println(searchInBST(root, 20));

        System.out.println("Deleting 80");
        root = delete(root, 80);//Node at leaf
        inorder(root);
        System.out.println();

        System.out.println("Deleting 40");
        root = delete(root, 40); //Node with one child
        inorder(root);
        System.out.println();

        System.out.println("Deleting 30");
        root = delete(root, 30); //Node with two children
        inorder(root);
        System.out.println();
    }

    private static Node delete(Node root, int i) {
        if(root == null) {
            return null;
        }

        if(root.data == i) {
            //leaf node
            if(root.left == null && root.right == null) {
                return null;
            } else if( root.left == null) { //Node with one child
                return root.right;
            } else if(root.right == null) {
                return root.left;
            } else { //Node with two children
                int minValue = findMin(root.right);
                root.data = minValue;
                root.right = delete(root.right, minValue);

            }
        } else if(root.data < i) {
            root.right = delete(root.right, i);
        } else {
            root.left = delete(root.left, i);
        }
        return root;
    }

    private static int findMin(Node root) {
        int minValue = root.data;

        while(root != null) {
            minValue = root.data;
            root = root.left;
        }

        return minValue;

    }

    private static void inorder(Node root) {
        if(root== null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    private static boolean searchInBST(Node root, int i) {
        if(root == null) {
            return false;
        }

        if(root.data == i) {
            return true;
        }
        boolean result;
        if(root.data > i) {
            result = searchInBST(root.left, i);
        } else {
            result = searchInBST(root.right, i);
        }
        return result;
    }


    private static Node insert(Node root, int i) {
        if(root== null) {
            return new Node(i);
        }

        if(root.data > i) {
            root.left = insert(root.left, i);
        } else if(root.data < i) {
            root.right = insert(root.right, i);
        }

        return root;
    }
}
