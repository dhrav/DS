package BinarySearchTree.ThreadedBinaryTree;

public class TraversalOfDoubleThreadedBinaryTree {
    static class Node {
        int data;
        boolean isRightThread;
        boolean isLeftThread;
        Node left, right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.isRightThread = false;
            this.isLeftThread = false;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.left.left = new Node(1);

        root.left.left.right = root.left;
        root.left.left.isRightThread = true;

        root.left.right = new Node(5);

        root.left.right.right = root;
        root.left.right.left = root.left;
        root.left.right.isRightThread = true;
        root.left.right.isLeftThread = true;

        root.right = new Node(8);
        root.right.left = new Node(7);

        root.right.left.right = root.right;
        root.right.left.left = root;
        root.right.left.isRightThread = true;
        root.right.left.isLeftThread = true;

        root.right.right = new Node(11);
        root.right.right.left = new Node(9);

        root.right.right.left.right = root.right.right;
        root.right.right.left.left = root.right;
        root.right.right.left.isRightThread = true;
        root.right.right.left.isLeftThread = true;

        root.right.right.right = new Node(13);
        root.right.right.right.left = root.right.right;
        root.right.right.right.isLeftThread = true;

        System.out.println("Inorder traversal is : ");
        inorder(root);

        System.out.println("Reverse Inorder traversal is :");
        reverseInorder(root);
    }

    private static void reverseInorder(Node root) {
        if(root == null) {
            return;
        }

        Node current = findRightMost(root);
        while(current != null) {
            System.out.println(current.data);
            if(current.isLeftThread) {
                current = current.left;
            } else {
                current = findRightMost(current.left);
            }
        }
    }

    private static Node findRightMost(Node root) {
        if(root == null) {
            return null;
        }
        while(root.right != null && !root.isRightThread) {
            root = root.right;
        }
        return root;
    }

    private static void inorder(Node root) {
        if(root == null) {
            return;
        }

        Node current = findLeftMost(root);
        while(current != null) {
            System.out.println(current.data);
            if(current.isRightThread) {
                current = current.right;
            } else {
                current = findLeftMost(current.right);
            }
        }
    }

    private static Node findLeftMost(Node root) {
        if(root == null) {
            return null;
        }

        while(root.left != null & !root.isLeftThread) {
            root = root.left;
        }
        return root;
    }
}
