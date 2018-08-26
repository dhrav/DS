package BinarySearchTree;

import BinaryTree.Node;

public class ConstructBSTFromPreorder {
    static int preOrderIndex;
    public static void main(String[] args) {
        int preorder[] = new int[]{10, 5, 1, 7, 40, 50};
        Node root = constructBST(preorder);
        inorder(root);
    }

    private static void inorder(Node root) {
        if(root== null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    private static Node constructBST(int[] preorder) {
        int low = 0, high = preorder.length-1;
        Node root = constructUtil(preorder, low, high);
        return root;
    }

    private static Node constructUtil(int[] preorder, int low, int high) {
        if(preOrderIndex < 0 || preOrderIndex > high || low > high) {
            return null;
        }



        Node root = new Node(preorder[preOrderIndex++]);
        //corner case - only one node left
        if(low == high) {
            return root;
        }

        int index = preOrderIndex;
        while (index < high && preorder[index] < root.data) {
            index++;
        }

        root.left = constructUtil(preorder, low, index-1);
        root.right = constructUtil(preorder, index, high);
        return root;
    }
}
