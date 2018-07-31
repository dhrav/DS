package BinaryTree.Construction;

public class BTToChildrenSum {
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(7);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(1);
        root.right.right = new Node(30);

        Node temp = root;

        //before conversion
        System.out.println("Before conversion");
        inorder(temp);
        System.out.println("******************************");

        //convert the tree
        convertTree(root);

        //after conversion
        System.out.println("After conversion");
        inorder(root);
        System.out.println("******************************");
    }

    private static void convertTree(Node root) {
        if(root == null || (root.left == null && root.right == null)) {
            return;
        }

        convertTree(root.left);
        convertTree(root.right);
        int leftData = 0, rightData = 0, diff =0;

        if(root.left != null) {
            leftData = root.left.data;
        }

        if(root.right != null) {
            rightData = root.right.data;
        }

        diff = (leftData + rightData) - root.data;

        if(diff > 0) {
            root.data = root.data + diff;
        } else {
            increment(root, -diff);
        }

    }

    private static void increment(Node root, int diff) {
        if(root.left != null) {
            while(root.left != null) {
                root.left.data = root.left.data + diff;
                root = root.left;
            }
        } else if(root.right != null) {
            while(root.right != null) {
                root.right.data = root.right.data + diff;
                root = root.right;
            }
        }
    }

    private static void inorder(Node root) {
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
}
