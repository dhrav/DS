package BinaryTree.Construction;

public class PreorderPostorder {
    static int preIndex;
    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 8, 9, 5, 3, 6, 7};
        int[] postorder = {8, 9, 4, 5, 2, 6, 7, 3, 1};

        Node root = buildTree(preorder, postorder, 0, postorder.length-1, null);
        inorder(root);
    }

    private static Node buildTree(int[] preorder, int[] postorder, int low, int high, Node startNode) {
        if(low > high) {
            return null;
        }

        int data = preorder[preIndex++];
        startNode = new Node(data);

        if(low == high || preIndex >= preorder.length-1) {
            return startNode;
        }

        int childIdx = 0;


        int i = low;
        for(;i <= high; i++) {
            if(preorder[preIndex] == postorder[i]) {
                childIdx = i;
                break;
            } /*else if(preorder[preIndex-1] == postorder[i]) {
                rootIdx = i;
            }*/
        }

        startNode.left = buildTree(preorder, postorder, low,childIdx, startNode.left);
        startNode.right = buildTree(preorder, postorder, i+1, high, startNode.right);

        return startNode;


    }

    private static void inorder(Node root) {
        if(root== null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
}
