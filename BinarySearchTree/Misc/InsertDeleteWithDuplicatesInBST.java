package BinarySearchTree.Misc;

public class InsertDeleteWithDuplicatesInBST {
    static class Node {
        int data;
        int count;
        Node left, right;
        public Node(int data, int count) {
            this.data = data;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 12);
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 9);
        root = insert(root, 11);
        root = insert(root, 10);
        root = insert(root, 12);
        root = insert(root, 12);

        inorder(root);

        root = delete(root, 20);
        System.out.println("After deleting 20");
        inorder(root);

        root = delete(root, 12);
        System.out.println("After deleting 12");
        inorder(root);

        root = delete(root, 9);
        System.out.println("After deleting 9");
        inorder(root);

    }

    private static Node delete(Node root, int key) {
        if(root == null) {
            return null;
        }

        if(root.data == key) {
            if(root.count > 1) {
                root.count--;
                return root;
            } else {
                //leaf node
                if(root.left == null && root.right == null) {
                    return null;
                }
                //only one child
                if(root.right == null) {
                    root = root.left;
                } else if(root.left == null) {
                    root = root.right;
                } else {//both child
                    int temp = findMin(root.right);
                    root.right = delete(root.right, temp);
                    root.data = temp;
                }
            }
        } else if(root.data < key) {
            root.right = delete(root.right, key);
        } else {
            root.left = delete(root.left, key);
        }
        return root;
    }

    private static int findMin(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    private static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data + " with a count of " + root.count);
        inorder(root.right);
    }

    private static Node insert(Node root, int key) {
        if(root == null) {
            return new Node(key, 1);
        }

        if(root.data == key) {
            root.count++;
            return root;
        } else if(root.data < key) {
            root.right = insert(root.right, key);
        } else {
            root.left = insert(root.left, key);
        }
        return root;
    }
}
