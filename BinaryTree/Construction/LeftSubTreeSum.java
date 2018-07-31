package BinaryTree.Construction;

public class LeftSubTreeSum {
    public static void main(String[] args) {
      /*  Node root = new Node(10);
        root.left = new Node(-2);
        root.right = new Node(6);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);
        root.right.left = new Node(7);
        root.right.right = new Node(5);*/

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        convertToSumTree(root);
        inorder(root);
    }

    private static int convertToSumTree(Node root) {
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null) {
            return root.data;
        }

        int leftSum = convertToSumTree(root.left);
        int rightSum = convertToSumTree(root.right);

        root.data += leftSum;

        return root.data + rightSum;
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
