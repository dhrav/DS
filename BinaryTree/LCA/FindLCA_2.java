package BinaryTree.LCA;

import BinaryTree.Node;

public class FindLCA_2 {
    static boolean isNode1Present = false;
    static boolean isNode2Present = false;

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

       // Node lca = findLCA(root, 4, 5);
        Node lca = findLCA(root, 4, 10);
        if(lca != null) {
            System.out.println("LCA is " + lca.data);
        } else {
            System.out.println("one/both keys are not present");
        }
    }

    private static Node findLCA(Node root, int key1, int key2) {
        if(root == null) {
            return null;
        }

        Node lca = findLCAUtil(root, key1, key2);

        if(isNode2Present && isNode2Present) {
            return lca;
        }

        return null;
    }

    private static Node findLCAUtil(Node root, int key1, int key2) {
        if(root == null) {
            return null;
        }

        if(root.data == key1) {
            isNode1Present = true;
            return root;
        }

        if(root.data == key2) {
            isNode2Present = true;
            return root;
        }

        Node leftLca = findLCAUtil(root.left, key1, key2);
        Node rightLca = findLCAUtil(root.right, key1, key2);

        if(leftLca != null && rightLca != null) {
            return root;
        }

        return (leftLca == null) ?rightLca :leftLca;



    }
}
