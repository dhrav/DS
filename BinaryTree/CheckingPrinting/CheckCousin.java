package BinaryTree.CheckingPrinting;

import BinaryTree.Node;

public class CheckCousin {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(15);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        Node node1,node2;
        node1 = root.left.left;
       // node2 = root.right.right;
        node2 = root.left.right;

        System.out.println(isCousin(root, node1, node2));
    }

    private static boolean isCousin(Node root, Node node1, Node node2) {
        int firstNodeLevel = findLevel(root, node1, 0);
        int secondNodeLevel = findLevel(root, node2, 0);
        return (firstNodeLevel == secondNodeLevel) && !isSibling(root,node1,node2);
    }

    private static boolean isSibling(Node root, Node node1, Node node2) {
        if(root == null) {
            return false;
        }

        return (root.left == node1 && root.right == node2) ||
                (root.left == node2 && root.right == node1) ||
                isSibling(root.left, node1, node2) ||
                isSibling(root.right, node1, node2);
    }

    private static int findLevel(Node root, Node node1, int level) {
        if(root == null) {
            return 0;
        }

        if(root.data == node1.data) {
            return level;
        }

        int leftSubTree = findLevel(root.left, node1, level+1);
        if(leftSubTree != 0) {
            return leftSubTree;
        }
        return  findLevel(root.right, node1, level+1);
    }
}
