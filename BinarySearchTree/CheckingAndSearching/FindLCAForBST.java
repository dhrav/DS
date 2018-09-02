package BinarySearchTree.CheckingAndSearching;

import BinaryTree.Node;

public class FindLCAForBST {
    public static void main(String[] args) {
        Node root        = new Node(20);
        root.left               = new Node(8);
        root.right              = new Node(22);
        root.left.left         = new Node(4);
        root.left.right        = new Node(12);
        root.left.right.left  = new Node(10);
        root.left.right.right = new Node(14);

        //int key1 = 10, key2 = 14;
        //int key1 = 14, key2 = 8;
        int key1 = 10, key2 = 22;
        Node lca = findLca(root, key1, key2);
        if(lca == null) {
            System.out.println("One / Both keys are not present");
        } else {
            System.out.println(lca.data);
        }
    }

    private static Node findLca(Node root, int key1, int key2) {
        if(root == null) {
            return null;
        }

        if(root.data == key1 || root.data == key2) {
            return root;
        }


        if(root.data < key1 && root.data < key2) {
            return findLca(root.right, key1, key2);
        } else if(root.data > key1 && root.data > key2) {
            return  findLca(root.left, key1, key2);
        }
        return root;
    }
}
