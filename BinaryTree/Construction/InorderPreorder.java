package BinaryTree.Construction;

public class InorderPreorder {
    static int preIndex=0;
    public static void main(String[] args) {
        int[] inorder = {7,11,10,15,9,8};
        int[] preorder = {10,11,7,9,15,8};

        Node root = buildTree(inorder, preorder, 0, inorder.length-1);
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

    private static Node buildTree(int[] inorder, int[] preorder, int low, int high) {
        if (low > high) {
            return null;
        } else if(low == high) {
            return new Node(preorder[preIndex++]);
        }

        Node root = new Node(preorder[preIndex++]);
        int i = low;
        for(; i <= high; i++) {
            if(inorder[i] == root.data) {
                break;
            }
        }
        root.left = buildTree(inorder, preorder, low, i-1);
        root.right = buildTree(inorder, preorder, i+1, high);

        return root;

    }
}
