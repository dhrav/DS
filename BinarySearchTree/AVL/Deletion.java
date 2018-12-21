package BinarySearchTree.AVL;

public class Deletion {
    static class Node {
        int data;
        int height;
        Node left, right;
        public Node(int data) {
            this.data = data;
            left = right = null;
            height = 0;
        }
    }
    public static void main(String[] args) {
        //insert below nodes to binary tree and construct a balanced tree using AVL concept
        Node root = null;
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        preorder(root);

        System.out.println("Deleting 25");
        root = deleteKey(root, 25);
        preorder(root);

    }

    private static Node delete(Node root, int key) {
        Node current = root;
        while (current != null) {
            if (current.data == key) {
                return null;
            } else if (current.data < key) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return root;
    }

    private static Node deleteKey(Node root, int key) {
        if(root == null) {
            return null;
        }

        if(root.data == key) {
           if(isLeaf(root)) {
              return null;
           } else if(root.left == null) {
               root = root.right;
           } else if(root.right == null) {
               root = root.left;
           } else {
               int minRightSubTreeVal = findMin(root.right);
               root.data = minRightSubTreeVal;
               root.right = delete(root.right, minRightSubTreeVal);
           }
        } else if(root.data < key) {
            root.right = deleteKey(root.right, key);
        } else {
            root.left = deleteKey(root.left, key);
        }
        //balance the tree and return
        root.height = getHeight(root);
        int balanceFactor = getBalance(root);

        if(balanceFactor > 1) { // tree is Left heavy
            int leftBalanceFactor = getBalance(root.left);
            if(leftBalanceFactor > 1 ) { // LL case
                return rightRotate(root);
            } else { // LR case
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
        } else if(balanceFactor < -1) { //tree is right heavy
            int rightBalanceFactor = getBalance(root.right);
            if(rightBalanceFactor > 1) { // RL case
                root.right = rightRotate(root.right);
                return leftRotate(root);
            } else { //RR case
                return leftRotate(root);
            }
        }
        return root;
    }

    private static int findMin(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    private static void preorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }
    private static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        } else if (root.data < key) {
            root.right = insert(root.right, key);
        } else if (root.data > key) {
            root.left = insert(root.left, key);
        } else {
            return root;
        }

        root.height = getHeight(root);
        int balanceFactor = getBalance(root);

        if (balanceFactor > 1) { // the tree is left heavy
            //determine whether LL case or LR case
            int leftChildBalanceFactor = getBalance(root.left);
            if (leftChildBalanceFactor > 1) { //LL case
                return rightRotate(root);
            } else { //LR Case
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
        } else if (balanceFactor < -1)  { //the tree is right heavy
            //determine whether RR case or RL case
            int rightChildBalanceFactor = getBalance(root.right);
            if (rightChildBalanceFactor > 1) { //RL case
                root.right = rightRotate(root.right);
                return leftRotate(root);
            } else { //RR case
                return leftRotate(root);
            }
        }
        return root;
    }

    private static Node leftRotate(Node root) {
        Node y = root.right;
        Node leftTree = y.left;

        //rotate the tree
        y.left = root;
        root.right = leftTree;

        //update the height
        y.height  = getHeight(y);
        root.height = getHeight(root);
        return y;
    }

    private static Node rightRotate(Node root) {
        Node y = root.left;
        Node rightTree = y.right;

        //rotate the tree
        y.right = root;
        root.left = rightTree;

        //update the height
        y.height  = getHeight(y);
        root.height = getHeight(root);
        return y;
    }

    private static int getHeight(Node root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private static int getBalance(Node root) {
        return height(root.left) - height(root.right);
    }

    private static int height(Node root) {
        return root == null ? 0: root.height;
    }

    private static boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }
}
