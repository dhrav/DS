package BinaryTree.Construction;

public class SpecialTreeFromInorder {
    public static void main(String[] args) {
        int[] inorder = {5, 10, 40, 30, 28};
        Node root = null;
        root = buildTree(inorder, root, 0, inorder.length-1);
        inorder(root);
    }

    private static Node buildTree(int[] inorder, Node root, int low, int high) {
        if(low > high) {
            return null;
        }
        int max = low;
        for(int i=low; i <= high; i++) {
            if(inorder[max] < inorder[i]) {
                max = i;
            }
        }

        root = new Node(inorder[max]);
        if(low == high) {
            return root;
        }

        root.left = buildTree(inorder, root.left, low, max-1);
        root.right = buildTree(inorder, root.right, max+1, high);

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
