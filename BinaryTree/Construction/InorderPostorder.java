package BinaryTree.Construction;

public class InorderPostorder {
    static int postOrderIndex;
    public static void main(String[] args) {
        /*int[] inorder = {2, 1, 3};
        int[] postorder = {2, 3, 1};*/

        int[] inorder = {4, 8, 2, 5, 1, 6, 3, 7};
        int[] postorder = {8, 4, 5, 2, 6, 7, 3, 1};

        Node root = null;
        int size = inorder.length;
        postOrderIndex = size-1;
        root = buildTree(inorder, postorder, 0, size-1, root);

        inorder(root);
    }

    private static Node buildTree(int[] inorder, int[] postorder, int low, int high, Node root) {
        if(low > high) {
            return null;
        }

        int data = postorder[postOrderIndex--];
        root = new Node(data);

        if(low == high || postOrderIndex < 0) {
            return root;
        }


        int i;
        for(i = low; i <= high; i++) {
            if(data == inorder[i]) {
                break;
            }
        }

        root.right = buildTree(inorder, postorder, i+1, high, root.right);
        root.left = buildTree(inorder, postorder, low, i-1, root.left);

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
