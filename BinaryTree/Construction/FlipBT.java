package BinaryTree.Construction;

public class FlipBT {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        root = flipTree(root);
        inorder(root);
    }

    private static Node flipTree(Node root) {
        if(root == null || (root.left == null && root.right == null)) {
            return root;
        }

        Node flipRoot = flipTree(root.left);

        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;

        return flipRoot;
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
