package BinaryTree.Construction;

public class SpecialTreeFromPreorder {
    static int preIndex;

    public static void main(String[] args) {
        int[] preorder = {10, 30, 20, 5, 15};
        int[] preorderLN = {'N', 'N', 'L', 'L', 'L'};

        Node root = null;
        root = buildTree(preorder, preorderLN, preorder.length, root);
        inorder(root);
    }

    private static Node buildTree(int[] preorder, int[] preorderLN, int size, Node root) {
        if(preIndex >= size ) {
            return null;
        }

        root = new Node(preorder[preIndex]);
        if(preorderLN[preIndex] == 'L') {
            return root;
        } else {
            preIndex++;
            root.left = buildTree(preorder, preorderLN, size, root.left);
            preIndex++;
            root.right = buildTree(preorder, preorderLN, size, root.right);
        }

        return  root;    }


    private static void inorder(Node root) {
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
}
