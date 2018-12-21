package BinarySearchTree.ThreadedBinaryTree;

public class InsertionInThreadedBST {
    static class Node {
        int data;
        boolean isLeftThreaded;
        boolean isRightThreaded;
        Node left, right;
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
            this.isLeftThreaded = this.isRightThreaded = false;
        }
    }
    static Node parent;
    public static void main(String[] args) {
        Node root = null;

        root = insert(root, 20);
        root = insert(root, 10);
        root = insert(root, 30);
        root = insert(root, 5);
        root = insert(root, 16);
        root = insert(root, 14);
        root = insert(root, 17);
        root = insert(root, 13);

        inorder(root);

    }

    private static Node insert(Node root, int key) {
        Node current = root;
        //iterative approach
        while(current != null) {
            if(current.data == key) {
                System.out.println("Duplicate key");
                return root;
            }

            parent = current;
            if(current.data < key) {
                if(current.isRightThreaded) {
                    break;
                } else {
                    current = current.right;
                }
            } else if(current.data > key) {
                if(current.isLeftThreaded) {
                    break;
                } else {
                    current = current.left;
                }
            }
        }

        Node newNode = new Node(key);
        newNode.isLeftThreaded = true;
        newNode.isRightThreaded = true;
        if(parent == null) {
            root = newNode;
            root.left = null;
            root.right = null;
        } else if(parent.data < key) {
            parent.isRightThreaded = false;
            newNode.right = parent.right;
            newNode.left = parent;
            parent.right = newNode;
        } else {
            parent.isLeftThreaded = false;
            newNode.left = parent.left;
            newNode.right = parent;
            parent.left = newNode;
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
            if(current.isRightThreaded) {
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

        while(root.left != null && !root.isLeftThreaded) {
            root = root.left;
        }
        return root;
    }
}
