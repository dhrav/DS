package BinaryTree.Construction;

public class PreorderPreorderMirror {
    static int preIndex;
    public static void main(String[] args) {
        int[] preorder = {1,2,4,5,3,6,7};
        int[] preorderMirror = {1,3,7,6,2,5,4};

        Node root = null;
        int[] postorder = getPostorder(preorderMirror);
        root = buildTree(preorder, postorder, 0, preorder.length-1, root );
        preorder(root);
    }

    private static int[] getPostorder(int[] preorderMirror) {
        int size = preorderMirror.length;
        int[] result = new int[size];
        int index = size -1 ;

        for(int i : preorderMirror) {
            result[index--] = i;
        }
        return  result;
    }

    private static Node buildTree(int[] preorder, int[] preorderMirror, int low, int high, Node root) {
        if(low > high) {
            return  null;
        }

        root = new Node(preorder[preIndex++]);

        if(low == high || preIndex >= preorder.length-1) {
            return root;
        }
        int i = low;


        for(; i <= high; i++) {
            if(preorder[preIndex] == preorderMirror[i]) {
                break;
            }
        }

        root.left = buildTree(preorder, preorderMirror, low, i-1, root.left);
        root.right = buildTree(preorder, preorderMirror, i+1, high, root.right);

        return root;
    }

    private static void preorder(Node root) {
        if(root == null){
            return;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }
}
