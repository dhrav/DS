package BinaryTree;

public class FoldableBT {
    public static void main(String[] args) {
        /*Node root1 = new Node(10);
        root1.left = new Node(7);
        root1.right = new Node(15);
        root1.left.right = new Node(9);
        root1.right.left = new Node(11);*/

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

        Node root1 = new Node(10);
        root1.left = new Node(7);
        root1.right = new Node(15);
        root1.left.left = new Node(9);
        root1.left.right = new Node(10);
        root1.right.left = new Node(12);



        if(root1 == null || (root1.left == null && root1.right == null)) {
            System.out.println(true);
        }
        else {
            System.out.println(isFoldable(root1.left, root1.right));
        }
    }

    private static boolean isSingleNode(Node root) {
        return root.left == null && root.right == null;
    }

    private static boolean isFoldable(Node root1, Node root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        else if((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
            return false;
        }

        if(isSingleNode(root1) && isSingleNode(root2)) {
            return true;
        }

        boolean result;
        if((root1.left == null && root2.right != null) || (root1.right == null && root2.left != null))  {
            return false;
        }
        else {
            result = isFoldable(root1.left, root2.right) && isFoldable(root1.right, root2.left);

        }
        return result;
    }

}
