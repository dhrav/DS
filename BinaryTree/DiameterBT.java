package BinaryTree;

public class DiameterBT {
    static int result;
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        findDiameter(root);

        System.out.println(result);
    }

    private static int findDiameter(Node root) {
        if(root == null) {
            return 0;
        }

        int leftHeight = findDiameter(root.left);
        int rightHeight = findDiameter(root.right);

        int currentHeight = 1 + leftHeight + rightHeight;

        result = (result < currentHeight) ? currentHeight : result;
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
