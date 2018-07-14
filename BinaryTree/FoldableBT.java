package BinaryTree;

public class FoldableBT {
    public static void main(String[] args) {
        Node root1 = new Node(10);
        root1.left = new Node(7);
        root1.right = new Node(15);
        root1.left.right = new Node(9);
        root1.right.left = new Node(11);

/*        Node root1 = new Node(10);
        root1.left = new Node(7);
        root1.right = new Node(15);
        root1.left.left = new Node(9);
        root1.right.right = new Node(11);*/

/*        Node root1 = new Node(10);
        root1.left = new Node(7);
        root1.right = new Node(15);
        root1.left.left = new Node(5);
        root1.right.left = new Node(11);*/

     /*   Node root1 = new Node(10);
        root1.left = new Node(7);
        root1.right = new Node(15);
        root1.left.left = new Node(9);
        root1.left.right = new Node(10);
        root1.right.left = new Node(12);*/

        System.out.println(isFoldable(root1));
    }

    private static boolean isFoldable(Node root) {
        return isStructureSame(root, root);
    }

    private static boolean isStructureSame(Node root1, Node root2) {

        if(root1 == null && root2 == null) {
            return true;
        }

        if(root1 != null && root2 != null) {
            return isStructureSame(root1.left, root2.right) && isStructureSame(root1.right, root2.left);
        }

        return false;
    }

}
