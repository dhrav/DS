package BinarySearchTree.AVL;

public class Insertion {
    static class Node {
        int data;
        int height;
        Node left, right;
        public Node(int data, int height) {
            this.data = data;
            this.height = height;
            left = null;
            right = null;
        }
    }

    public static int height(Node node) {
        if(node == null) {
            return 0;
        }
        return node.height;
    }

    public static int getBalance(Node node) {
        return height(node.left) - height(node.right);
    }

    public static Node insert(Node root, int key) {
        if(root == null) {
           return new Node(key, 0);
        }

        if(key < root.data) {
            root.left = insert(root.left, key);
        } else if(key > root.data) {
            root.right = insert(root.right, key);
        } else {
            return root;
        }

        root.height = 1 + Math.max(height(root.left), height(root.right));
        int balance = getBalance(root);
        //left-left case
        if(balance > 1 && key < root.left.data) {
            return rightRotate(root);
        }
        //left-right case
        if(balance > 1 && key > root.left.data) {
            root.right = leftRotate(root.right);
            return leftRotate(root);
        }
        //right-right case
        if(balance < 1 && key > root.right.data) {
            return leftRotate(root);
        }

        //right-left case
        if(balance < 1 && key < root.right.data) {
            root.left = rightRotate(root.left);
            return leftRotate(root);
        }

        return root;
    }

    private static Node leftRotate(Node root) {
        Node y = root.right;
        Node leftTree = y.left;

        //Rotate the tree
        y.left = root;
        root.right = leftTree;

        //update heights
        y.height = 1 + Math.max(height(y.left), height(y.right));
        root.height = 1 + Math.max(height(root.left), height(root.right));

        return y;
    }

    private static Node rightRotate(Node root) {
        Node y = root.left;
        Node rightTree = y.right;

        //rotate the tree
        y.right = root;
        root.left = rightTree;

        //update the height
        y.height = 1 + Math.max(height(y.left), height(y.right));
        root.height = 1 + Math.max(height(root.left), height(root.right));

        return y;
    }

    private static void preorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        System.out.println("Preorder traversal of the constructed tree is:");
        preorder(root);


    }
}
