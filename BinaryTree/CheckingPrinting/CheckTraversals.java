package BinaryTree.CheckingPrinting;

import BinaryTree.Node;

public class CheckTraversals {
    static int preOrderIndex = 0;
    static int postOrderIndex = 0;
    public static void main(String[] args) {
        int inOrder[] = {4, 2, 5, 1, 3};
        int preOrder[] = {1, 2, 4, 5, 3};
       // int postOrder[] = {4, 5, 2, 3, 1};
        int postOrder[] = {4, 5, 2, 13, 1};

        Node root = null;
        root = buildTree(preOrder, inOrder, 0, inOrder.length-1, root);

        boolean result = traversePostOrder(postOrder, root);
        System.out.println(result);
    }

    private static boolean traversePostOrder(int[] postOrder, Node root) {
        if(root == null) {
            return true;
        }

        return traversePostOrder(postOrder, root.left) && traversePostOrder(postOrder, root.right) && (postOrder[postOrderIndex++] == root.data);
    }

    private static Node buildTree(int[] preOrder, int[] inOrder, int low, int high, Node root) {
        if(low > high || high > inOrder.length) {
            return null;
        }

        root = new Node(preOrder[preOrderIndex++]);
        int index;
        for(index = low; index <= high; index++) {
            if(inOrder[index] == root.data) {
                break;
            }
        }

        root.left = buildTree(preOrder, inOrder, low, index-1,  root.left);
        root.right = buildTree(preOrder, inOrder, index+1, high, root.right);

        return root;

    }
}
