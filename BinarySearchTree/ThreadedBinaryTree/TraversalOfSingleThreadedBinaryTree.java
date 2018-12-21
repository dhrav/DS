package BinarySearchTree.ThreadedBinaryTree;

public class TraversalOfSingleThreadedBinaryTree {
    static class Node {
        int data;
        boolean isRightThread;
        Node left, right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.isRightThread = false;
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
        root.left.right.isRightThread = true;

        root.right = new Node(8);
        root.right.left = new Node(7);

        root.right.left.right = root.right;
        root.right.left.isRightThread = true;

        root.right.right = new Node(11);
        root.right.right.left = new Node(9);

        root.right.right.left.right = root.right.right;
        root.right.right.left.isRightThread = true;

        root.right.right.right = new Node(13);

        inorder(root);

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

        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
}
