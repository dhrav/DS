package BinaryTree.Misc;

import BinaryTree.Node;

public class RemoveNodeOnPathLengthLessThanK {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(7);
        root.right.right = new Node(6);
        root.right.right.left = new Node(8);

        int k = 4;
        removeNodeIfPathLengthLessThanK(root, k);
    }

    private static void removeNodeIfPathLengthLessThanK(Node root, int k) {
        if(root == null) {
            return;
        }

        System.out.println("Before change");
        inorder(root);

        root = removeNodeUtil(root, k, 1);

        System.out.println("After Change");
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

    private static Node removeNodeUtil(Node root, int k, int curPathLength) {
        if(root == null) {
            return null;
        }

        root.left = removeNodeUtil(root.left, k, curPathLength + 1);
        root.right = removeNodeUtil(root.right, k, curPathLength + 1);

        if(root.left == null && root.right == null) {
            if(curPathLength < k) {
                return null;
            }
        }
        return root;
    }
}
