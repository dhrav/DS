package BinaryTree;

public class MirrorBT {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
       // root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        if(root == null || isSingleNode(root))
        {
            System.out.println(true);
        }
        else {
            System.out.println(isMirror(root.left, root.right));
        }
    }

    public static boolean isSingleNode(Node root) {
        return root.left == null && root.right == null;
    }

    private static boolean isMirror(Node root1, Node root2) {
        if(root1 == null && root2 == null) {
            return true;
        }

        if((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
            return false;
        }

        if(root1.data != root2.data) {
            return false;
        }


        boolean result;
        if((root1.left == null && root2.right != null) || (root1.right == null && root2.left != null)) {
            return false;
        }
        else {
            result = isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
        }


        return result;

    }
}
