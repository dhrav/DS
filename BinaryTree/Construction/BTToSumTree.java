package BinaryTree.Construction;

public class BTToSumTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(-2);
        root.right = new Node(6);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);
        root.right.left = new Node(7);
        root.right.right = new Node(5);

        convertToSumTree(root);
        inorder(root);
    }

    private static int convertToSumTree(Node root) {
        if(root == null) {
            return 0;
        }

        int oldVal = root.data;

        root.data = convertToSumTree(root.left) + convertToSumTree(root.right);

        return oldVal + root.data;
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
